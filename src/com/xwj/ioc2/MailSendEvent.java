package com.xwj.ioc2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class MailSendEvent extends ApplicationContextEvent{
	private String to;
	public MailSendEvent(ApplicationContext source,String to) {
		super(source);
		this.to=to;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

}
