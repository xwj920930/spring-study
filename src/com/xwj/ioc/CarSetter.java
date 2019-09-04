package com.xwj.ioc;

public class CarSetter {
	private String brand;
	private String color;
	private int speed;
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void introduce() {
		System.err.println("brand:"+brand+";color:"+color+";speed:"+speed);
	}
}
