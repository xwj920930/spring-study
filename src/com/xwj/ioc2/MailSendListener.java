package com.xwj.ioc2;

import org.springframework.context.ApplicationListener;

public class MailSendListener implements ApplicationListener<MailSendEvent>{
	@Override
	public void onApplicationEvent(MailSendEvent event) {
		MailSendEvent event2=event;
		System.err.println("MailSendListener向:"+event2.getTo()+"发送邮件");
	}
}
