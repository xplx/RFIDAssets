package com.daoben.rfid.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoben.rfid.model.WarnInfo;
import com.daoben.rfid.service.AssetTagInfoService;
import com.daoben.rfid.utils.ResponsePWFactory;

import sun.util.logging.resources.logging;

@Controller
public class AssetTagInfoController {

	@Resource
	private AssetTagInfoService as;

	@Resource
	private ResponsePWFactory responsePWFactory;

	/**
	 * @author wxp 联合查询总资产的信息和报警信息
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/AssetWarn/AssetInfoLoseAssetWarn", produces = "text/json;charset=UTF-8")
	public String AssetInfoLoseAssetWarn(String tag_id) {
		String responseMap = "";
		try {
			int goBack = as.updatePartLoseTagId(tag_id);
			responseMap = responsePWFactory.responseMap("true", "资产丢失授权成功", goBack, null);
		} catch (Exception e) {
			responseMap = responsePWFactory.responseMap("false", "资产丢失授权失败", null, null);
		}
		return responseMap;
	}
}
