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
public class NewRfidTag { // 创建类MyTcp
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

	@Resource
	private ConnReadermplNew connReadermplNew;

	static private Set<String> setTagId = new HashSet<String>();// 读写器读到数据

	static private Set<String> setTagIdTwo = new HashSet<String>();// 获取读写器二次数据

	static private List<String> listTagDiffer = new ArrayList<String>();// 差异数据记录

	static private int countflag = 0;

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
	 * 进出库判断RFID 215读写器心跳包63
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
						log.warn("215心跳包" + rfidheart);
						clientSocket.setSoTimeout(60000);// 设置超时时就断开连接
					}
					if (recvMsgSize == 20) {
						String firstFlag = recString.substring(0, 4);// 获取TCP首标志
						String finalFlag = recString.substring(36, 40);// 获取TCP尾标志
						String Flag = firstFlag.concat(finalFlag); // 整合首尾标志
						if (Flag.equals("7f7f7f7f")) {
							/******** 获取标签ID号 ********/
							String Htag_id = recString.substring(20, 22);// 标签id高字节
							String Ltag_id = recString.substring(18, 20);// 标签id低字节
							String Hexttag_id = Htag_id.concat(Ltag_id); // 整合标签号
							int tag_id = Integer.parseInt(Hexttag_id, 16);// 获取标签ID号
							// log.info("8082标签Tag_Id：" + tag_id);
							setTagId.add(tag_id + "");// list获取标签id
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
	 * 进出库判断216RFID 216读写器心跳包7f7f0001
	 */
	public void getRfidInOutA(int serverPort) {
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
					String rfidheart = recString.substring(0, 8);// 获取读写器心跳包时间
					if (rfidheart.equals("7f7f0001")) {// 216读写器
						log.warn("216心跳包" + rfidheart);
						clientSocket.setSoTimeout(60000);// 设置超时时就断开连接
					}
					if (recvMsgSize == 20) {
						String firstFlag = recString.substring(0, 4);// 获取TCP首标志
						String finalFlag = recString.substring(36, 40);// 获取TCP尾标志
						String Flag = firstFlag.concat(finalFlag); // 整合首尾标志
						if (Flag.equals("7f7f7f7f")) {
							/******** 获取标签ID号 ********/
							String Htag_id = recString.substring(20, 22);// 标签id高字节
							String Ltag_id = recString.substring(18, 20);// 标签id低字节
							String Hexttag_id = Htag_id.concat(Ltag_id); // 整合标签号
							int tag_id = Integer.parseInt(Hexttag_id, 16);// 获取标签ID号
							// log.info("8083标签Tag_Id：" + tag_id);
							setTagId.add(tag_id + "");// list获取标签id
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
		List<String> listTagIn = new ArrayList<String>();// 不包含数据
		List<String> listTagOut = new ArrayList<String>();// 不包含数据
		while (true) {
//			setTagId.add("22969");
//			setTagId.add("22999");
//			setTagId.add("24558");
//			setTagId.add("24684");
//			setTagId.add("24574");
//			setTagId.add("24629");
//			setTagId.add("24566");
//			setTagId.add("22928");
//			setTagId.add("22958");
//			setTagId.add("22968");// 10
//			setTagId.add("22970");
//			setTagId.add("22988");
//			setTagId.add("22989");// 13
//			setTagId.add("22991");
//			setTagId.add("22994");
//			setTagId.add("22995");
//			setTagId.add("22998");
//			setTagId.add("23003");
//			setTagId.add("23004");
//			setTagId.add("24556");
//			setTagId.add("24557");
//			setTagId.add("24559");
//			setTagId.add("24560");
//			setTagId.add("24565");
//			setTagId.add("10002");// 25
//			setTagId.add("24575");
//			setTagId.add("24597");
//			setTagId.add("24567");
//			setTagId.add("24568");
//			setTagId.add("24569");//30
//			setTagId.add("24576");
//			setTagId.add("24577");
//			setTagId.add("24578");
//			setTagId.add("24594");
//			setTagId.add("24595");
//			setTagId.add("24596");
//			setTagId.add("24606");
//			setTagId.add("24607");
//			setTagId.add("24608");
//			setTagId.add("24616");//40
//			setTagId.add("24617");
//			setTagId.add("24618");
//			setTagId.add("24628");
//			setTagId.add("24630");
//			setTagId.add("24631");
//			setTagId.add("24632");
//			setTagId.add("24685");
//			setTagId.add("24682");
//			setTagId.add("24671");
//			setTagId.add("24668");
//			setTagId.add("24659");
//			setTagId.add("24660");
//			setTagId.add("24661");//53
//			setTagId.add("24657");
//			setTagId.add("24658");
//			setTagId.add("24651");
//			setTagId.add("24652");
//			setTagId.add("24653");
//			setTagId.add("24649");
//			setTagId.add("24650");//60
//			setTagId.add("24640");
//			setTagId.add("24641");
//			setTagId.add("24636");
//			setTagId.add("24637");
//			setTagId.add("24638");//65
//			setTagId.add("24670");
//			setTagId.add("24598");
//			setTagId.add("24645");//找不到标签
//			setTagId.add("22959");


			delay_ms(30000);// 20s
			log.warn("开启监控处理");
			int counttag = setTagId.size();
			int counttagTwo = setTagIdTwo.size();
			log.warn("读写器读到标签数：" + counttag);
			log.warn("读写器缓存标签数：" + counttagTwo);
			listTagIn = getDiffrent(setTagId, setTagIdTwo);// 第一次和第二次做对比，获取第二次没有数据，做入库处理
			log.warn("再次入库数据：" + listTagOut);
			if (listTagIn.size() > 0) {// 如果存在差异数据，则做进库处理
				readerFunction.insertAssetInLibraryInfoNew(listTagIn);// 设备入库
				listTagIn.clear();// 清空进出差异数据
				listTagDiffer.clear();// 清空返回数据
			}
			listTagOut = getDiffrent(setTagIdTwo, setTagId);// 第二次和第一次做对比，获取第一次没有数据，做出库处理
			log.warn("出库报警数据：" + listTagOut);
			if (listTagOut.size() > 0) {
				readerFunction.insertAssetOutLibraryInfoNew(listTagOut);// 设备出库和报警
				listTagOut.clear();// 清空出库差异数据
				listTagDiffer.clear();// 清空返回数据
			}
			log.warn("监控处理结束");
		}
	}

	public List<String> getDiffrent(Set<String> set1, Set<String> set2) {
		for (String str : set1) {
			if (!set2.contains(str)) {
				listTagDiffer.add(str);// 读写器读到数据多出的数据
			}
		}
		countflag++;
		if (countflag == 2) {
			setTagIdTwo.clear();// 将第二次清空
			setTagIdTwo.addAll(setTagId);// 将第一次的值复制给第二次
			setTagId.clear();// 将第一次清空
			countflag = 0;
		}
		return listTagDiffer;
	}
}
