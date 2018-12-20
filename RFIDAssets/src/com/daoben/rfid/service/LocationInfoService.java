package com.daoben.rfid.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daoben.rfid.mapper.LocationInfoMapper;
import com.daoben.rfid.model.LocationInfo;

@Service
public class LocationInfoService {

	@Resource
	private LocationInfoMapper locationInfoMapper;
	
	public List<LocationInfo> FindLocationInfo(String pid)
	{
		return locationInfoMapper.findLocationInfo(pid);
	}
	
	public List<LocationInfo> FindLocationInfoIsNull()
	{
		return locationInfoMapper.findLocationInfoIsNull();
	}
}
