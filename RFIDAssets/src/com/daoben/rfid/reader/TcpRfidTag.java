package com.daoben.rfid.reader;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.daoben.rfid.service.AssetWarnService;
import com.daoben.rfid.service.IoLibraryService;
import com.daoben.rfid.service.ReadeIoTimeService;
import com.daoben.rfid.utils.ToStringSixteen;

@Service
public class TcpRfidTag { // 创建类MyTcp
	@Resource
	private ToStringSixteen toStringSixteen;

	@Resource
	private ReaderFunction readerFunction;

	@Resource
	private AssetWarnService asw;

	@Resource
	private IoLibraryService ioLibraryService;

	@Resource
	private ReadeIoTimeService readeIoTimeService;

	static Set<String> setTagId = new HashSet<String>();

	static ServerSocket sendRfidWarn = null;

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * 读取RFID标签休眠时间调整
	 */
	public void delay_ms(int time) {
		try {
			Thread.sleep(time);// s
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 进出库判断RFID
	 */
	public void getRfidInOut(int serverPort) {
		// Create a server socket to accept client connection request
		ServerSocket servSocket = null;
		Socket clientSocket = null;
		InputStream in = null;
		int recvMsgSize = 0;
		byte[] receivBuf = new byte[20];
		try {
			servSocket = new ServerSocket(serverPort);// 创建服务套接字
			while (true) {
				log.info("等待客户端连接");
				clientSocket = servSocket.accept();// 等待客户机连接，创建新的socket和客户端连接
				SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();
				System.out.println("Handling client at " + clientAddress);
				in = clientSocket.getInputStream();
				// OutputStream out = clientSocket.getOutputStream();
				while ((recvMsgSize = in.read(receivBuf)) != -1) {
					// String recString = new String(receivBuf, "ISO-8859-1");
					// System.out.println("显示字符串"+recString);// 获取收集数据
					String recString = toStringSixteen.ByteToStriong(receivBuf);// 接收16进制数据
					String rfidheart = recString.substring(8, 10);// 获取读写器心跳包时间
					if (rfidheart.equals("63")) {
						log.warn("进出库心跳包" + rfidheart);
						clientSocket.setSoTimeout(60000);// 设置超时时就断开连接
						readeIoTimeService.updateReadeIoTim("55555");// 更新进出库心跳包
						continue;
					}
					if (recvMsgSize == 20) {
						String firstFlag = recString.substring(0, 4);// 获取TCP首标志
						String finalFlag = recString.substring(36, 40);// 获取TCP尾标志
						String Flag = firstFlag.concat(finalFlag); // 整合首尾标志
						if (Flag.equals("7f7f7f7f")) {
							delay_ms(500);// 延时500ms
							// log.info("首尾标志正确");
							// String RfidId = recString.substring(4, 8);//
							// 获取读写器的id号

							String RfidRSSI = recString.substring(30, 32);// 获取读写器的id号
							System.out.println(RfidRSSI);
							/******** 获取标签信号量 ********/
							int RSSI = Integer.parseInt(RfidRSSI, 16);// 获取信号量
							log.info("进出库读写器id:" + RSSI);
							/******** 获取标签ID号 ********/
							String Htag_id = recString.substring(20, 22);// 标签id高字节
							String Ltag_id = recString.substring(18, 20);// 标签id低字节
							String Hexttag_id = Htag_id.concat(Ltag_id); // 整合标签号
							int tag_id = Integer.parseInt(Hexttag_id, 16);// 获取标签ID号

							/******** 获取标签电量状态 ********/
							String HexElectric = recString.substring(22, 24);// 获取标签id状态字节
							String Electric = toStringSixteen.HexStringToTwobinary(HexElectric);// 将16进制转换成2进制
							String BElectric = Electric.substring(0, 1);// 标签电量位数
							int BBElectric = Integer.valueOf(BElectric, 2);//

							/******** 打印log ********/
							// log.info("8082客户端数据：" + recString);
							// log.info("8082标签电量：" + BBElectric);
							log.info("8082标签Tag_Id：" + tag_id);

							float tagIdRSSI = ClacRssi(RSSI);// 获取信号量
							log.info("8082标签信号量：" + tagIdRSSI);// 获取信号量
							readerFunction.insertAssetInOutLibraryInfo(tag_id, BBElectric, tagIdRSSI);// 入库和出库
							readerFunction.MonitorWarnInfo(tag_id);// 监控出库报警和插入报警信息，并做出推送

							boolean flag = setTagId.contains(tag_id + "");// 查询盘点是否存在
							if (!flag) {// true存在，false不存在则进行相应操作
								readerFunction.insertAssetInOutLibraryInfo(tag_id, BBElectric, tagIdRSSI);// 入库和出库
								readerFunction.MonitorWarnInfo(tag_id);// 监控出库报警和插入报警信息，并做出推送
							}
						}
					}
					// out.write(receivBuf, 0, recvMsgSize);//回写数据
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.warn("8082读写器连接异常，从新连接");
		} finally {
			try {
				// 关闭资源
				if (servSocket != null) {
					servSocket.close();
				}
				if (clientSocket != null) {
					clientSocket.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 盘点RFID
	 */
	public void getRfidMonitor(int serverPort) {
		// Create a server socket to accept client connection request
		ServerSocket servSocket = null;
		Socket clientSocket = null;
		InputStream in = null;
		int recvMsgSize = 0;
		int monitorTime = 0;
		byte[] receivBuf = new byte[20];
		try {
			servSocket = new ServerSocket(serverPort);
			while (true) {
				log.info("等待客户端连接");
				clientSocket = servSocket.accept();
				SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();
				System.out.println("Handling client at " + clientAddress);
				in = clientSocket.getInputStream();
				// OutputStream out = clientSocket.getOutputStream();
				// receive until client close connection,indicate by -l return
				while ((recvMsgSize = in.read(receivBuf)) != -1) {
					// String recString = new String(receivBuf, "ISO-8859-1");//
					// System.out.println("显示字符串"+recString);// 获取收集数据
					String recString = toStringSixteen.ByteToStriong(receivBuf);// 接收16进制数据
					String rfidheart = recString.substring(0, 8);// 获取读写器心跳包时间
					if (rfidheart.equals("7f7f0001")) {
						log.warn("盘点心跳包" + rfidheart);
						clientSocket.setSoTimeout(60000);// 设置超时时就断开连接
						readeIoTimeService.updateReadeIoTim("66666");// 更新盘点心跳包
					}
					if (recvMsgSize == 20) {
						String firstFlag = recString.substring(0, 4);// 获取TCP首标志
						String finalFlag = recString.substring(36, 40);// 获取TCP尾标志
						String Flag = firstFlag.concat(finalFlag); // 整合首尾标志
						if (Flag.equals("7f7f7f7f")) {
							// delay_ms(5000);// 5s
							// log.info("首尾标志正确");
							String RfidId = recString.substring(4, 8);// 获取读写器的id号
							log.info("盘点读写器id:" + RfidId);
							/******** 获取标签ID号 ********/
							String Htag_id = recString.substring(20, 22);// 标签id高字节
							String Ltag_id = recString.substring(18, 20);// 标签id低字节
							String Hexttag_id = Htag_id.concat(Ltag_id); // 整合标签号
							int tag_id = Integer.parseInt(Hexttag_id, 16);// 获取标签ID号

							/******** 获取标签电量状态 ********/
							String HexElectric = recString.substring(22, 24);// 获取标签id状态字节
							String Electric = toStringSixteen.HexStringToTwobinary(HexElectric);// 将16进制转换成2进制
							String BElectric = Electric.substring(0, 1);// 标签电量位数
							int BBElectric = Integer.valueOf(BElectric, 2);// 将
							// log.info("8083客户端数据：" + recString);
							// log.info("8083标签电量：" + BElectric);
							log.info("8083标签Tag_Id：" + tag_id);
							log.info("8083标签电量：" + BBElectric);
							setTagId.add(tag_id + "");// list获取标签id
							// readerFunction.updateRealTimeInfo(tag_id,
							// BBElectric);// 更新盘点标签时间和监控电量
							// monitorTime++;
							// if (monitorTime == 120) {// 1小时盘一次12 * 30
							// log.warn("盘点启动");
							// readerFunction.MonitorTagIdLose();// 盘点丢失
							// readerFunction.insertAssetIoNumberInfo();//
							// 记录盘点丢失信息
							// // 查询丢失报警，并且插入报警表中
							// monitorTime = 0;
							// log.warn("盘点结束");
							// }
							// readerFunction.MonitoRelectricInfo(tag_id);//
							// 查询电量报警

						}
					}
					// out.write(receivBuf, 0, recvMsgSize);//回写数据
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			log.warn("8083读写器连接异常，从新连接");
		} finally {
			try {
				// 关闭资源
				// 关闭资源
				if (servSocket != null) {
					servSocket.close();
				}
				if (clientSocket != null) {
					clientSocket.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateRfidWarnInfo() {
		int monitorTime = 0;
		List<String> listTagId = new ArrayList<String>();
		while (true) {
			delay_ms(15000);// 20s
			listTagId.addAll(setTagId);// 转换成list值
			readerFunction.updateAllRealTimeInfo(listTagId);// 插入所有标签信息
			setTagId.clear();
			listTagId.clear();
			monitorTime++;
			if (monitorTime == 90) {// 半小时盘一次30 * 20*3
				log.warn("盘点启动");
				readerFunction.MonitorTagIdLose();// 盘点丢失
				readerFunction.insertAssetIoNumberInfo();// 记录盘点丢失信息
				// 查询丢失报警，并且插入报警表中
				monitorTime = 0;
				log.warn("盘点结束");
			}
		}
	}

	public static float ClacRssi(float fRssi) {
		// 对RSSI进行换算
		if (fRssi >= 128) {
			fRssi = (fRssi - 256) / 2 - 79;
		} else {
			fRssi = fRssi / 2 - 79;
		}
		return fRssi;
	}

}
