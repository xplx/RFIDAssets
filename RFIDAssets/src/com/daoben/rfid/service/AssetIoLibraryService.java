package com.daoben.rfid.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daoben.rfid.mapper.AssetIoLibraryMapper;
import com.daoben.rfid.model.AssetIoLibrary;

@Service
public class AssetIoLibraryService {

	@Resource
	private AssetIoLibraryMapper assetIoLibraryMapper;

	/**
	 * @function 插入进出库数据
	 * @param assetIoLibrary
	 * @return 
	 */
	public int insertAssetIoLibrary(AssetIoLibrary assetIoLibrary) {

		return assetIoLibraryMapper.insertAssetIoLibrary(assetIoLibrary);
	}
	
	/**
	 * @function 插入进出库数据
	 * @param assetIoLibrary
	 * @return 
	 */
	public int insertAssetInLibrary(AssetIoLibrary assetIoLibrary) {

		return assetIoLibraryMapper.insertAssetInLibrary(assetIoLibrary);
	}
	
	/**
	 * @function 查询出入标志
	 * @param tag_id
	 * @return in或out
	 */
	public List<AssetIoLibrary> findTagIdInOut(String tag_id) {
		
		return assetIoLibraryMapper.findTagIdInOut(tag_id);
	}
	
	
	/**
	 * @function 更改出库状态为“in”
	 * @param tag_id
	 * @return
	 */
	public int updateInLibrary(String tag_id) {
		
		return assetIoLibraryMapper.updateInLibrary(tag_id);
	}
	
	/**
	 * @function 查询在库数量
	 * @param tag_id
	 * @return
	 */
	public int selectSumCountAsset() {
		
		return assetIoLibraryMapper.selectSumCountAsset();
	}
}
