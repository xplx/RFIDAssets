package com.daoben.rfid.model;

import java.sql.Timestamp;
import java.util.Date;

public class AssetWarn {

	private String tag_Id;
	private String warn_Type;
	private Timestamp warn_Time;
	private String warn_Detil;
	public AssetWarn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssetWarn(String tag_Id, String warn_Type, Timestamp warn_Time, String warn_Detil) {
		super();
		this.tag_Id = tag_Id;
		this.warn_Type = warn_Type;
		this.warn_Time = warn_Time;
		this.warn_Detil = warn_Detil;
	}
	public String getTag_Id() {
		return tag_Id;
	}
	public void setTag_Id(String tag_Id) {
		this.tag_Id = tag_Id;
	}
	public String getWarn_Type() {
		return warn_Type;
	}
	public void setWarn_Type(String warn_Type) {
		this.warn_Type = warn_Type;
	}
	public Timestamp getWarn_Time() {
		return warn_Time;
	}
	public void setWarn_Time(Timestamp warn_Time) {
		this.warn_Time = warn_Time;
	}
	public String getWarn_Detil() {
		return warn_Detil;
	}
	public void setWarn_Detil(String warn_Detil) {
		this.warn_Detil = warn_Detil;
	}
	@Override
	public String toString() {
		return "AssetWarn [tag_Id=" + tag_Id + ", warn_Type=" + warn_Type + ", warn_Time=" + warn_Time + ", warn_Detil="
				+ warn_Detil + "]";
	}
	
	
	
}
