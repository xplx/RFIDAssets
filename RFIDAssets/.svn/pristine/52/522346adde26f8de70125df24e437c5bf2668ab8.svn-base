package com.daoben.rfid.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.daoben.rfid.model.AssetIoNumber;
import com.daoben.rfid.service.AssetIoNumberService;
import com.sun.org.apache.bcel.internal.generic.NEW;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class AssetIoNumberTest {
	@Resource
	private AssetIoNumberService assetIoNumberService;

	@Test
	public void insertAssetIoNumber() {
		AssetIoNumber assetIoNumber = new AssetIoNumber(null, 10, 12, 5);
		try {
			assetIoNumberService.insertAssetIoNumber(assetIoNumber);
		} catch (

		Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void updateAssetIoNumber() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String currentDateString = format.format(new Date());
		AssetIoNumber assetIoNumber = new AssetIoNumber(currentDateString, 101111, 12, 1111);
		try {
			int a = assetIoNumberService.updateAssetIoNumber(assetIoNumber);
		} catch (

		Exception e) {
			// TODO: handle exception
		}
	}

}
