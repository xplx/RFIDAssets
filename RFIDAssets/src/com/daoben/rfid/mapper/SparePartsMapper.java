package com.daoben.rfid.mapper;

import java.util.List;

import com.daoben.rfid.model.DeviceType;
import com.daoben.rfid.model.FindSpareParts;
import com.daoben.rfid.model.LocationInfo;
import com.daoben.rfid.model.SpareParts;
public interface SparePartsMapper {
	/**
	 * 获取设备信息
	 * @param locationId
	 * @param deviceType
	 * @return
	 */
	public List<SpareParts> findSparePartsByLocationIdAndDeviceType(FindSpareParts findSpareParts);
	/**
	 * 获取设备信息
	 * @return
	 */
	public List<SpareParts> findSpareParts();
	/**
	 * 获取设备信息
	 * @param locationId
	 * @return
	 */
	public List<SpareParts> findSparePartsByLocationId(LocationInfo location);
	/**
	 * 获取设备信息
	 * @param deviceType
	 * @return
	 */
	public List<SpareParts> findSparePartsByDeviceType(DeviceType deviceType);
}
