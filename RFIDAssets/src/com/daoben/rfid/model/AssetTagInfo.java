package com.daoben.rfid.model;

import java.sql.Timestamp;
import java.util.Date;

public class AssetTagInfo {

	private String tag_Id;
	private int tag_Light;
	private int tag_Shake;
	private int tag_Electric;
	private int tag_Lose;
	private Timestamp tag_Date;
	private String tag_Place;

	public AssetTagInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssetTagInfo(String tag_Id, int tag_Light, int tag_Shake, int tag_Electric, int tag_Lose, Timestamp tag_Date,
			String tag_Place) {
		super();
		this.tag_Id = tag_Id;
		this.tag_Light = tag_Light;
		this.tag_Shake = tag_Shake;
		this.tag_Electric = tag_Electric;
		this.tag_Lose = tag_Lose;
		this.tag_Date = tag_Date;
		this.tag_Place = tag_Place;
	}

	public int getTag_Lose() {
		return tag_Lose;
	}

	public void setTag_Lose(int tag_Lose) {
		this.tag_Lose = tag_Lose;
	}

	public String getTag_Id() {
		return tag_Id;
	}

	public void setTag_Id(String tag_Id) {
		this.tag_Id = tag_Id;
	}

	public int getTag_Light() {
		return tag_Light;
	}

	public void setTag_Light(int tag_Light) {
		this.tag_Light = tag_Light;
	}

	public int getTag_Shake() {
		return tag_Shake;
	}

	public void setTag_Shake(int tag_Shake) {
		this.tag_Shake = tag_Shake;
	}

	public int getTag_Electric() {
		return tag_Electric;
	}

	public void setTag_Electric(int tag_Electric) {
		this.tag_Electric = tag_Electric;
	}

	public Timestamp getTag_Date() {
		return tag_Date;
	}

	public void setTag_Date(Timestamp tag_Date) {
		this.tag_Date = tag_Date;
	}

	public String getTag_Place() {
		return tag_Place;
	}

	public void setTag_Place(String tag_Place) {
		this.tag_Place = tag_Place;
	}

	@Override
	public String toString() {
		return "AssetTagInfo [tag_Id=" + tag_Id + ", tag_Light=" + tag_Light + ", tag_Shake=" + tag_Shake
				+ ", tag_Electric=" + tag_Electric + ", tag_Lose=" + tag_Lose + ", tag_Date=" + tag_Date
				+ ", tag_Place=" + tag_Place + "]";
	}

}