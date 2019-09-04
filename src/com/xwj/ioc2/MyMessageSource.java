package com.xwj.ioc2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.Locale;

public class MyMessageSource {
	@Test
	public void resource(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans3.xml");
		MessageSource mSource=(MessageSource) context.getBean("myresource");
		Object[] objects={"xwj",new Date()};
		String string=mSource.getMessage("greeting.common",objects,Locale.CHINA);
		System.err.println(string);
	}
	@Test
	public void applicationresource(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans3.xml");
		Object[] objects={"xwj",new Date()};
		String string=context.getMessage("greeting.common",objects,Locale.CHINA);
		System.err.println(string);
	}
}
