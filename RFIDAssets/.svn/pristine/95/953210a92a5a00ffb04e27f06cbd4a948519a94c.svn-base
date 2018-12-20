/**
 * 
 */
package com.daoben.rfid.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daoben.rfid.mapper.AssetIoLibraryMapper;
import com.daoben.rfid.model.AssetIoLibrary;
import com.daoben.rfid.model.SelectTime;

/**
 * @author 文
 *
 * @date 2017年2月18日上午10:00:44
 */
/**
 * 
 * @Title: wen  
 * @Description: 授权管理
 * @param @param 
 * @param @return      
 * @date 2017年2月17日 上午9:23:31
 */
@Service
public class AuthManagementService {

	@Resource
	private AssetIoLibraryMapper assetIoLibraryMapper;
	
	public List<Map<String, Object>> count() {
		return assetIoLibraryMapper.countAsset();
	}

	public List<Map<String, Object>> findByAssetType(SelectTime selectTime) {
		return assetIoLibraryMapper.findIn(selectTime);
	}

	public int updateOutput(AssetIoLibrary assetIoLibrary) {
		return assetIoLibraryMapper.updateOutput(assetIoLibrary);
	}

}
