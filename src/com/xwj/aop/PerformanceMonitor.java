package com.xwj.aop;

public class PerformanceMonitor {
	private static ThreadLocal<MethodPerformance> local=new ThreadLocal<>();
	public static void begin(String method) {
		System.err.println("begin monitor");
		MethodPerformance performance=new MethodPerformance(method);
		local.set(performance);
	}
	public static void end() {
		System.err.println("end monitor");
		MethodPerformance performance=local.get();
		performance.printPerformance();
	}
}
