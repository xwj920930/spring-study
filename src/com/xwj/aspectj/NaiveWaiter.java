package com.xwj.aspectj;

import java.sql.SQLException;

public class NaiveWaiter implements Waiter {
	public void greetTo(String name) {
		System.err.println("naivewaiter greet to "+name);
	}
	public void serverTo(String name) {
		System.err.println("naivewaiter server to "+name);
	}
	public int returnTo() {
		return 10;
	}
	@Override
	public void throwEx(int i) throws IllegalAccessException, SQLException {
		if(i==1){
				throw new IllegalAccessException();
		}else{
				throw new SQLException();
		}
	}
}
