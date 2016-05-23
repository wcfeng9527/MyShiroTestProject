package com.shijie99.wcf.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class MyRealm5 extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = "liu";
		String password="3c8652852089489aed5e2217998cd72f";
		String salt2="491e96fa85a76c7586bb367554dbb895";
		SimpleAuthenticationInfo ai = new SimpleAuthenticationInfo(username,password,getName());
		ai.setCredentialsSalt(ByteSource.Util.bytes(username+salt2));
		
		return ai;
	}

}
