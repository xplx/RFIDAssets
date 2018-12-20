package com.daoben.rfid.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daoben.rfid.mapper.SparePartsMapper;
import com.daoben.rfid.model.DeviceType;
import com.daoben.rfid.model.FindSpareParts;
import com.daoben.rfid.model.LocationInfo;
import com.daoben.rfid.model.SpareParts;

@Service
public class SparePartsService {

	@Resource
	private SparePartsMapper sparePartsMapper;
	
	public List<SpareParts> FindSpareParts()
	{
		return sparePartsMapper.findSpareParts();
	}
	
	public List<SpareParts> FindSparePartsByLocationIdAndDeviceType(FindSpareParts findSpareParts)
	{
		return sparePartsMapper.findSparePartsByLocationIdAndDeviceType(findSpareParts);
	}
	public List<SpareParts> FindSparePartsByDeviceType(DeviceType deviceType)
	{
		return sparePartsMapper.findSparePartsByDeviceType(deviceType);
	}
	public List<SpareParts> FindSparePartsByLocationId(LocationInfo location)
	{
		return sparePartsMapper.findSparePartsByLocationId(location);
	}
}
