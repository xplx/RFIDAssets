package com.daoben.rfid.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.daoben.rfid.utils.DSerialPort;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class DSerialPortTest {
	@Resource
	private DSerialPort dSerialPort;

	@Test
	public void SendWarn() {
		while (true) {
			dSerialPort.SendWarn();// 串口发送报警
		}		
	}
}
