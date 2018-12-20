package com.daoben.rfid.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daoben.rfid.mapper.DeviceTypeMapper;
import com.daoben.rfid.model.DeviceType;

@Service
public class DeviceTypeService {
	
	@Resource
	private DeviceTypeMapper deviceTypeMapper;
	
	public List<DeviceType> FindDeviceType(){
		return deviceTypeMapper.findDeviceType();
	}

}
