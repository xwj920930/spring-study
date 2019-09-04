package com.xwj.jdbctest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/sampledb";
		String userName="xwj";
		String password="123456";
		Class.forName(driver);
		Connection connection=(Connection) DriverManager.getConnection(url, userName, password);
		String sql="select * from t_user";
		PreparedStatement statement=(PreparedStatement) connection.prepareStatement(sql);
		ResultSet resultSet=statement.executeQuery();
		System.out.println(resultSet.getRow());
		resultSet.close();
		statement.close();
		connection.close();
	}

}
