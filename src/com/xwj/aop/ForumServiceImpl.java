package com.xwj.aop;

import java.sql.SQLException;

public class ForumServiceImpl implements ForumService {
	@Override
	public void removeTopic(int topicId) {
		// aop
		//PerformanceMonitor.begin("com.xwj.aop.ForumServiceImpl.removeTopic");
		System.err.println("模拟删除topic记录" + topicId);
		try {
			Thread.currentThread().sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// aop
		//PerformanceMonitor.end();
	}

	@Override
	public void removeForum(int forumId) {
		// aop
		//PerformanceMonitor.begin("com.xwj.aop.ForumServiceImpl.removeForum");
		System.err.println("模拟删除forum记录" + forumId);
		try {
			Thread.currentThread().sleep(40);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// aop
		//PerformanceMonitor.end();
	}

	@Override
	public void exception() throws SQLException {
			throw new SQLException("数据库异常");
	}
}
