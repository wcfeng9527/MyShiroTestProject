package com.shijie99.wcf.service;

import java.util.Set;

import com.shijie99.wcf.entity.User;
import com.shijie99.wcf.helper.PasswordHelper;

public class UserServiceImpl implements UserService {
	
	private PasswordHelper passwordHelper;
	
	@Override
	public User createUser(User user) {
		passwordHelper.encryptPassword(user);
		return null;
	}

	@Override
	public void changePassword(Long userId, String newPasssword) {
//		User user = 
	}

	@Override
	public void correlationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void uncorrelationRoles(Long userId, Long... roleIds) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> finRoles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
