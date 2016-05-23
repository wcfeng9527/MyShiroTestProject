package com.shijie99.wcf.service;

import java.util.Set;

import com.shijie99.wcf.entity.User;

public interface UserService {
	
	public User createUser(User user);
	
	public void changePassword(Long userId,String newPasssword);
	
	public void correlationRoles(Long userId,Long... roleIds);
	
	public void uncorrelationRoles(Long userId,Long... roleIds);
	
	public User findByUsername(String username);
	
	public Set<String> finRoles(String username);
	
	public Set<String> findPermissions(String username);
}
