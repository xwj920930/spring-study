package com.xwj.aop;

import java.sql.SQLException;

public class ForumDao{
	public void meth1(){
		throw new RuntimeException("运行异常");
	}
	public void meth2() throws SQLException{
		throw new SQLException("数据库异常");
	}
}
