package com.daoben.rfid.model;

public class TUser {

	private String account;
	private String user_Name;
	private String password;
	private int role;
	private String department;
	private String phone;
	private String mail;
	
	
	public TUser() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TUser(String account, String user_Name, String password, int role, String department, String phone,
			String mail) {
		super();
		this.account = account;
		this.user_Name = user_Name;
		this.password = password;
		this.role = role;
		this.department = department;
		this.phone = phone;
		this.mail = mail;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getUser_Name() {
		return user_Name;
	}


	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	@Override
	public String toString() {
		return "T_USER [account=" + account + ", user_name=" + user_Name + ", password=" + password + ", role=" + role
				+ ", department=" + department + ", phone=" + phone + ", mail=" + mail + "]";
	}
	
	
	
}
