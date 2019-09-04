package com.xwj.aop;

public class TestForumService {
	public static void main(String[] args) {
		ForumService service=new ForumServiceImpl();
		service.removeForum(10);
		service.removeTopic(20);
	}
}
