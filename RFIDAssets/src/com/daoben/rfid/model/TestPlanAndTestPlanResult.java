package com.daoben.rfid.model;

import java.util.List;

import com.sun.jmx.snmp.Timestamp;

/**
 * 检查计划实体类
 * 
 * @author hayypant 2017年4月27日
 *
 */
public class TestPlanAndTestPlanResult {

	private int testplan_id;
	private String asset_company;
	private String station_name;
	private String asset_number;
	private String device_name;
	private String device_code;
	private String head;
	private Timestamp testdate;
	private String make_rules_id;
	private int device_count;

	private int plan_id;
	private Timestamp entry_date;
	private String qualified_number;
	private String undevice_name;
	private String describe;

	public TestPlanAndTestPlanResult(int testplan_id, String asset_company, String station_name, String asset_number,
			String device_name, String device_code, String head, Timestamp testdate, String make_rules_id,
			int device_count, int plan_id, Timestamp entry_date, String qualified_number, String undevice_name,
			String describe) {
		super();
		this.testplan_id = testplan_id;
		this.asset_company = asset_company;
		this.station_name = station_name;
		this.asset_number = asset_number;
		this.device_name = device_name;
		this.device_code = device_code;
		this.head = head;
		this.testdate = testdate;
		this.make_rules_id = make_rules_id;
		this.device_count = device_count;
		this.plan_id = plan_id;
		this.entry_date = entry_date;
		this.qualified_number = qualified_number;
		this.undevice_name = undevice_name;
		this.describe = describe;
	}

	public TestPlanAndTestPlanResult() {
		super();
	}

	public int getTestplan_id() {
		return testplan_id;
	}

	public void setTestplan_id(int testplan_id) {
		this.testplan_id = testplan_id;
	}

	public String getAsset_company() {
		return asset_company;
	}

	public void setAsset_company(String asset_company) {
		this.asset_company = asset_company;
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public String getAsset_number() {
		return asset_number;
	}

	public void setAsset_number(String asset_number) {
		this.asset_number = asset_number;
	}

	public String getDevice_name() {
		return device_name;
	}

	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	public String getDevice_code() {
		return device_code;
	}

	public void setDevice_code(String device_code) {
		this.device_code = device_code;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Timestamp getTestdate() {
		return testdate;
	}

	public void setTestdate(Timestamp testdate) {
		this.testdate = testdate;
	}

	public String getMake_rules_id() {
		return make_rules_id;
	}

	public void setMake_rules_id(String make_rules_id) {
		this.make_rules_id = make_rules_id;
	}

	public int getDevice_count() {
		return device_count;
	}

	public void setDevice_count(int device_count) {
		this.device_count = device_count;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public Timestamp getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Timestamp entry_date) {
		this.entry_date = entry_date;
	}

	public String getQualified_number() {
		return qualified_number;
	}

	public void setQualified_number(String qualified_number) {
		this.qualified_number = qualified_number;
	}

	public String getUndevice_name() {
		return undevice_name;
	}

	public void setUndevice_name(String undevice_name) {
		this.undevice_name = undevice_name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public String toString() {
		return "TestPlanAndTestPlanResult [testplan_id=" + testplan_id + ", asset_company=" + asset_company
				+ ", station_name=" + station_name + ", asset_number=" + asset_number + ", device_name=" + device_name
				+ ", device_code=" + device_code + ", head=" + head + ", testdate=" + testdate + ", make_rules_id="
				+ make_rules_id + ", device_count=" + device_count + ", plan_id=" + plan_id + ", entry_date="
				+ entry_date + ", qualified_number=" + qualified_number + ", undevice_name=" + undevice_name
				+ ", describe=" + describe + "]";
	}
	
}
