package com.xwj.aspectj;

import java.sql.SQLException;

public interface Waiter {
	void greetTo(String name);
	void serverTo(String name);
	public int returnTo();
	void throwEx(int i) throws IllegalAccessException, SQLException;
}
