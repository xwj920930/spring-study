package com.xwj.context;

import com.xwj.reflect.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.Test;

public class BeanFactoryTest {
	@Test
	public void getBean(){
		ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
		Resource resource=resolver.getResource("file:WebContent/resource/beans.xml");
		DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions(resource);
		
		Car car=beanFactory.getBean("car1",Car.class);
		car.introduce();
	}
}
