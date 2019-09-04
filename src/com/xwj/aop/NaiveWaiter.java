package com.xwj.aop;

public class NaiveWaiter implements Waiter {
	@Override
	public void greetTo(String name) {
		System.err.println("greet to "+name);
	}

	@Override
	public void serverTo(String name) {
		System.err.println("serve to "+name);
	}
}
