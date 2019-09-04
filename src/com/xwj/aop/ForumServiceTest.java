package com.xwj.aop;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class ForumServiceTest {
	@Test
	public void proxy1(){
		ForumService target=new ForumServiceImpl();
		PerformanceHandler handler=new PerformanceHandler(target);
		ForumService proxy=(ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
		proxy.removeForum(10);
		proxy.removeTopic(20);
	}
	@Test
	public void proxy2(){
		CglibProxy proxy=new CglibProxy();
		ForumServiceImpl impl=(ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
		impl.removeForum(10);
		impl.removeTopic(20);
	}
}
