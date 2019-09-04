package com.xwj.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CarReflect {
	public static Car initByRef() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		Class<?> clazz=loader.loadClass("com.xwj.reflect.Car");
		//Constructor<?> constructor=clazz.getDeclaredConstructor();
		//Car car=(Car) constructor.newInstance();
		Car car=(Car) clazz.newInstance();
		Method setBrand=clazz.getMethod("setBrand", String.class);
		setBrand.invoke(car, "Tesla");
		Method setColor=clazz.getMethod("setColor", String.class);
		setColor.invoke(car, "blue");
		Method setSpeed=clazz.getMethod("setSpeed", int.class);
		setSpeed.invoke(car, 200);
		return car;
	}
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Car car=initByRef();
		car.introduce();
	}
}
