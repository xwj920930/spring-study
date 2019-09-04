package com.xwj.ioc2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.annotations.Test;

public class Ioc2Test {
	ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans3.xml");
	@Test
	public void editboss() {
		EditBoss boss=context.getBean("editboss",EditBoss.class);
		boss.introduce();
	}
	@Test
	public void manager(){
		ApplicationManager manager=context.getBean("appmanager",ApplicationManager.class);
		System.err.println(manager);
	}
	@Test
	public void mailsender(){
		MailSender sender=context.getBean("mailsender",MailSender.class);
		sender.sendMail("123@123.com");
	}
	
}
