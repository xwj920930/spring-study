package com.xwj.aop;

public class Waiter1Delegate {
	private Waiter1 waiter1;

	public Waiter1 getWaiter1() {
		return waiter1;
	}

	public void setWaiter1(Waiter1 waiter1) {
		this.waiter1 = waiter1;
	}
	
	public void service(String clientName){
		waiter1.greetTo(clientName);
		waiter1.serverTo(clientName);
	}
}
