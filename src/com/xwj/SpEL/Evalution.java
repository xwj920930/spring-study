package com.xwj.SpEL;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Evalution {
	public static void main(String[] args) {
		User user=new User();
		user.setName("asd");
		user.setCredits(100);
		ExpressionParser parser=new SpelExpressionParser();
		EvaluationContext context=new StandardEvaluationContext(user);
		String name=(String) parser.parseExpression("name").getValue(context);
		System.out.println(name);
	}
}
