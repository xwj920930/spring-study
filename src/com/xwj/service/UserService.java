package com.xwj.service;

import com.xwj.dao.LoginLogDao;
import com.xwj.dao.UserDao;
import com.xwj.entity.LoginLog;
import com.xwj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;
	public boolean hasMatchUser(String userName,String password) {
		int matchCount=userDao.getMatchCount(userName, password);
		return matchCount>0;
	}
	public User findUserByUserName(String userName){
		return userDao.findUserByUserName(userName);
	}
	@Transactional
	public void loginSuccess(User user){
		user.setCredits(user.getCredits()+5);
		LoginLog loginLog=new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDatetime(user.getLastVisit());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}
}
