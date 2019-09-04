package com.xwj.aop;

public class MethodPerformance {
	private long begin;
	private long end;
	private String serviceMethod;
	public MethodPerformance(String serviceMethod) {
		this.serviceMethod=serviceMethod;
		this.begin=System.currentTimeMillis();
	}
	public void printPerformance() {
		this.end=System.currentTimeMillis();
		long elapse=end-begin;
		System.err.println(serviceMethod+"花费时间"+elapse);
	}
}
