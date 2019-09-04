package com.xwj.context;

import com.xwj.reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
	@Bean(name="car2")
	public Car getCar(){
		Car car=new Car();
		car.setBrand("suv");
		car.setColor("blue");
		car.setSpeed(100);
		return car;
	}
}
