package com.xwj.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut{
	private static List<String> specialClient=new ArrayList<>();
	static{
		specialClient.add("tom");
	}
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				System.err.println("调用getClassFilter对类"+clazz+"做静态检查");
				return Waiter1.class.isAssignableFrom(clazz);
			}
		};
	}
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.err.println("调用matches(Method method, Class<?> targetClass)对方法"+targetClass.getName()+"."+method.getName()+"做静态检查");
		return "greetTo".equals(method.getName());
	}
	@Override
	public boolean matches(Method method, Class<?> clazz, Object[] args) {
		System.err.println("调用matches(Method method, Class<?> targetClass, Object[] args)对方法"+clazz.getName()+"."+method.getName()+"做动态检查");
		String client=(String) args[0];
		return specialClient.contains(client);
	}
}
