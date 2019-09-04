package com.xwj.SpEL;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class HelloWorld {
	public static void main(String[] args) {
		ExpressionParser parser=new SpelExpressionParser();
		Expression expression=parser.parseExpression("'hellow'");
		String msg=(String) expression.getValue();
		System.out.println(msg);
	}
}
