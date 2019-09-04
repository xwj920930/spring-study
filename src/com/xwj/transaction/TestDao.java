package com.xwj.transaction;

import com.xwj.entity.LoginLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
	private static final String INSERT_LOGINLOG_SQL="insert into t_login_log values (null,?,?,?)";
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void insertLoginLog(LoginLog loginLog){
		jdbcTemplate.update(INSERT_LOGINLOG_SQL, new Object[]{loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDatetime()});
	}
	public void updateLoginLog(LoginLog loginLog){
		jdbcTemplate.update(INSERT_LOGINLOG_SQL, new Object[]{loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDatetime()});
	}
}
