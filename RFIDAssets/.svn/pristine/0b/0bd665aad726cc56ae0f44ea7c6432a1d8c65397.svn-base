package com.daoben.rfid.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.daoben.rfid.mapper.AssetInLibraryMapper;
import com.daoben.rfid.mapper.AssetInfoMapper;

import com.daoben.rfid.mapper.TUserMapper;
import com.daoben.rfid.model.AssetInLibrary;
import com.daoben.rfid.service.IntoTheLibraryService;
import com.daoben.rfid.service.TUserService;



/**
 * @author 文
 *
 * 2017年2月14日下午1:09:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class NewAssetsIntoTheLibraryServiceTest {

	@Autowired
	private AssetInfoMapper am;
	@Autowired
	private AssetInLibraryMapper assetInLibraryMapper;
	
	
	
	
	
	
	@Autowired
	private IntoTheLibraryService newAssetsIntoTheLibraryService;

	
	
	
	@Test
	public void findAll() throws Exception{
		System.out.println(am.findAll());
		System.out.println(newAssetsIntoTheLibraryService.findAll());
		
	}
	@Test
	public void countAsset() throws Exception{
		System.out.println(am.countAsset());
		System.out.println(newAssetsIntoTheLibraryService.countAsset());
		
	}
	@Test
	public void findByAssetType() throws Exception{
		System.out.println(am.findByAssetType("所用变"));
		System.out.println(newAssetsIntoTheLibraryService.findByAssetType("所用变"));
	}
	@Test
	public void findByRfidLabelnum() throws Exception{
		System.out.println(am.findByRfidLabelnum("03M01000000384542"));
	}
	@Test
	public void insertAsset() throws Exception{
		AssetInLibrary assetInLibrary = new AssetInLibrary("3","03M01000000384542","245避雷器B相","asdasdasd","123",new Timestamp(new Date().getTime()),"避雷器");
		int n = newAssetsIntoTheLibraryService.insertAsset(assetInLibrary);
		System.out.println(n);
		
	}
	
}
