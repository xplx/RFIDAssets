package com.daoben.rfid.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoben.rfid.model.DeviceType;
import com.daoben.rfid.model.FindSpareParts;
import com.daoben.rfid.model.LocationInfo;
import com.daoben.rfid.model.SpareParts;
import com.daoben.rfid.model.UpDateTestResult;
import com.daoben.rfid.service.LocationInfoService;
import com.daoben.rfid.service.SparePartsService;
import com.daoben.rfid.service.UpDateTestResultService;
import com.daoben.rfid.utils.ResponsePWFactory;
import com.google.gson.Gson;

@Controller
@RequestMapping("/upDateTestResult")
public class UpDateTestResultController {
	@Resource
	private UpDateTestResultService upDateTestResultService;
	@Resource
	private ResponsePWFactory responsePWFactory;

	@ResponseBody
	@RequestMapping(value = "/UpDateTestResult", produces = "text/json;charset=UTF-8")
	public String findSpareParts(String DetectionParams) {
		int result;
		try {
			Gson gson = new Gson();
			UpDateTestResult upDateTestResult = gson.fromJson(DetectionParams, UpDateTestResult.class);
			result = upDateTestResultService.UpDateTestResult(upDateTestResult);
				// System.out.println(responsePWFactory.responseMap("true",
				// "获取设备盘点列表成功", locationInfoList, null));
			return responsePWFactory.responseMap("true", "获取设备信息列表成功", result, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取设备信息列表失败哦", e, null);
		}
	}
}
