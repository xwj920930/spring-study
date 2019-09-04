package com.xwj.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class GreetingSuroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args=invocation.getArguments();
		String name=(String) args[0];
		System.err.println("how are you Mr."+name);
		Object object=invocation.proceed();
		System.err.println("enjoy yourself");
		return object;
	}

}
