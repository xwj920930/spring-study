package com.xwj.SpEL;

public class User2 {
	private String name;
	private int credits;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public boolean validatePwd(String string) {
		return "123456".equals(string);
	}
}
