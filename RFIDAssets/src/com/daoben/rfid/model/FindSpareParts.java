package com.daoben.rfid.model;

public class FindSpareParts {
	private String locationId;
	private String deviceType;
	
	public FindSpareParts() {
		super();
	}
	public FindSpareParts(String locationId, String deviceType) {
		super();
		this.locationId = locationId;
		this.deviceType = deviceType;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	@Override
	public String toString() {
		return "FindSpareParts [locationId=" + locationId + ", deviceType=" + deviceType + "]";
	}
	
	
}
