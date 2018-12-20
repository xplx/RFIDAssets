package com.daoben.rfid.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.daoben.rfid.mapper.AssetIoNumberMapper;
import com.daoben.rfid.model.AssetIoNumber;
import com.daoben.rfid.model.SelectTime;

@Service
public class AssetIoNumberService {
	@Resource
	private AssetIoNumberMapper assetIoNumberMapper;

	/**
	 * @param selectTime
	 * @return
	 */
	public List<AssetIoNumber> selectAssetIoNumber(SelectTime selectTime) {

		return assetIoNumberMapper.selectAssetIoNumber(selectTime);
	}

	/**
	 * @param selectTime
	 * @return
	 */
	public int insertAssetIoNumber(AssetIoNumber assetIoNumber) {

		return assetIoNumberMapper.insertAssetIoNumber(assetIoNumber);
	}

	/**
	 * @param selectTime
	 * @return
	 */
	public int updateAssetIoNumber(AssetIoNumber assetIoNumber) {

		return assetIoNumberMapper.updateAssetIoNumber(assetIoNumber);
	}
}
