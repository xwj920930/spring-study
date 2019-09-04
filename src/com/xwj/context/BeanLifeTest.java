package com.xwj.context;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class BeanLifeTest {
	private static void beanLife() {
		Resource resource=new FileSystemResource("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans.xml");
		BeanFactory bf=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader((BeanDefinitionRegistry) bf);
		reader.loadBeanDefinitions(resource);
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
		((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
		CarLife carLife=(CarLife) bf.getBean("carlife");
		carLife.introduce();
		carLife.setColor("blue");
		CarLife carLife2=(CarLife) bf.getBean("carlife");
		System.err.println(carLife==carLife2);
		((ConfigurableBeanFactory)bf).destroySingletons();
	}
	public static void main(String[] args) {
		beanLife();
	}
}
