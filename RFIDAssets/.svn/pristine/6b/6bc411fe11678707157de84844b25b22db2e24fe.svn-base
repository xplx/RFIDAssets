package com.daoben.rfid.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoben.rfid.model.AssetIoNumber;
import com.daoben.rfid.model.SelectTime;
import com.daoben.rfid.service.AssetIoNumberService;
import com.daoben.rfid.utils.ResponsePWFactory;

@Controller
public class AssetIoNumberController {
	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private AssetIoNumberService assetIoNumberService;
	@Resource
	private ResponsePWFactory responsePWFactory;

	/**
	 * @author wxp 查询用户信息
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/AssetIoNumber/selectAssetIoNumber", produces = "text/json;charset=UTF-8")
	public String tofindIn(String beginTime, String endTime) {
		try {
			SelectTime selectTime = new SelectTime(beginTime, endTime, null, null, null);
			List<AssetIoNumber> warnLose = assetIoNumberService.selectAssetIoNumber(selectTime);

			return responsePWFactory.responseMap("true", "查询盘点差异成功", warnLose, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "查询盘点差异失败", null, null);
		}
	}
}
