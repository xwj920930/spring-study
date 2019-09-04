package com.xwj.ioc2;

public class EditBoss {
	private String name;
	private EditCar car;

	public void introduce() {
		System.err.println("boss>brand:"+car.getBrand()+";color:"+car.getColor()+";speed:"+car.getSpeed());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EditCar getCar() {
		return car;
	}
	public void setCar(EditCar car) {
		this.car = car;
	}
}
