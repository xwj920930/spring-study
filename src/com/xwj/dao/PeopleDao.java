package com.xwj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;

@Repository
public class PeopleDao {
	private static final String INSERT="INSERT INTO netpeople VALUES (?,?)";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int insert(String userName,String password){
		Object[] params = new Object[] { userName, password };
		return jdbcTemplate.update(INSERT, params, new int[] { Types.VARCHAR, Types.VARCHAR });
	}
}
