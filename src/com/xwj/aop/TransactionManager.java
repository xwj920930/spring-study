package com.xwj.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class TransactionManager implements ThrowsAdvice{
	public void afterThrowing(Method method,Object[] args,Object target,Exception ex) throws Throwable{
		System.out.println(method.getName());
		System.out.println("异常:"+ex.getMessage());
		System.out.println("回滚");
	}
}
