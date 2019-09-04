package com.xwj.ioc;

import com.xwj.reflect.Car;

public class CascadeBoss {
	private Car car=new Car();
	public void setCar(Car car) {
		this.car = car;
	}
	public void introduce() {
		System.err.println("boss>brand:"+car.getBrand()+";color:"+car.getColor()+";speed:"+car.getSpeed());
	}
	public Car getCar() {
		return car;
	}
}
