package com.xwj.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object obj) throws Throwable {
		System.err.println(obj.getClass().getName()+"."+method.getName());
		String name=(String) args[0];
		System.err.println("how are you Mr."+name);
	}

}
