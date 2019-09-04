package com.xwj.aop;

import java.sql.SQLException;

public interface ForumService {
	public void removeTopic(int topicId);
	public void removeForum(int forumId);
	public void exception() throws SQLException;
}
