package com.xwj.ioc2;

import java.beans.PropertyEditorSupport;

public class CustomCarEditor extends PropertyEditorSupport{
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(text==null||text.indexOf(",")==-1){
			throw new IllegalArgumentException();
		}
		String[] info=text.split(",");
		EditCar car=new EditCar();
		car.setBrand(info[0]);
		car.setColor(info[1]);
		car.setSpeed(Integer.parseInt(info[2]));
		setValue(car);
	}
}
