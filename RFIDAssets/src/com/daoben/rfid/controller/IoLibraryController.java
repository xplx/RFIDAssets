package com.daoben.rfid.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoben.rfid.service.IoLibraryService;
import com.daoben.rfid.utils.ResponsePWFactory;

/**
 * @author 文
 *
 * @date   2017年3月1日下午4:40:56
 * 设备出入库
 */

@Controller
@RequestMapping(value = "/InOut", produces = "text/json;charset=UTF-8")
public class IoLibraryController {

	private Logger log = Logger.getLogger(this.getClass());
	@Resource
	private IoLibraryService ioLibraryService;
	@Resource
	private ResponsePWFactory responsePWFactory;
	
	@ResponseBody
	@RequestMapping("/IO")
	public String insert() {
		
		try {
			int i = ioLibraryService.insert();
			return responsePWFactory.responseMap("true","影响 "+i+" 条", i, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("true","失败",null, null);
		}
		
		}
	
	
}
