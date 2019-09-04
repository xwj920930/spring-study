package com.xwj.anno;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ToolTest {
	@Test
	public void test(){
		Class<FService> clazz=FService.class;
		Method[] methods=clazz.getDeclaredMethods();
		for (Method method : methods) {
			NeedTest needTest=method.getAnnotation(NeedTest.class);
			if(needTest!=null){
				if(needTest.value()){
					System.err.println(method.getName()+"需要测试");
				}else{
					System.err.println(method.getName()+"不需要测试");
				}
			}
		}
	}
}
