/**
 * 
 */
package com.daoben.rfid.model;

/**
 * @author 文
 *
 * @date 2017年4月10日下午3:23:42
 */
public class SelectTime {

	private String beginTime;
	private String endTime;
	private String asset_Type;
	private String tag_Plasce;
	private String warn_Type;

	public SelectTime() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SelectTime(String beginTime, String endTime, String asset_Type, String tag_Plasce, String warn_Type) {
		super();
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.asset_Type = asset_Type;
		this.tag_Plasce = tag_Plasce;
		this.warn_Type = warn_Type;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAsset_Type() {
		return asset_Type;
	}

	public void setAsset_Type(String asset_Type) {
		this.asset_Type = asset_Type;
	}

	public String getTag_Plasce() {
		return tag_Plasce;
	}

	public void setTag_Plasce(String tag_Plasce) {
		this.tag_Plasce = tag_Plasce;
	}

	public String getWarn_Type() {
		return warn_Type;
	}

	public void setWarn_Type(String warn_Type) {
		this.warn_Type = warn_Type;
	}

	@Override
	public String toString() {
		return "SelectTime [beginTime=" + beginTime + ", endTime=" + endTime + ", asset_Type=" + asset_Type
				+ ", tag_Plasce=" + tag_Plasce + ", warn_Type=" + warn_Type + "]";
	}

}
