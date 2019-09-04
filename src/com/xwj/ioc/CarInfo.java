package com.xwj.ioc;

import com.xwj.reflect.Car;
import org.springframework.beans.factory.FactoryBean;

public class CarInfo implements FactoryBean<Car>{
	private String carinfo;

	public String getCarinfo() {
		return carinfo;
	}

	public void setCarinfo(String carinfo) {
		this.carinfo = carinfo;
	}

	@Override
	public Car getObject() throws Exception {
		Car car=new Car();
		String[] infos=carinfo.split(",");
		car.setBrand(infos[0]);
		car.setColor(infos[1]);
		car.setSpeed(Integer.parseInt(infos[2]));
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}
