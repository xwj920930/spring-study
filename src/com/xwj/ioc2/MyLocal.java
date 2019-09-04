package com.xwj.ioc2;

import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class MyLocal {
	@Test
	public void numberformat() {
		Locale locale=Locale.CHINA;
		Locale locale1=Locale.US;
		NumberFormat format=NumberFormat.getCurrencyInstance(locale);
		NumberFormat format1=NumberFormat.getCurrencyInstance(locale1);
		double d=123.456;
		System.err.println(format.format(d));
		System.err.println(format1.format(d));
	}
	@Test
	public void dateformat(){
		Locale locale=Locale.CHINA;
		DateFormat format=DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		System.err.println(format.format(new Date()));
	}
	@Test
	public void messageformat(){
		Locale locale=Locale.CHINA;
		String pattern="{0},{1},{2}";
		MessageFormat format=new MessageFormat(pattern, locale);
		Object[] objects={"xwj",new Date(),100000};
		System.err.println(format.format(objects));
	}
}
