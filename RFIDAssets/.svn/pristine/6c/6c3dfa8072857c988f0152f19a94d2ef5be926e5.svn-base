package com.daoben.rfid.mapper;

import java.util.List;
import java.util.Map;

import com.daoben.rfid.model.AssetCheck;

/**
 * 
 * @author leon.chen
 *
 * @date 2017年2月16日 下午3:51:37
 */
//资产盘查
public interface AssetInventoryMapper {
	public List<Map<String,String>> findAssetInventoryData(String asset_type); 
	public List<Map<String,String>> findAssetTypeData(); 

	/**
	 * @param tagId
	 * @return
	 */
	public String findByTagid(String tagId);
	public int insertCheck();

}