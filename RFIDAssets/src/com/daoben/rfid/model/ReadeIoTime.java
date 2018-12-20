package com.daoben.rfid.model;

import java.sql.Timestamp;
import java.util.Date;

public class ReadeIoTime {
	private String rfid_Ip;
	private String device_Purpose;
	private String tag_Id;
	private Timestamp tag_Time;
	public ReadeIoTime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReadeIoTime(String rfid_Ip, String device_Purpose, String tag_Id, Timestamp tag_Time) {
		super();
		this.rfid_Ip = rfid_Ip;
		this.device_Purpose = device_Purpose;
		this.tag_Id = tag_Id;
		this.tag_Time = tag_Time;
	}
	public String getRfid_Ip() {
		return rfid_Ip;
	}
	public void setRfid_Ip(String rfid_Ip) {
		this.rfid_Ip = rfid_Ip;
	}
	public String getDevice_Purpose() {
		return device_Purpose;
	}
	public void setDevice_Purpose(String device_Purpose) {
		this.device_Purpose = device_Purpose;
	}
	public String getTag_Id() {
		return tag_Id;
	}
	public void setTag_Id(String tag_Id) {
		this.tag_Id = tag_Id;
	}
	public Timestamp getTag_Time() {
		return tag_Time;
	}
	public void setTag_Time(Timestamp tag_Time) {
		this.tag_Time = tag_Time;
	}
	@Override
	public String toString() {
		return "ReadeIoTime [rfid_Ip=" + rfid_Ip + ", device_Purpose=" + device_Purpose + ", tagid=" + tag_Id
				+ ", tag_Time=" + tag_Time + "]";
	}
	
	
	
	
	
}