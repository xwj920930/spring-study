package com.xwj.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//p:driverClassName="${driverClassName}"p:url="${url}" p:username="${username}"p:password="${password}"
@Component
public class MyDatasource {
	@Value("${driverClassName}")
	private String driverClassName;
	@Value("${url}")
	private String url;
	@Value("${username}")
	private String username;
	@Value("${password}")
	private String password;
	@Override
	public String toString() {
		return driverClassName+url+username+password;
	}
}
