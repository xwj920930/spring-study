package com.xwj.ioc2;

public class ApplicationManager {
	private int sessionTimeout;
	private int maxTabPageNum;
	public int getSessionTimeout() {
		return sessionTimeout;
	}
	public void setSessionTimeout(int sessionTimeout) {
		this.sessionTimeout = sessionTimeout;
	}
	public int getMaxTabPageNum() {
		return maxTabPageNum;
	}
	public void setMaxTabPageNum(int maxTabPageNum) {
		this.maxTabPageNum = maxTabPageNum;
	}
	@Override
	public String toString() {
		return ""+sessionTimeout+";"+maxTabPageNum;
	}
}
