package com.daoben.rfid.reader;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import com.daoben.rfid.common.push.JPushManager;
import com.daoben.rfid.model.AssetDeviceInfo;
import com.daoben.rfid.service.AssetDeviceInfoService;
import com.daoben.rfid.service.ReadeIoTimeService;

/**
 * @author Administrator
 */
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration({ "/applicationContext.xml" })
@Service
public class ConnReadermplNew implements ApplicationContextAware {

	@Resource
	private NewRfidTag newRfidTag;

	static int flagStart = 0;

	private Logger log = Logger.getLogger(this.getClass());

	public volatile static Thread ReaderOut;// 出库读写器
	public volatile static Thread ReaderIn;// 出库读写器
	private volatile Thread MonitorWarn;// 监控报警信息

	/**
	 * 读取RFID标签休眠时间调整
	 */
	public void delay_ms(int time) {
		try {
			Thread.sleep(time);// ms
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void getMonitorWarn() {
		MonitorWarn = new Thread(new Runnable() {
			int count = 0;

			@Override
			public void run() {
				log.info("TCP启动盘点线程");// run的方法体代表要执行的任务
				while (true) {
					newRfidTag.updateRfidWarnInfo();// 监控进出库报警
					delay_ms(10000);// 10s休眠时间
				}
			}
		});
		if (MonitorWarn.isAlive() == false) {// 判断线程是否启动
			MonitorWarn.setDaemon(true);//
			MonitorWarn.start();//
			MonitorWarn.setPriority(6);// 优先级高
		}

	}

	public void getReaderIn(int serverPort) {
		ReaderIn = new Thread(new Runnable() {
			@Override
			public void run() {
				log.info("TCP启动进出库线程");// run的方法体代表要执行的任务
				while (true) {
					newRfidTag.getRfidInOut(serverPort);
					delay_ms(10000);// 10s休眠时间
				}
			}
		});
		if (ReaderIn.isAlive() == false) {// 判断线程是否启动
			ReaderIn.setDaemon(true);//
			ReaderIn.start();//
			ReaderIn.setPriority(4);
		}

	}

	public void getReaderOut(int serverPort) {
		ReaderOut = new Thread(new Runnable() {
			int count = 0;

			@Override
			public void run() {
				log.info("TCP启动进出库线程");// run的方法体代表要执行的任务
				while (true) {
					newRfidTag.getRfidInOutA(serverPort);// 8082
					delay_ms(10000);// 10s休眠时间
				}
			}
		});
		if (ReaderOut.isAlive() == false) {// 判断线程是否启动
			ReaderOut.setDaemon(true);//
			ReaderOut.start();//
			ReaderOut.setPriority(4);
		}

	}

	@Override
	public void setApplicationContext(ApplicationContext app) throws BeansException {
		log.info("开启读写器读标签");
		if (flagStart == 0) {
			/****** 直接发送 ******/
			//getReaderIn(8082);// 监视盘点线程8082
			//getReaderOut(8083);// 监视盘点线程8083
			//getMonitorWarn();// 监视进出库
			flagStart = 1;// 防止再次启动
		}
	}
}
