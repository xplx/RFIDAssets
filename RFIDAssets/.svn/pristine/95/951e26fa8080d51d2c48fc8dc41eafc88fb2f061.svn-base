package com.daoben.rfid.test;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.daoben.rfid.mapper.AssetInfoHisMapper;
import com.daoben.rfid.model.AssetInfoHis;
import com.daoben.rfid.utils.AcquireTimeStamp;

/**
 * @author wxp
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class AssetInfoHisTest {

	@Resource
	private AssetInfoHisMapper as;

	@Resource
	private AcquireTimeStamp ats;

	@Test
	public void selectAllAssetInfoHis() {
		System.out.println(as.selectAllAssetInfoHis("开关柜"));
	}

	@Test
	public void selectByTagIdInfo() {
		System.out.println(as.selectByTagIdInfo("1"));
	}

	@Test
	public void selectAssetInfoHisType() {
		System.out.println(as.selectAssetInfoHisType());
	}

	@Test
	public void insertAssetInfoHis() {
		AssetInfoHis aHis = new AssetInfoHis();
		String tag_Id = null, asset_Type = null;
		List<Map<String, String>> list = as.selectByTagType("1");
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = list.get(i);
			tag_Id = map.get("TAG_ID");
			asset_Type = map.get("ASSET_TYPE");
		}
		aHis.setTag_Id(tag_Id);
		aHis.setOpdate(ats.getTimeStamp());
		aHis.setPosition("办公室");
		aHis.setAsset_Type(asset_Type);
		System.out.println(as.insertAssetInfoHis(aHis));
	}

	@Test
	public void updateAssetInfoHis() {
		AssetInfoHis aHis = new AssetInfoHis();
		aHis.setTag_Id("123");
		aHis.setPosition("软件部");
		aHis.setOpdate(ats.getTimeStamp());
		System.out.println(as.updateAssetInfoHis(aHis));
	}

	@Test
	public void deleteAssetInfoHis() {
		System.out.println(as.deleteAssetInfoHis("123"));
	}

	@Test
	public void selectByTagType() {
		System.out.println(as.selectByTagType("1"));
	}

	@Test
	public void unionAssetIoLibrary() {
		System.out.println(as.unionAssetIoLibrary("避雷器"));
	}

	@Test
	public void unionAssetIoLibrarytagid() {
		AssetInfoHis aHis = new AssetInfoHis();
		aHis.setTag_Id("1");
		aHis.setAsset_Type("避雷器");
		System.out.println(as.unionAssetIoLibraryTagId(aHis));
//		List<Map<String, Object>> list = as.unionAssetIoLibraryTagId(aHis);
//		for (Map<String, Object> map : list) {
//			Object time = map.get("OPDATE");
//			String time1 = getDate(time);
//			System.out.println(time1);
//		}		
	}
}
