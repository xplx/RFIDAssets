package com.daoben.rfid.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daoben.rfid.mapper.TestPlanAndTestPlanResultMapper;
import com.daoben.rfid.mapper.UpDateTestResultMapper;
import com.daoben.rfid.model.TestPlanAndTestPlanResult;
import com.daoben.rfid.model.UpDateTestResult;

@Service
public class UpDateTestResultService {

	@Resource
	private UpDateTestResultMapper upDateTestResultMapper;
	
	public int UpDateTestResult(UpDateTestResult upDateTestResult)
	{
		return upDateTestResultMapper.UpDateTestResultAsId(upDateTestResult);
	}
	
}
