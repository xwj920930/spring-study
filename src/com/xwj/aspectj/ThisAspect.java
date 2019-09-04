package com.xwj.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

@Aspect
public class ThisAspect implements Ordered{
	@AfterReturning("this(com.xwj.aspectj.Seller)")
	public void testThis() {
		System.err.println("this() execute");
	}

	@Override
	public int getOrder() {
		return 1;
	}
	
}
