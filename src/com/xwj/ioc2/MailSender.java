package com.xwj.ioc2;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MailSender implements ApplicationContextAware{
	private ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx=applicationContext;
	}
	public void sendMail(String to) {
		System.err.println("MailSender模拟发送邮件");
		MailSendEvent event=new MailSendEvent(ctx, to);
		ctx.publishEvent(event);
	}
}
