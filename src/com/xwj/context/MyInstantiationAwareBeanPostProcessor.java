package com.xwj.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter{
	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if("carlife".equals(beanName)){
			System.err.println("postProcessBeforeInstantiation");
		}
		return null;
	}
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		if("carlife".equals(beanName)){
			System.err.println("postProcessAfterInstantiation");
		}
		return true;
	}
	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
		if("carlife".equals(beanName)){
			System.err.println("postProcessPropertyValues");
		}
		return pvs;
	}
}
