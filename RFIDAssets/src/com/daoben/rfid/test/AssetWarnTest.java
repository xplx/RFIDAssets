package com.daoben.rfid.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.daoben.rfid.model.AssetIoLibrary;
import com.daoben.rfid.model.AssetWarn;
import com.daoben.rfid.model.SelectTime;
import com.daoben.rfid.service.AssetWarnService;
import com.daoben.rfid.utils.AcquireTimeStamp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class AssetWarnTest {

	@Resource
	private AssetWarnService warnService;

	@Resource
	private AcquireTimeStamp ats;

	@Test
	public void selectbyAssetInfo() {
		String rfid_Labelnum = null, asset_Name = null, asset_Type = null;
		System.out.println(warnService.selectbyAssetInfo("1"));
		List<Map<String, String>> list = warnService.selectbyAssetInfo("1");
		for (Map<String, String> map : list) {
			rfid_Labelnum = map.get("RFID_LABELNUM");
			asset_Name = map.get("ASSET_NAME");
			asset_Type = map.get("ASSET_TYPE");
		}
		System.out.println(rfid_Labelnum);
		System.out.println(asset_Name);
		System.out.println(asset_Type);
	}

	@Test
	public void unionAssetInfoAssetWarn() {
		System.out.println(warnService.unionAssetInfoAssetWarn("1"));
	}
	
	@Test
	public void unionAssetTagInfoAssetWarn() {
		SelectTime selectTime = new SelectTime("20170414",null,null,"24579",null);
		AssetWarn assetWarn = new AssetWarn();
		warnService.selectWarnLoseTagId(selectTime);
		System.out.println("标签id:"+warnService.selectWarnLoseTagId(selectTime));
	}

	@Test
	public void insertWarnInfo() {
		AssetWarn assetWarn = new AssetWarn();
		assetWarn.setTag_Id("4");
		assetWarn.setWarn_Type("未授权出库");// 处理表示出库未授权
		assetWarn.setWarn_Detil("由于急用没法来得及处理");
		assetWarn.setWarn_Time(ats.getTimeStamp());
		System.out.println(warnService.insertWarnInfo(assetWarn));
	}

	@Test
	public void updateAssetWarn() {
		AssetWarn assetWarn = new AssetWarn();
		assetWarn.setTag_Id("4");
		assetWarn.setWarn_Type("未授权出库");// 处理表示出库未授权
		assetWarn.setWarn_Detil("由于急用没法来得及处理");
		assetWarn.setWarn_Time(ats.getTimeStamp());
		System.out.println(warnService.updateAssetWarn(assetWarn));
	}

	@Test
	public void updateOutLibrary() {
		System.out.println(warnService.updateOutLibrary("22960"));
	}

	@Test
	public void deleteByTag_Id() {

		System.out.println(warnService.deleteByTag_Id("1"));

	}

	@Test
	public void selectbyIoLibrary() {

		System.out.println(warnService.selectbyIoLibrary("22993"));

	}
	@Test
	public void selectAssetIoNumberInfo() {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");//格式化时间
		String currentDateString = format.format(new Date());
		warnService.selectLoseSumCountWarn(currentDateString);//以当天时间查询盘点丢失信息

	}

	/**
	 * @author wxp 查询所有报警信息
	 */
	@Test
	public void selectAllIoLibrary() {

		System.out.println(warnService.selectAllIoLibrary());
	}
	
	/**
	 * @author wxp 查询所有丢失报警信息
	 */
	@Test
	public void selectbyLoseAssetInfo() {

		System.out.println(warnService.selectbyLoseAssetInfo());
	}
}
