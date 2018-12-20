package com.daoben.rfid.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.daoben.rfid.mapper.AssetDeviceInfoMapper;
import com.daoben.rfid.model.AssetDeviceInfo;

/**
 * @author wxp
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
@Service
public class AssetDeviceInfoService {

	@Resource
	private AssetDeviceInfoMapper aInfoMapper;

	/**
	 * @author wxp 查询所有的设备
	 */
	public List<AssetDeviceInfo> selectAllDeviceInfo() {

		return aInfoMapper.selectAllDeviceInfo();
	}

	/**
	 * @author wxp 模糊查询所有设备
	 */
	public List<AssetDeviceInfo> dimSelectAllDeviceInfo(String rfid_ip) {

		return aInfoMapper.dimSelectAllDeviceInfo(rfid_ip);
	}

	/**
	 * @author wxp 根据IP查询设备
	 */
	public List<AssetDeviceInfo> selectByRfidIp(String rfid_ip) {

		return aInfoMapper.selectByRfidIp(rfid_ip);
	}

	/**
	 * @author wxp 根据IP更新ip连接的状态
	 */
	public int updateByDeviceState(AssetDeviceInfo rfid_ip) {

		return aInfoMapper.updateByDeviceState(rfid_ip);
	}

	/**
	 * @author wxp 根据IP更新ip连接的状态
	 */
	public int updatePartDeviceState(AssetDeviceInfo rfid_ip) {

		return aInfoMapper.updatePartDeviceState(rfid_ip);
	}

	/**
	 * @author wxp 根据IP查询读写器连接的状态
	 */
	public List<AssetDeviceInfo> selectByDeviceHandle(String rfid_ip) {

		return aInfoMapper.selectByDeviceHandle(rfid_ip);
	}
}
