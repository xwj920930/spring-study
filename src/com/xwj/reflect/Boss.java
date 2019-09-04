package com.xwj.reflect;

public class Boss {
	private Car car;
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public void introduce() {
		System.err.println("boss>brand:"+car.getBrand()+";color:"+car.getColor()+";speed:"+car.getSpeed());
	}
}
