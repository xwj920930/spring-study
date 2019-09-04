package com.xwj.aspectj;

public class SmartSeller implements Seller {
	public void sell(String goods,String name) {
		System.err.println("sell "+goods+" to "+name);
	}
}
