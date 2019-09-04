package com.xwj.service;

import com.xwj.dao.MyDatasource;
import com.xwj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

@ContextConfiguration(locations={"classpath:applicationContext.xml"})
//public class UserServiceTest extends AbstractTestNGSpringContextTests{
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests{
	@Autowired
	private UserService userService;
	@Autowired
	private MyDatasource datasource;
	@Test
	public void hasMatchUser(){
		boolean b=userService.hasMatchUser("admin", "123456");
		Assert.assertTrue(b);
	}
	@Test
	public void findUserByUserName(){
		User user=userService.findUserByUserName("admin");
		Assert.assertEquals(user.getUserName(), "admin");
	}
	@Test
	public void loginSuccess(){
		User user=new User();
		user.setCredits(0);
		user.setLastIp("127.0.0.1");
		user.setLastVisit(new Date());
		user.setPassword("123456");
		user.setUserId(3);
		user.setUserName("admin");
		userService.loginSuccess(user);
	}
	@Test
	public void datasource(){
		System.err.println(datasource.toString());
	}
}
