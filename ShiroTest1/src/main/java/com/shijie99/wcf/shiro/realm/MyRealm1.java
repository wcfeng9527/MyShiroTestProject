package com.shijie99.wcf.shiro.realm;

import java.util.Arrays;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm1 extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions(Arrays.asList("user:create,update,delete"));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();
		String password = new String((char[])token.getCredentials());
		//判断用户名密码是否正确
		if(!username.equals("zhangsan")){
			throw new AuthenticationException("用户名错误");
		}
		if(!password.equals("123456")){
			throw new AuthenticationException("密码错误");
		}
		//这里应该是从数据库中根据用户名获取密码，然后交给shiro去对比输入的密码和真实密码是不是一致来判断是否登录成功
		return new SimpleAuthenticationInfo("zhangsan@shijie99.com", password, getName());
	}

}
