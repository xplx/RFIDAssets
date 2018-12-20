package com.daoben.rfid.mapper;

import java.util.List;

import com.daoben.rfid.model.TUser;

public interface TUserMapper {
	public List<TUser> findAll();

	public TUser findOnlyUser(TUser tUser);

	public int AddUserInfo(TUser tUser);

	public int updateUserInfo(TUser tUser);
	
	public int deleteUserInfo(String tUser);

}