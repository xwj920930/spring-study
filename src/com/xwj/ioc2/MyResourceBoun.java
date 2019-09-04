package com.xwj.ioc2;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyResourceBoun {
	public static void main(String[] args) {
		ResourceBundle bundle1=ResourceBundle.getBundle("resource",Locale.US);
		ResourceBundle bundle2=ResourceBundle.getBundle("resource",Locale.CHINA);
		ResourceBundle bundle3=ResourceBundle.getBundle("fmt_resource",Locale.CHINA);
		System.err.println(bundle1.getString("greeting.common"));
		System.err.println(bundle2.getString("greeting.common"));
		MessageFormat format=new MessageFormat(bundle3.getString("greeting.common"), Locale.CHINA);
		Object[] objects={"xwj",new Date()};
		System.err.println(format.format(objects));
	}
}
