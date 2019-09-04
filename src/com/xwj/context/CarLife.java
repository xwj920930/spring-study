package com.xwj.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class CarLife implements BeanFactoryAware,BeanNameAware,InitializingBean,DisposableBean{
	private String brand;
	private String color;
	private int speed;
	public CarLife() {
	}
	public CarLife(String brand,String color,int speed){
		this.brand=brand;
		this.color=color;
		this.speed=speed;
	}
	public void introduce() {
		System.out.println("brand:"+brand+";color:"+color+";speed:"+speed);
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	@Override
	public void destroy() throws Exception {
		System.err.println("destroy()");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.err.println("afterPropertiesSet()");
	}
	@Override
	public void setBeanName(String beanName) {
		System.err.println("setBeanName()");
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.err.println("setBeanFactory()");
	}
	public void myInit(){
		System.err.println("myInit()");
	}
	public void myDestroy(){
		System.err.println("myDestroy()");
	}
}
