package com.xwj.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.annotations.Test;

public class AdvisorTest {
	ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans4.xml");
	@Test
	public void staticmethod(){
		Waiter1 waiter=context.getBean("waiter",Waiter1.class);
		Seller seller=context.getBean("seller",Seller.class);
		waiter.serverTo("asd");
		waiter.greetTo("dfg");
		seller.greetTo("xcv");
	}
	@Test
	public void regex(){
		Waiter1 waiter=context.getBean("waiter1",Waiter1.class);
		waiter.serverTo("asd");
		waiter.greetTo("dfg");
	}
	@Test
	public void dynamic(){
		Waiter1 waiter=context.getBean("waiter2",Waiter1.class);
		//waiter.serverTo("asd");
		//waiter.greetTo("dfg");
		waiter.greetTo("tom");
	}
	@Test
	public void control(){
		Waiter1 waiter=context.getBean("waiter3",Waiter1.class);
		//waiter.greetTo("tom");
		Waiter1Delegate delegate=new Waiter1Delegate();
		delegate.setWaiter1(waiter);
		delegate.service("tom");
	}
	@Test
	public void composable(){
		Waiter1 waiter=context.getBean("waiter4",Waiter1.class);
		//waiter.greetTo("tom");
		Waiter1Delegate delegate=new Waiter1Delegate();
		delegate.setWaiter1(waiter);
		delegate.service("tom");
	}
	@Test
	public void furum(){
		ForumService service=context.getBean("forumservice",ForumServiceImpl.class);
		service.removeForum(10);
		Monitorable monitorable=(Monitorable) service;
		monitorable.setMonitorActive(true);
		service.removeTopic(20);
	}
	@Test
	public void beanname(){
		Waiter2 waiter2=context.getBean("waiter22",Waiter2.class);
		waiter2.serverTo("asd");
	}
}
