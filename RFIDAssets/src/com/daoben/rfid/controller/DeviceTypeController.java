package com.daoben.rfid.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoben.rfid.model.DeviceType;
import com.daoben.rfid.model.LocationInfo;
import com.daoben.rfid.service.DeviceTypeService;
import com.daoben.rfid.service.LocationInfoService;
import com.daoben.rfid.utils.ResponsePWFactory;

@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {
	@Resource
	private DeviceTypeService deviceTypeService;
	@Resource
	private ResponsePWFactory responsePWFactory;

	@ResponseBody
	@RequestMapping(value = "/findDeviceType", produces = "text/json;charset=UTF-8")
	public String findDeviceType(String pid) {
		List<DeviceType> deviceTypeList;
		try {
			deviceTypeList = deviceTypeService.FindDeviceType();
			// System.out.println(responsePWFactory.responseMap("true",
			// "获取设备盘点列表成功", locationInfoList, null));
			return responsePWFactory.responseMap("true", "获取设备类型列表成功", deviceTypeList, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取设备类型列表失败哦", e, null);
		}

	}
}
