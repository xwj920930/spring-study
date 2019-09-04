package com.xwj.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{
	@Override
	public Object postProcessBeforeInitialization(Object object, String beanName) throws BeansException {
		if("carlife".equals(beanName)){
			System.err.println("postProcessBeforeInitialization");
			CarLife carLife=(CarLife) object;
			if(carLife.getColor()==null){
				carLife.setColor("black");
			}
		}
		return object;
	}
	@Override
	public Object postProcessAfterInitialization(Object object, String beanName) throws BeansException {
		if("carlife".equals(beanName)){
			System.err.println("postProcessAfterInitialization");
			CarLife carLife=(CarLife) object;
			if(carLife.getSpeed()>200){
				carLife.setSpeed(200);;
			}
		}
		return object;
	}
}
