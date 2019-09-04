package com.xwj.ioc;

import com.xwj.reflect.Car;

public class Boss1 {
	public Car getCar() {
		Car car=new Car();
		car.setBrand("宝马");
		return car;
	}
}
