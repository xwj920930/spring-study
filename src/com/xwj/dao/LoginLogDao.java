package com.xwj.dao;

import com.xwj.entity.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao {
	private static final String INSERT_LOGINLOG_SQL="insert into t_login_log values (null,?,?,?)";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void insertLoginLog(LoginLog loginLog){
		jdbcTemplate.update(INSERT_LOGINLOG_SQL, new Object[]{loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDatetime()});
	}
}
