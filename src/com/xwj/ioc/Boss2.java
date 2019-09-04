package com.xwj.ioc;

import com.xwj.reflect.Car;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class Boss2 implements MethodReplacer{
	@Override
	public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		Car car=new Car();
		car.setBrand("猎豹");
		return car;
	}
}
