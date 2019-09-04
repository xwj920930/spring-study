package com.xwj.SpEL;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.testng.annotations.Test;

import java.util.*;

public class LiteraExpSample {
	//文本字符解析
	@Test
	public void test1() {
		ExpressionParser parser=new SpelExpressionParser();
		String s=(String) parser.parseExpression("'asd'").getValue();
		double d=(double) parser.parseExpression("10.002").getValue();
		int i=(int) parser.parseExpression("4").getValue();
		boolean b=(boolean) parser.parseExpression("false").getValue();
		Object o=parser.parseExpression("null").getValue();
		System.out.println(s+d+i+b+o);
	}
	//对象属性解析
	@Test
	public void test2() {
		User user=new User();
		user.setName("asd");
		user.setCredits(100);
		user.setHome(new Home("china", "chengdu"));
		ExpressionParser parser=new SpelExpressionParser();
		EvaluationContext conte1=new StandardEvaluationContext(user);
		String name=(String) parser.parseExpression("name").getValue(conte1);
		System.out.println(name);
		String city=(String) parser.parseExpression("home.city").getValue(conte1);
		System.out.println(city);
	}
	//集合类型解析
	@Test
	public void test3() {
		User2 user=new User2();
		user.setName("asd");
		user.setCredits(100);
		ExpressionParser parser=new SpelExpressionParser();
		EvaluationContext context=new StandardEvaluationContext(user);
		int[] array1=(int[]) parser.parseExpression("new int[]{1,2,3}").getValue(context);
		List list=(List) parser.parseExpression("{1,2,3}").getValue(context);
		//Map map=(Map) parser.parseExpression("{name:'tom',credits:100}").getValue(context);
		System.out.println(array1[0]);
		System.out.println(list.get(0));
		int i=(int) parser.parseExpression("{1,2,3}[0]").getValue(context);
		System.out.println(i);
		System.out.println((int) parser.parseExpression("new int[]{1,2,3}[0]").getValue(context));
		//System.out.println(map.get("name"));
	}
	//方法解析
	@Test
	public void test4() {
		User2 user=new User2();
		ExpressionParser parser=new SpelExpressionParser();
		EvaluationContext context=new StandardEvaluationContext(user);
		String string=(String) parser.parseExpression("'spring spel'.substring(0,5)").getValue();
		int i=(int) parser.parseExpression("'spring spel'.indexOf('n')").getValue();
		System.err.println(string+i);
		boolean b=(boolean) parser.parseExpression("validatePwd('123456')").getValue(context);
		System.err.println(b);
	}
	//操作符解析
	@Test
	public void test5() {
		ExpressionParser parser=new SpelExpressionParser();
		System.out.println(parser.parseExpression("2<5").getValue(Boolean.class));
		System.out.println(parser.parseExpression("'a'<'b'").getValue(Boolean.class));
		System.out.println(parser.parseExpression("'asd' instanceof T(String)").getValue(Boolean.class));
		System.out.println(parser.parseExpression("true and false").getValue(Boolean.class));
		System.out.println(parser.parseExpression("(1+2*3)%2/2").getValue(Double.class));
	}
	//安全导航操作符
	@Test
	public void test6() {
		User user=new User();
		user.setName("asd");
		user.setCredits(100);
		user.setHome(new Home("china", "chengdu"));
		ExpressionParser parser=new SpelExpressionParser();
		EvaluationContext conte1=new StandardEvaluationContext(user);
		//String city=(String) parser.parseExpression("home.city").getValue(conte1);
		user.setHome(null);
		System.err.println(parser.parseExpression("home?.city").getValue(conte1,String.class));
	}
	//三元运算符
	@Test
	public void test7() {
		ExpressionParser parser=new SpelExpressionParser();
		System.err.println(parser.parseExpression("1>2?true:false").getValue(Boolean.class));
	}
	//Elvis操作符
	@Test
	public void test8() {
		User user=new User();
		user.setName("asd");
		ExpressionParser parser=new SpelExpressionParser();
		EvaluationContext conte1=new StandardEvaluationContext(user);
		//String city=(String) parser.parseExpression("home.city").getValue(conte1);
		user.setName(null);
		System.err.println(parser.parseExpression("name?:'用户名为空'").getValue(conte1,String.class));
	}
	//赋值，类型，构造，变量
	@Test
	public void test9() {
		User user=new User();
		ExpressionParser parser=new SpelExpressionParser();
		EvaluationContext conte1=new StandardEvaluationContext(user);
		parser.parseExpression("name").setValue(conte1, "tom");
		System.err.println(user.getName());
		parser.parseExpression("name='jery'").getValue(conte1);
		System.err.println(user.getName());

		Class class1=parser.parseExpression("T(java.lang.String)").getValue(Class.class);
		System.err.println(class1==String.class);

		User user2=parser.parseExpression("new com.xwj.SpEL.User('tt')").getValue(User.class);
		System.err.println(user2.getName());
		
		conte1.setVariable("newName", "kk");
		parser.parseExpression("name=#newName").getValue(conte1);
		//parser.parseExpression("name").setValue(conte1, "#newName");
		System.err.println(user.getName());
		
	}
	//集合过滤
	@Test
	public void test10() {
		ExpressionParser parser=new SpelExpressionParser();
		EvaluationContext context=new StandardEvaluationContext();
		List list=new ArrayList<>(Arrays.asList(100,101,99,98,102));
		context.setVariable("list", list);
		List l=(List) parser.parseExpression("#list.?[#this>100]").getValue(context);
		System.err.println(l.toString());
		Map map=new HashMap<>();
		map.put(1, 1);
		map.put(3, 3);
		context.setVariable("map", map);
		Map m=(Map) parser.parseExpression("#map.?[value>2]").getValue(context);
		Map m1=(Map) parser.parseExpression("#map.?[key<2]").getValue(context);
		System.err.println(m.toString());
		System.err.println(m1.toString());
	}
	//集合转换
	@Test
	public void test11() {
		ExpressionParser parser=new SpelExpressionParser();
		EvaluationContext context=new StandardEvaluationContext();
		List list=new ArrayList<>(Arrays.asList(100,101,99,98,102));
		context.setVariable("list", list);
		List l=(List) parser.parseExpression("#list.![#this>100]").getValue(context);
		System.err.println(l.toString());
	}
}
