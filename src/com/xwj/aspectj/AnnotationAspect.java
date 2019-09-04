package com.xwj.aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AnnotationAspect {
	@AfterReturning("@annotation(com.xwj.anno.NeedTest)")
	public void needTest() {
		System.err.println("needTest excute");
	}
}
