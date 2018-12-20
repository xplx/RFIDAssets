package com.daoben.rfid.mapper;

import java.util.List;

import com.daoben.rfid.model.DeviceType;
import com.daoben.rfid.model.LocationInfo;

public interface DeviceTypeMapper {

	/**
	 * 获取设备类型
	 * @param pid
	 * @return
	 */
	public List<DeviceType> findDeviceType();
	
}
