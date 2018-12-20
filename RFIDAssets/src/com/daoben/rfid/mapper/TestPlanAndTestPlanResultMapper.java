package com.daoben.rfid.mapper;

import java.util.List;

import com.daoben.rfid.model.TestPlanAndTestPlanResult;

public interface TestPlanAndTestPlanResultMapper {
	
	/**
	 * 查询检查计划
	 * @return
	 */
	public List<TestPlanAndTestPlanResult> findAllTestPlanAndTestPlanResult();
}
