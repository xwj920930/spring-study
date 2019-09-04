package com.xwj.ioc;

import com.xwj.reflect.Car;

public class CarFactory {
	public Car getCar1() {
		Car car=new Car();
		car.setBrand("suv");
		return car;
	}
	public static Car getCar2() {
		Car car=new Car();
		car.setBrand("suv");
		return car;
	}
}
