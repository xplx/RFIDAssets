package com.daoben.rfid.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daoben.rfid.model.TestPlanAndTestPlanResult;
import com.daoben.rfid.service.TestPlanAndTestPlanResultService;
import com.daoben.rfid.utils.ResponsePWFactory;

@Controller
@RequestMapping("/testPlan")
public class TestPlanController {
	@Resource
	private TestPlanAndTestPlanResultService testPlanService;
	@Resource
	private ResponsePWFactory responsePWFactory;

	@ResponseBody
	@RequestMapping(value = "/findAllTestPlanAndTestPlanResult", produces = "text/json;charset=UTF-8")
	public String findAllTestPlanAndTestPlanResult() {
		List<TestPlanAndTestPlanResult> testPLanList;
		try {
			testPLanList = testPlanService.FindAllTestPlanAndTestPlanResult();
				// System.out.println(responsePWFactory.responseMap("true",
				// "获取设备盘点列表成功", locationInfoList, null));
			return responsePWFactory.responseMap("true", "获取检查列表成功", testPLanList, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responsePWFactory.responseMap("false", "获取检查列表失败", e, null);
		}
	}
}
