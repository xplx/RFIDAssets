package com.daoben.rfid.model;

import java.sql.Timestamp;


public class AssetInLibrary {

	private String tag_Id;
	private String rfid_Assetnum;
	private String asset_Name;
	private String image_Path;
	private String user_Name;
	private Timestamp in_Time;
	private String asset_Type;
	public AssetInLibrary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssetInLibrary(String tag_Id, String rfid_Assetnum, String asset_Name, String image_Path, String user_Name,
			Timestamp in_Time, String asset_Type) {
		super();
		this.tag_Id = tag_Id;
		this.rfid_Assetnum = rfid_Assetnum;
		this.asset_Name = asset_Name;
		this.image_Path = image_Path;
		this.user_Name = user_Name;
		this.in_Time = in_Time;
		this.asset_Type = asset_Type;
	}

	public String getTag_Id() {
		return tag_Id;
	}
	public void setTag_Id(String tag_Id) {
		this.tag_Id = tag_Id;
	}
	public String getRfid_Assetnum() {
		return rfid_Assetnum;
	}
	public void setRfid_Assetnum(String rfid_Assetnum) {
		this.rfid_Assetnum = rfid_Assetnum;
	}
	public String getAsset_Name() {
		return asset_Name;
	}
	public void setAsset_Name(String asset_Name) {
		this.asset_Name = asset_Name;
	}
	public String getImage_Path() {
		return image_Path;
	}
	public void setImage_Path(String image_Path) {
		this.image_Path = image_Path;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public Timestamp getIn_Time() {
		return in_Time;
	}
	public void setIn_Time(Timestamp in_Time) {
		this.in_Time = in_Time;
	}
	
	public String getAsset_Type() {
		return asset_Type;
	}
	public void setAsset_Type(String asset_Type) {
		this.asset_Type = asset_Type;
	}

	@Override
	public String toString() {
		return "AssetInLibrary [tag_Id=" + tag_Id + ", rfid_Assetnum=" + rfid_Assetnum + ", asset_Name=" + asset_Name
				+ ", image_Path=" + image_Path + ", user_Name=" + user_Name + ", in_Time=" + in_Time + ", asset_Type="
				+ asset_Type + "]";
	}

	
	
}
