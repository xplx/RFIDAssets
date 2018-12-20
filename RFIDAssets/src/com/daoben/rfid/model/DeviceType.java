package com.daoben.rfid.model;

/**
 * 设备类型
 * 
 * @author hayypant 2017年4月19日
 *
 */
public class DeviceType {

	// private String distinct;
	private String device_type;

	public DeviceType() {
		super();
	}

	// public DeviceType(String distinct, String device_type) {
	// super();
	//// this.distinct = distinct;
	// this.device_type = device_type;
	// }

	public String getDevice_type() {
		return device_type;
	}

	public DeviceType(String device_type) {
		super();
		this.device_type = device_type;
	}

	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}

	@Override
	public String toString() {
		return "DeviceType [device_type=" + device_type + "]";
	}

}
