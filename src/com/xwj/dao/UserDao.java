package com.xwj.dao;

import com.xwj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {
	private static final String MATCH_COUNT_SQL="select count(*) from t_user where user_name=? and password=?";
	private static final String FIND_USER_SQL="select * from t_user where user_name=?";
	private static final String UPDATE_LOGIN_SQL="update t_user set credits=?,last_visit=?,last_ip=? where user_id=?";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/
	public int getMatchCount(String userName,String password){
		return jdbcTemplate.queryForInt(MATCH_COUNT_SQL, new Object[]{userName,password});
	}
	public User findUserByUserName(final String userName){
		final User user=new User();
		jdbcTemplate.query(FIND_USER_SQL, new Object[]{userName},new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet set) throws SQLException {
				user.setUserId(set.getInt("user_id"));
				user.setUserName(userName);
				user.setCredits(set.getInt("credits"));
			}
		});
		return user;
	}
	public void updateLoginInfo(User user){
		jdbcTemplate.update(UPDATE_LOGIN_SQL,new Object[]{user.getCredits(),user.getLastVisit(),user.getLastIp(),user.getUserId()});
	}
}
