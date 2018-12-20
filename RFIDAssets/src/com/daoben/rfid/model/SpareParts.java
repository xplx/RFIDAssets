package com.daoben.rfid.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * 设备信息
 * @author hayypant
 *2017年4月19日
 *
 */
public class SpareParts {
	
	private int asset_id;
	private String asset_company;
	private String station_name;
	private String project_name;
	private String project_num;
	private String maintenance_company;
	private String specialty_type;
	private String asset_number;
	private String pm_code;
	private String asset_nature;
	private String device_code;
	private String device_name;
	private String voltage_level;
	private String device_type;
	private String device_model;
	private String operation_number;
	private String device_status;
	private Timestamp delivery_Date;
	private String manufacturer;
	private String device_addmode;
	private Timestamp operation_Date;
	private String interval_unit;
	private String asset_value;
	private String net_asset_value;
	private int counts;
	private String unit;
	private String disposal;
	private String use_period;
	private Timestamp retire_Date;
	private Timestamp capitalization_Date;
	private String superiorasset_number;
	private String superiordevice_code;
	private String superiordevice_name;
	
	public SpareParts() {
		super();
	}
	public SpareParts(int asset_id, String asset_company, String station_name, String project_name, String project_num,
			String maintenance_company, String specialty_type, String asset_number, String pm_code, String asset_nature,
			String device_code, String device_name, String voltage_level, String device_type, String device_model,
			String operation_number, String device_status, Timestamp delivery_Date, String manufacturer,
			String device_addmode, Timestamp operation_Date, String interval_unit, String asset_value,
			String net_asset_value, int counts, String unit, String disposal, String use_period, Timestamp retire_Date,
			Timestamp capitalization_Date, String superiorasset_number, String superiordevice_code,
			String superiordevice_name) {
		super();
		this.asset_id = asset_id;
		this.asset_company = asset_company;
		this.station_name = station_name;
		this.project_name = project_name;
		this.project_num = project_num;
		this.maintenance_company = maintenance_company;
		this.specialty_type = specialty_type;
		this.asset_number = asset_number;
		this.pm_code = pm_code;
		this.asset_nature = asset_nature;
		this.device_code = device_code;
		this.device_name = device_name;
		this.voltage_level = voltage_level;
		this.device_type = device_type;
		this.device_model = device_model;
		this.operation_number = operation_number;
		this.device_status = device_status;
		this.delivery_Date = delivery_Date;
		this.manufacturer = manufacturer;
		this.device_addmode = device_addmode;
		this.operation_Date = operation_Date;
		this.interval_unit = interval_unit;
		this.asset_value = asset_value;
		this.net_asset_value = net_asset_value;
		this.counts = counts;
		this.unit = unit;
		this.disposal = disposal;
		this.use_period = use_period;
		this.retire_Date = retire_Date;
		this.capitalization_Date = capitalization_Date;
		this.superiorasset_number = superiorasset_number;
		this.superiordevice_code = superiordevice_code;
		this.superiordevice_name = superiordevice_name;
	}
	public int getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
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
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_num() {
		return project_num;
	}
	public void setProject_num(String project_num) {
		this.project_num = project_num;
	}
	public String getMaintenance_company() {
		return maintenance_company;
	}
	public void setMaintenance_company(String maintenance_company) {
		this.maintenance_company = maintenance_company;
	}
	public String getSpecialty_type() {
		return specialty_type;
	}
	public void setSpecialty_type(String specialty_type) {
		this.specialty_type = specialty_type;
	}
	public String getAsset_number() {
		return asset_number;
	}
	public void setAsset_number(String asset_number) {
		this.asset_number = asset_number;
	}
	public String getPm_code() {
		return pm_code;
	}
	public void setPm_code(String pm_code) {
		this.pm_code = pm_code;
	}
	public String getAsset_nature() {
		return asset_nature;
	}
	public void setAsset_nature(String asset_nature) {
		this.asset_nature = asset_nature;
	}
	public String getDevice_code() {
		return device_code;
	}
	public void setDevice_code(String device_code) {
		this.device_code = device_code;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public String getVoltage_level() {
		return voltage_level;
	}
	public void setVoltage_level(String voltage_level) {
		this.voltage_level = voltage_level;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getDevice_model() {
		return device_model;
	}
	public void setDevice_model(String device_model) {
		this.device_model = device_model;
	}
	public String getOperation_number() {
		return operation_number;
	}
	public void setOperation_number(String operation_number) {
		this.operation_number = operation_number;
	}
	public String getDevice_status() {
		return device_status;
	}
	public void setDevice_status(String device_status) {
		this.device_status = device_status;
	}
	public Timestamp getDelivery_Date() {
		return delivery_Date;
	}
	public void setDelivery_Date(Timestamp delivery_Date) {
		this.delivery_Date = delivery_Date;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDevice_addmode() {
		return device_addmode;
	}
	public void setDevice_addmode(String device_addmode) {
		this.device_addmode = device_addmode;
	}
	public Timestamp getOperation_Date() {
		return operation_Date;
	}
	public void setOperation_Date(Timestamp operation_Date) {
		this.operation_Date = operation_Date;
	}
	public String getInterval_unit() {
		return interval_unit;
	}
	public void setInterval_unit(String interval_unit) {
		this.interval_unit = interval_unit;
	}
	public String getAsset_value() {
		return asset_value;
	}
	public void setAsset_value(String asset_value) {
		this.asset_value = asset_value;
	}
	public String getNet_asset_value() {
		return net_asset_value;
	}
	public void setNet_asset_value(String net_asset_value) {
		this.net_asset_value = net_asset_value;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDisposal() {
		return disposal;
	}
	public void setDisposal(String disposal) {
		this.disposal = disposal;
	}
	public String getUse_period() {
		return use_period;
	}
	public void setUse_period(String use_period) {
		this.use_period = use_period;
	}
	public Timestamp getRetire_Date() {
		return retire_Date;
	}
	public void setRetire_Date(Timestamp retire_Date) {
		this.retire_Date = retire_Date;
	}
	public Timestamp getCapitalization_Date() {
		return capitalization_Date;
	}
	public void setCapitalization_Date(Timestamp capitalization_Date) {
		this.capitalization_Date = capitalization_Date;
	}
	public String getSuperiorasset_number() {
		return superiorasset_number;
	}
	public void setSuperiorasset_number(String superiorasset_number) {
		this.superiorasset_number = superiorasset_number;
	}
	public String getSuperiordevice_code() {
		return superiordevice_code;
	}
	public void setSuperiordevice_code(String superiordevice_code) {
		this.superiordevice_code = superiordevice_code;
	}
	public String getSuperiordevice_name() {
		return superiordevice_name;
	}
	public void setSuperiordevice_name(String superiordevice_name) {
		this.superiordevice_name = superiordevice_name;
	}
	
}
