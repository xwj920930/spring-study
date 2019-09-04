package com.xwj.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreGreetingAspect {
	@Before("execution(* greetTo(..))")
	public void beforeGreeting(JoinPoint joinPoint) {
		System.err.println("---JoinPoint---");
		System.err.println(joinPoint.getArgs()[0]);
		System.err.println(joinPoint.getTarget().getClass());
		System.err.println("---JoinPoint---");
		System.err.println("how are you");
	}
	/*@Before("execution(* serverTo(..)) && args(name)")
	public void bindJoinpointParams(String name) {
		System.err.println("how are you "+name);
	}*/
	/*@Before("this(waiter)")
	public void bindJoinpointProxy(Waiter waiter) {
		System.err.println("bindJoinpointProxy");
	}*/
	/*@Before("@annotation(test)")
	public void bindJoinpointAnno(NeedTest test) {
		System.err.println("bindJoinpointAnno");
	}*/
	/*@AfterReturning(value="execution(int returnTo(..))",returning="value")
	public void bindJoinpointReturn(int value) {
		System.err.println("bindJoinpointReturn");
	}*/
	@AfterThrowing(value="target(com.xwj.aspectj.NaiveWaiter)",throwing="ill")
	public void bindJoinpointThrow(IllegalAccessException ill) {
		System.err.println("bindJoinpointThrow");
	}
}
