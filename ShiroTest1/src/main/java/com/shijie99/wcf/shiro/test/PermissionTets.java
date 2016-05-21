package com.shijie99.wcf.shiro.test;

import junit.framework.Assert;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class PermissionTets extends BaseTest {
	
	@Test
	public void testIsPermitted(){
		Subject subject = login("classpath:shiro.ini", "zhangsan", "123456");
		//断言有权限
		Assert.assertTrue(subject.isPermitted("user:create"));
		Assert.assertTrue(subject.isPermittedAll("user:update","user:delete"));
		Assert.assertTrue(subject.isPermitted("user:view"));
	}
}
