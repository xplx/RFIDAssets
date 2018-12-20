package com.daoben.rfid.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daoben.rfid.mapper.TUserMapper;
import com.daoben.rfid.model.TUser;

@Service
public class TUserService {
	@Resource
	private TUserMapper tm;

	public List<TUser> findAll() {
		return tm.findAll();
	}

	@Transactional
	public TUser findOnlyUser(TUser tUser) {
		return tm.findOnlyUser(tUser);
	}

	/**
	 * @author wxp 添加用户信息
	 */
	public int AddUserInfo(TUser tUser) {

		return tm.AddUserInfo(tUser);
	}

	/**
	 * @author wxp 更改用户信息
	 */
	public int updateUserInfo(TUser tUser) {

		return tm.updateUserInfo(tUser);
	}

	/**
	 * @author wxp 更改用户信息
	 */
	public int deleteUserInfo(String account) {

		return tm.deleteUserInfo(account);
	}
}
