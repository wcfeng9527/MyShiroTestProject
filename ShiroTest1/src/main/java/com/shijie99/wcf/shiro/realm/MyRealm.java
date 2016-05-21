package com.shijie99.wcf.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.Realm;

public class MyRealm implements Realm {

	@Override
	public String getName() {
		return "mayRealm";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		//仅支持UsernamePasswordToken 的token
		return token instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		String username = (String)token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		//判断用户名密码是否正确
		if(!username.equals("zhangsan")){
			throw new AuthenticationException("用户名错误");
		}
		if(!password.equals("123456")){
			throw new AuthenticationException("密码错误");
		}
		//验证成功，返回实现
		return new SimpleAuthenticationInfo(username, password, getName());
	}

}
