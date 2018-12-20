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
import com.daoben.rfid.service.LocationInfoService;
import com.daoben.rfid.service.SparePartsService;
import com.daoben.rfid.utils.ResponsePWFactory;

@Controller
@RequestMapping("/spareParts")
public class SparePartsController {
	@Resource
	private SparePartsService sparePartsService;
	@Resource
	private ResponsePWFactory responsePWFactory;

	@ResponseBody
	@RequestMapping(value = "/findSpareParts", produces = "text/json;charset=UTF-8")
	public String findSpareParts(String locationId,String deviceType) {
		List<SpareParts> sparePartsList;
		try {
			if (locationId != null&& locationId.length() != 0 && deviceType != null&& deviceType.length() != 0) {
				FindSpareParts findSpareParts = new FindSpareParts();
				findSpareParts.setLocationId(locationId);
				findSpareParts.setDeviceType(deviceType);
				sparePartsList = sparePartsService.FindSparePartsByLocationIdAndDeviceType(findSpareParts);
				// System.out.println(responsePWFactory.responseMap("true",
				// "获取设备盘点列表成功", locationInfoList, null));
			}else if(locationId != null&& locationId.length() != 0 && (deviceType == null|| deviceType.length() == 0)){
				LocationInfo locationInfo = new LocationInfo();
				locationInfo.setLocation_id(locationId);
				sparePartsList = sparePartsService.FindSparePartsByLocationId(locationInfo);
			}else if (deviceType != null&& deviceType.length() != 0 && (locationId == null|| locationId.length() == 0)) {
				DeviceType dType = new DeviceType();
				dType.setDevice_type(deviceType);
				sparePartsList = sparePartsService.FindSparePartsByDeviceType(dType);
			}else {
				sparePartsList = sparePartsService.FindSpareParts();
			}
			return responsePWFactory.responseMap("true", "获取设备信息列表成功", sparePartsList, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取设备信息列表失败哦", e, null);
		}
	}
}
