package com.daoben.rfid.mapper;

import java.util.List;
import java.util.Map;

import com.daoben.rfid.model.AssetInfo;
/**
 * @author 文
 *
 * 2017年2月14日下午1:09:30
 */
public interface AssetInfoMapper {

	
	public List<AssetInfo> findAll();
	public List<Map<String,Integer>> countAsset();
	public List<Map<Object, Object>> findByAssetType(String assetType);
	public List<Map<Object, Object>> findByAssetType2();
	public Map<String, String> findByRfidLabelnum(String RfidLabelnum);
	public List<Map<String, Object>> deviceQuery(AssetInfo assetInfo);
	public List<AssetInfo> findByTagId(String tag_Id);
	
}