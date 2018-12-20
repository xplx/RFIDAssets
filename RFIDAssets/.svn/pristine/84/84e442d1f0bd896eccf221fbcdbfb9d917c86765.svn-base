package com.daoben.rfid.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.daoben.rfid.mapper.ReadeIoTimeMapper;
import com.daoben.rfid.model.ReadeIoTime;

/**
 * @author wxp
 *
 */
@Service
public class ReadeIoTimeService {
	@Resource
	private ReadeIoTimeMapper rService;

	/**
	 * @author wxp 插入进出库标签的信息
	 */
	public int insertReadeIoTime(ReadeIoTime readeIoTime) {

		return rService.insertReadeIoTime(readeIoTime);

	}

	/**
	 * @author wxp 更新心跳包
	 */
	public void updateReadeIoTim(String tag_id) {

		rService.updateReadeIoTim(tag_id);

	}

	/**
	 * @author wxp 插入进出库标签的信息
	 */
	public List<ReadeIoTime> selectHeartBeat() {

		return rService.selectHeartBeat();

	}
}
