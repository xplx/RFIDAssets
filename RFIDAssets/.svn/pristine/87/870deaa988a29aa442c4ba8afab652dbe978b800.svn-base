package com.daoben.rfid.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daoben.rfid.mapper.TestPlanAndTestPlanResultMapper;
import com.daoben.rfid.model.TestPlanAndTestPlanResult;

@Service
public class TestPlanAndTestPlanResultService {

	@Resource
	private TestPlanAndTestPlanResultMapper testPlanMapper;
	
	public List<TestPlanAndTestPlanResult> FindAllTestPlanAndTestPlanResult()
	{
		return testPlanMapper.findAllTestPlanAndTestPlanResult();
	}
	
}
