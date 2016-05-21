package com.shijie99.wcf.shiro.test;

import java.util.Iterator;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShirLoginLogutTest {
	private static Logger logger = LoggerFactory.getLogger(ShirLoginLogutTest.class);
	@Test
	public void testHelloWord(){
		//获取SecurityManager 工厂，使用ini配置文件初始化SecurityManager
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//通过工厂得到SecurityManager实例
		SecurityManager securityManager = factory.getInstance();
		//绑定SecurityManager到SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		//得到subject 
		Subject user = SecurityUtils.getSubject();
		//创建一个UsernamePasswordToken，这里实际web中应该是从页面传过来的输入用户名和密码
		String username = "zhangsan";
		String password = "123456";
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try{
			//登录
			user.login(token);
			logger.info("登录成功");
		}catch (AuthenticationException e) {
			//登录失败
			logger.error("登录失败，用户名或密码错误", e);
		}
		//断言用户是否已登录
//		Assert.assertEquals(true, user.isAuthenticated());
		PrincipalCollection connection = user.getPrincipals();
		Iterator<?> it = connection.iterator();
		while(it.hasNext()){
			Object o = it.next();
			System.out.println(o);
		}
		//退出登录
		user.logout();
	}
}
