package com.xwj.springjdbc;

import com.mysql.jdbc.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class JDBCFunction extends AbstractTestNGSpringContextTests {
	@Autowired
	JdbcTemplate jdbcTemplate;

	// 增
	@Test
	public void insert() {
		String sql = "INSERT INTO msg VALUES (?,?);";
		Object[] params = new Object[] { 2, "asd" };
		jdbcTemplate.update(sql, params, new int[] { Types.INTEGER, Types.VARCHAR });
	}

	// 改
	@Test
	public void update() {
		String sql = "UPDATE msg SET username='fgh' WHERE id=3;";
		jdbcTemplate.update(sql);
	}

	// 删
	@Test
	public void delete() {
		String sql = "DELETE FROM msg WHERE id=3;";
		jdbcTemplate.update(sql);
	}

	// jdbcTemplate.update(sql,new PreparedStatementSetter(){})
	@Test
	public void updatePrepare() {
		String sql = "UPDATE msg SET username=? WHERE id=?;";
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement statement) throws SQLException {
				statement.setString(1, "xwj2");
				statement.setInt(2, 1);
			}
		});
	}

	// jdbcTemplate.update(new PreparedStatementCreator(){})
	@Test
	public void updatePrepareCreator() {
		final String sql = "UPDATE msg SET username=? WHERE id=?;";
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, "xwj2");
				statement.setInt(2, 1);
				return statement;
			}
		});
	}

	@Test
	public void select() {
		String sql = "UPDATE msg SET username='zxc' WHERE id=2;";
		Object[] params = new Object[] { 2, "asd" };
		jdbcTemplate.update(sql, params, new int[] { Types.INTEGER, Types.VARCHAR });
	}

	// jdbc返回自增键
	@Test
	public void autokey() throws ClassNotFoundException, SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String userName = "xwj";
		String password = "123456";
		Class.forName(driver);
		Connection connection = (Connection) DriverManager.getConnection(url, userName, password);
		Statement statement = (Statement) connection.createStatement();
		String sql = "INSERT INTO msg (username) VALUES ('qoo');";
		statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		ResultSet set = statement.getGeneratedKeys();
		if (set.next()) {
			System.out.println(set.getInt(1));
		}
	}

	// spring返回自增键
	@Test
	public void springkey() {
		final String sql = "INSERT INTO msg (username) VALUES (?);";
		KeyHolder holder=new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, "xwj2");
				return statement;
			}
		},holder);
		System.out.println(holder.getKey());
	}
	//批量
	@Test
	public void batch() {
		final List<Msg> mList=new ArrayList<>();
		Msg msg1=new Msg();
		msg1.setUsername("111");
		Msg msg2=new Msg();
		msg2.setUsername("222");
		mList.add(msg1);
		mList.add(msg2);
		String sql = "INSERT INTO msg (username) VALUES (?);";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement statement, int i) throws SQLException {
				Msg msg=mList.get(i);
				statement.setString(1, msg.getUsername());
			}
			@Override
			public int getBatchSize() {
				return mList.size();
			}
		});
	}
	//查询
	@Test
	public void query() {
		String sql = "SELECT * FROM msg LIMIT ?;";
		final List<String> strings=new ArrayList<>();
		jdbcTemplate.query(sql,new Object[]{5},new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet resultSet) throws SQLException {
					strings.add(resultSet.getString("username"));
			}
		});
		System.err.println(strings.toString());
	}
	//rowmap
	@Test
	public void querymap() {
		String sql = "SELECT * FROM msg LIMIT ?;";
		final List<String> strings=new ArrayList<>();
		jdbcTemplate.query(sql,new Object[]{5},new RowMapper<Object>() {
			@Override
			public Object mapRow(ResultSet resultSet, int i) throws SQLException {
				strings.add(resultSet.getString("username"));
				return strings;
			}
		});
		System.err.println(strings.toString());
	}
	//单值
	@Test
	public void queryforint() {
		String sql = "SELECT COUNT(*) FROM msg LIMIT 5;";
		int i=jdbcTemplate.queryForObject(sql, Integer.class);
		System.err.println(i);
	}
	//单值
		@Test
		public void queryforobj() {
			final Msg msg=new Msg();
			String sql = "SELECT * FROM msg WHERE id=2;";
			jdbcTemplate.queryForObject(sql, new RowMapper<Object>() {
				@Override
				public Object mapRow(ResultSet resultSet, int i) throws SQLException {
					msg.setId(resultSet.getInt("id"));
					msg.setUsername(resultSet.getString("username"));
					return msg;
				}
			});
			System.out.println(msg.getUsername());
		}
}
