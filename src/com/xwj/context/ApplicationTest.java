package com.xwj.context;

import com.xwj.reflect.Car;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.annotations.Test;

public class ApplicationTest {
	@Test
	public void getBean(){
		ApplicationContext context=new FileSystemXmlApplicationContext("file:WebContent/resource/beans.xml");
		Car car=context.getBean("car1", Car.class);
		car.introduce();
	}
	@Test
	public void getBean1(){
		ApplicationContext context=new AnnotationConfigApplicationContext(Beans.class);
		/*ApplicationContext context=new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext)context).register(Beans.class);
		((AnnotationConfigApplicationContext)context).refresh();*/
		Car car=context.getBean("car2", Car.class);
		car.introduce();
	}
	@Test
	public void getBean2() throws Exception{
		ApplicationContext context=new FileSystemXmlApplicationContext("file:WebContent/resource/beans.xml");
		CarLife car=context.getBean("carlife", CarLife.class);
		car.introduce();
		((DisposableBean)context).destroy();
	}
}
