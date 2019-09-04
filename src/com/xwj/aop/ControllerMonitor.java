package com.xwj.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllerMonitor extends DelegatingIntroductionInterceptor implements Monitorable {
	private ThreadLocal<Boolean> monitorstart=new ThreadLocal<>();
	@Override
	public void setMonitorActive(boolean active) {
		monitorstart.set(active);
	}
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object obj=null;
		if(monitorstart.get()!=null&&monitorstart.get()){
			PerformanceMonitor.begin(mi.getClass().getName()+"."+mi.getMethod().getName());
			obj=super.invoke(mi);
			PerformanceMonitor.end();
		}else {
			obj=super.invoke(mi);
		}
		return obj;
	}

}
