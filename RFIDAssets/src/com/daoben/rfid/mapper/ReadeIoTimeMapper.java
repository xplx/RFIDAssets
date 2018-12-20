package com.daoben.rfid.mapper;

import java.sql.Timestamp;
import java.util.List;

import com.daoben.rfid.model.ReadeIoTime;

public interface ReadeIoTimeMapper {
	public List<ReadeIoTime> findInTime(String tag_Id);

	/**
	 * 
	 */
	public List<ReadeIoTime> findOutTime(String tag_Id);

	/**
	 * 
	 */
	public List<ReadeIoTime> findAll();

	/**
	 * @param inoutlibrary
	 * @param tag_Id
	 * @return
	 */
	public Timestamp getIOTime(ReadeIoTime readeIoTime);

	/**
	 * @param readeIoTime
	 * @return
	 */
	public int insertReadeIoTime(ReadeIoTime readeIoTime);

	/**
	 * @param tag_Id
	 */
	public void delete(String tag_Id);

	public void updateReadeIoTim(String tag_id);//更新心跳包

	public List<ReadeIoTime> selectHeartBeat();//查询心跳包

}