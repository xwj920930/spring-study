package com.xwj.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestPrivateCar {
	public static void main(String[] args) throws Exception {
		ClassLoader loader=Thread.currentThread().getContextClassLoader();
		Class<?> clazz=loader.loadClass("com.xwj.reflect.PrivateCar");
		PrivateCar car=(PrivateCar) clazz.newInstance();
		Field color=clazz.getDeclaredField("color");
		color.setAccessible(true);
		color.set(car, "blue");
		Method show=clazz.getDeclaredMethod("showColor");
		show.setAccessible(true);
		show.invoke(car);
	}
}
