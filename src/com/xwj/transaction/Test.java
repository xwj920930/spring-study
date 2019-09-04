package com.xwj.transaction;

import com.xwj.entity.LoginLog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;

public class Test {
	ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans6.xml");
	@org.testng.annotations.Test
	public void test(){
		TestService service=context.getBean("testService", TestService.class);
		LoginLog loginLog=new LoginLog();
		loginLog.setIp("事务测试");
		loginLog.setLoginDatetime(new Date());
		loginLog.setUserId(0);
		service.insertLoginLog(loginLog);
	}
	@org.testng.annotations.Test
	public void test1(){
		TestService service=context.getBean("tService", TestService.class);
		LoginLog loginLog=new LoginLog();
		loginLog.setIp("事务测试");
		loginLog.setLoginDatetime(new Date());
		loginLog.setUserId(0);
		service.insertLoginLog(loginLog);
	}
	@org.testng.annotations.Test
	public void test2(){
		TestService service=context.getBean("tService", TestService.class);
		LoginLog loginLog=new LoginLog();
		loginLog.setIp("事务测试");
		loginLog.setLoginDatetime(new Date());
		loginLog.setUserId(0);
		service.insertLoginLog(loginLog);
	}
}
