package com.daoben.rfid.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.daoben.rfid.model.AssetDeviceInfo;

@Repository
public interface AssetDeviceInfoMapper {

	List<AssetDeviceInfo> selectAllDeviceInfo();

	List<AssetDeviceInfo> dimSelectAllDeviceInfo(String string);

	List<AssetDeviceInfo> selectByRfidIp(String string);

	int updateByDeviceState(AssetDeviceInfo record);

	int updatePartDeviceState(AssetDeviceInfo record);
	
	List<AssetDeviceInfo> selectByDeviceHandle(String rfid_Ip);

}