package com.daoben.rfid.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class AssetDeviceInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rfid_Devicename;
	private String rfid_Ip;
	private String device_Port;
	private int device_State;
	private String device_Position;
	private String device_Purpose;
	private String device_Keeper;
	private Timestamp register_Time;
	private int device_Handle;

	public AssetDeviceInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssetDeviceInfo(String rfid_Devicename, String rfid_Ip, String device_Port, int device_State,
			String device_Position, String device_Purpose, String device_Keeper, Timestamp register_Time,
			int device_handle) {
		super();
		this.rfid_Devicename = rfid_Devicename;
		this.rfid_Ip = rfid_Ip;
		this.device_Port = device_Port;
		this.device_State = device_State;
		this.device_Position = device_Position;
		this.device_Purpose = device_Purpose;
		this.device_Keeper = device_Keeper;
		this.register_Time = register_Time;
		this.device_Handle = device_Handle;
	}

	public String getRfid_Devicename() {
		return rfid_Devicename;
	}

	public void setRfid_Devicename(String rfid_Devicename) {
		this.rfid_Devicename = rfid_Devicename;
	}

	public String getRfid_Ip() {
		return rfid_Ip;
	}

	public void setRfid_Ip(String rfid_Ip) {
		this.rfid_Ip = rfid_Ip;
	}

	public String getDevice_Port() {
		return device_Port;
	}

	public void setDevice_Port(String device_Port) {
		this.device_Port = device_Port;
	}

	public int getDevice_State() {
		return device_State;
	}

	public void setDevice_State(int device_State) {
		this.device_State = device_State;
	}

	public String getDevice_Position() {
		return device_Position;
	}

	public void setDevice_Position(String device_Position) {
		this.device_Position = device_Position;
	}

	public String getDevice_Purpose() {
		return device_Purpose;
	}

	public void setDevice_Purpose(String device_Purpose) {
		this.device_Purpose = device_Purpose;
	}

	public String getDevice_Keeper() {
		return device_Keeper;
	}

	public void setDevice_Keeper(String device_Keeper) {
		this.device_Keeper = device_Keeper;
	}

	public Timestamp getRegister_Time() {
		return register_Time;
	}

	public void setRegister_Time(Timestamp register_Time) {
		this.register_Time = register_Time;
	}

	public int getDevice_Handle() {
		return device_Handle;
	}

	public void setDevice_Handle(int hcon) {
		this.device_Handle = hcon;
	}

	@Override
	public String toString() {
		return "AssetDeviceInfo [rfid_Devicename=" + rfid_Devicename + ", rfid_Ip=" + rfid_Ip + ", device_Port="
				+ device_Port + ", device_State=" + device_State + ", device_Position=" + device_Position
				+ ", device_Purpose=" + device_Purpose + ", device_Keeper=" + device_Keeper + ", register_Time="
				+ register_Time + ", device_handle=" + device_Handle + "]";
	}

}
