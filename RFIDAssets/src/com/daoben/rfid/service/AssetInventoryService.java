package com.daoben.rfid.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daoben.rfid.mapper.AssetCheckMapper;
import com.daoben.rfid.mapper.AssetInfoMapper;
import com.daoben.rfid.mapper.AssetInventoryMapper;
import com.daoben.rfid.mapper.AssetIoLibraryMapper;
import com.daoben.rfid.model.AssetCheck;
import com.daoben.rfid.model.AssetInfo;
import com.daoben.rfid.model.AssetIoLibrary;
import com.daoben.rfid.model.SelectTime;
/**
 * 
 * @author leon.chen
 *
 * @date 2017年2月16日 下午4:08:48
 */
//资产盘查
@Service
public class AssetInventoryService {
	@Resource
	private AssetInventoryMapper assetInventoryMapper;
	@Resource
	private AssetCheckMapper assetCheckMapper;
	@Resource
	private AssetIoLibraryMapper assetIoLibraryMapper;
	@Resource
	private AssetInfoMapper assetInfoMapper;
	
	

	public List<Map<String,String>> findAssetInventoryData(String asset_type) {
		return assetInventoryMapper.findAssetInventoryData(asset_type);
	}
	public List<Map<String,String>> findAssetTypeData(){
		return assetInventoryMapper.findAssetTypeData();
	}
	public String findByTagid(String tagId){
		return assetInventoryMapper.findByTagid(tagId);
	}
	public int insertCheck(){
		
		return assetInventoryMapper.insertCheck();
	}

	/**
	 * @param assetCheck
	 * @return
	 */
	public int updateCheck(AssetCheck assetCheck) {
		
		// TODO Auto-generated method stub
		return assetCheckMapper.updateCheck(assetCheck);
	}
	/**
	 * @param selectTime 
	 * @return
	 */
	public List<Map<String, Object>> findIn(SelectTime selectTime) {
		// TODO Auto-generated method stub
		return assetIoLibraryMapper.findIn(selectTime);
	}
	
	/**
	 * @return
	 */
	public List<Map<String, Object>> findNotIn() {
		// TODO Auto-generated method stub
		return assetIoLibraryMapper.findNotIn();
	}
	public List<Map<String, Object>> findOut(SelectTime selectTime) {
		// TODO Auto-generated method stub
		return assetIoLibraryMapper.findOut(selectTime);
	}
	/**
	 * @return
	 */
	
	
	public List<Map<String,Object>> inByType(SelectTime selectTime) {
		// TODO Auto-generated method stub
		return assetIoLibraryMapper.inByType(selectTime);
	}
	/**
	 * @param selectTime 
	 * @return
	 */
	public List<Map<String,Object>> outByType(SelectTime selectTime) {
		// TODO Auto-generated method stub
		return assetIoLibraryMapper.outByType(selectTime);
	}
	/**
	 * 
	 * @param asset_Type
	 * @return
	 */
	public List<Map<String, Object>> deviceQuery(AssetInfo assetInfo) {
		// TODO Auto-generated method stub
		return assetInfoMapper.deviceQuery(assetInfo);
	}
	/**
	 * @param list
	 * @return
	 */
	public int updateNotInToIn(List<String> list) {
		// TODO Auto-generated method stub
		return assetIoLibraryMapper.updateNotInToIn(list);
	}

}
