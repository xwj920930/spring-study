package com.xwj.aop;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.annotations.Test;

public class AdviceTest {
	@Test
	public void before(){
		Waiter target=new NaiveWaiter();
		BeforeAdvice advice=new GreetingBeforeAdvice();
		ProxyFactory factory=new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvice(advice);
		Waiter waiter=(Waiter) factory.getProxy();
		waiter.greetTo("asd");
		waiter.serverTo("fgh");
	}
	@Test
	public void beforebybean(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans4.xml");
		Waiter waiter=context.getBean("waiteradv2",Waiter.class);
		waiter.greetTo("asd");
	}
	@Test
	public void exception() throws Exception{
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans4.xml");
		ForumDao service=context.getBean("forum",ForumDao.class);
		service.meth1();
		service.meth2();
	}
	@Test
	public void monitor(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans4.xml");
		ForumService service=context.getBean("forummonitor",ForumService.class);
		service.removeForum(10);
		Monitorable monitorable=(Monitorable) service;
		monitorable.setMonitorActive(true);
		service.removeForum(10);
	}
}
