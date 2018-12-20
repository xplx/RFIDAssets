package com.daoben.rfid.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.daoben.rfid.controller.AssetInventoryController;
import com.daoben.rfid.mapper.AssetInfoMapper;
/**
 * 
 * @author leon.chen
 *
 * @date 2017年2月16日 下午4:26:44
 */
//资产盘查
import com.daoben.rfid.mapper.AssetInventoryMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml"})
public class AssetInventoryTest {

	@Autowired
	private AssetInventoryController assetInventoryController;
	
	
	@Test
	public void findAssetInventoryData() throws Exception{
		System.out.println(assetInventoryController.findAssetInventoryData("1"));
	}
	@Test
	public void findAssetTypeData() throws Exception{
		System.out.println(assetInventoryController.findAssetTypeData());
	}
	

}
