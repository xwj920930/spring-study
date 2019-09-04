package com.xwj.springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class HelloWorld {
	public static void main(String[] args) {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sampledb");
		dataSource.setUsername("xwj");
		dataSource.setPassword("123456");
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		String sql="create table a (id int,a varchar(10));";
		jdbcTemplate.execute(sql);
	}
}
