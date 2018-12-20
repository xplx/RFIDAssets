package com.daoben.rfid.model;

import java.sql.Timestamp;

public class AssetIoLibrary {

	private String tag_Id;
	private String assetsno;
	private String devicename;
	private Timestamp io_Time;
	private String inoutlibrary;
	private int output;
	private int dismantle;
	private String user_Name;
	private Timestamp accredit_Time;
	private String asset_Type;

	public AssetIoLibrary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssetIoLibrary(String tag_Id, String assetsno, String devicename, Timestamp io_Time, String inoutlibrary,
			int output, int dismantle, String user_Name, Timestamp accredit_Time, String asset_Type) {
		super();
		this.tag_Id = tag_Id;
		this.assetsno = assetsno;
		this.devicename = devicename;
		this.io_Time = io_Time;
		this.inoutlibrary = inoutlibrary;
		this.output = output;
		this.dismantle = dismantle;
		this.user_Name = user_Name;
		this.accredit_Time = accredit_Time;
		this.asset_Type = asset_Type;
	}

	public String getTag_Id() {
		return tag_Id;
	}

	public void setTag_Id(String tag_Id) {
		this.tag_Id = tag_Id;
	}

	public String getAssetsno() {
		return assetsno;
	}

	public void setAssetsno(String assetsno) {
		this.assetsno = assetsno;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public Timestamp getIo_Time() {
		return io_Time;
	}

	public void setIo_Time(Timestamp io_Time) {
		this.io_Time = io_Time;
	}

	public String getInoutlibrary() {
		return inoutlibrary;
	}

	public void setInoutlibrary(String inoutlibrary) {
		this.inoutlibrary = inoutlibrary;
	}

	public int getOutput() {
		return output;
	}

	public void setOutput(int output) {
		this.output = output;
	}

	public int getDismantle() {
		return dismantle;
	}

	public void setDismantle(int dismantle) {
		this.dismantle = dismantle;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public Timestamp getAccredit_Time() {
		return accredit_Time;
	}

	public void setAccredit_Time(Timestamp accredit_Time) {
		this.accredit_Time = accredit_Time;
	}

	public String getAsset_Type() {
		return asset_Type;
	}

	public void setAsset_Type(String asset_Type) {
		this.asset_Type = asset_Type;
	}

	@Override
	public String toString() {
		return "AssetIoLibrary [tag_Id=" + tag_Id + ", assetsno=" + assetsno + ", devicename=" + devicename
				+ ", io_Time=" + io_Time + ", inoutlibrary=" + inoutlibrary + ", output=" + output + ", dismantle="
				+ dismantle + ", user_Name=" + user_Name + ", accredit_Time=" + accredit_Time + ", asset_Type="
				+ asset_Type + "]";
	}
	

}
