package com.xwj.ioc;

public class CarContructor {
	private String brand;
	private String color;
	private int speed;
	public CarContructor(String brand,String color,int speed) {
		this.brand=brand;
		this.color=color;
		this.speed=speed;
	}
	public void introduce() {
		System.err.println("brand:"+brand+";color:"+color+";speed:"+speed);
	}
}
