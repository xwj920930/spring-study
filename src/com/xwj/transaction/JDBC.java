package com.xwj.transaction;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class JDBC {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/test_1";
		String userName="xwj";
		String password="123456";
		Class.forName(driver);
		Connection connection=(Connection) DriverManager.getConnection(url, userName, password);
		connection.setAutoCommit(false);
		connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		Savepoint savepoint=connection.setSavepoint("point1");
		String sql="select * from a";
		PreparedStatement statement=(PreparedStatement) connection.prepareStatement(sql);
		ResultSet resultSet=statement.executeQuery();
		connection.commit();
		//connection.rollback(savepoint);
		System.out.println(resultSet.getRow());
		resultSet.close();
		statement.close();
		connection.close();
	}
}
