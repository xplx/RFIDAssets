package com.daoben.rfid.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoben.rfid.model.LocationInfo;
import com.daoben.rfid.service.LocationInfoService;
import com.daoben.rfid.utils.ResponsePWFactory;

@Controller
@RequestMapping("/locationInfo")
public class LocationInfoController {
	@Resource
	private LocationInfoService locationInfoService;
	@Resource
	private ResponsePWFactory responsePWFactory;

	@ResponseBody
	@RequestMapping(value = "/findLocationinfo", produces = "text/json;charset=UTF-8")
	public String findLocationinfo(String pid) {
		List<LocationInfo> locationInfoList;
		try {
			if (pid != null&& pid.length() != 0) {
				locationInfoList = locationInfoService.FindLocationInfo(pid);
				// System.out.println(responsePWFactory.responseMap("true",
				// "获取设备盘点列表成功", locationInfoList, null));
			}else {
				locationInfoList = locationInfoService.FindLocationInfoIsNull();
			}
			return responsePWFactory.responseMap("true", "获取地点列表成功", locationInfoList, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取地点列表失败", e, null);
		}
	}
}
