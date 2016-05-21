package com.shijie99.wcf.shiro.test;

import java.util.Arrays;

import junit.framework.Assert;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class RoleTest {

	@Test
	public void testHasRole(){
		login("classpath:shiro-role.ini");
		Subject subject = SecurityUtils.getSubject();  
		Assert.assertEquals(true, subject.isAuthenticated());
		//判断有角色
		Assert.assertTrue(subject.hasRole("role1"));
		boolean[] result = subject.hasRoles(Arrays.asList("role1","role2","role3"));
		Assert.assertTrue(result[0]);
		Assert.assertTrue(result[1]);
		Assert.assertTrue(result[2]);
	}
	
	@Test(expected=UnauthorizedException.class)
	public void testCheckRole(){
		login("classpath:shiro-role.ini");
		Subject subject = SecurityUtils.getSubject();
		subject.checkRole("role1");
		try{
			subject.checkRoles("role1","role2","role3");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void login(String configFile) {  
	    //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager  
	    Factory<org.apache.shiro.mgt.SecurityManager> factory =  
	            new IniSecurityManagerFactory(configFile);  
	  
	    //2、得到SecurityManager实例 并绑定给SecurityUtils  
	    org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
	    SecurityUtils.setSecurityManager(securityManager);  
	  
	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
	    Subject subject = SecurityUtils.getSubject();  
	    UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
	  
	    subject.login(token);  
	    
	}
}
