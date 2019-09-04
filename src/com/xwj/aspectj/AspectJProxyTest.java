package com.xwj.aspectj;

import com.xwj.anno.FService;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.annotations.Test;

import java.sql.SQLException;


public class AspectJProxyTest {
	ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans5.xml");
	@Test
	public void byBean(){
		Waiter waiter=context.getBean("naivewaiter",Waiter.class);
		waiter.serverTo("asd");
		waiter.greetTo("asd");
	}
	@Test
	public void byBeanParent(){
		Waiter waiter=context.getBean("naivewaiter",Waiter.class);
		waiter.serverTo("asd");
		waiter.greetTo("asd");
		Seller seller=(Seller) waiter;
		seller.sell("beer", "name");
	}
	@Test
	public void anno(){
		Waiter waiter=context.getBean("naivewaiter",Waiter.class);
		waiter.serverTo("asd");
		FService service=context.getBean("fservice",FService.class);
		service.add();
		service.delete();
	}
	@Test
	public void byBeanThis(){
		Waiter waiter=(Waiter) context.getBean("naivewaiter");
		waiter.serverTo("asd");
		waiter.greetTo("asd");
		((Seller) waiter).sell("beer", "asd");
	}
	@Test
	public void bindParam(){
		Waiter waiter=context.getBean("naivewaiter",Waiter.class);
		waiter.serverTo("asd");
	}
	@Test
	public void bindProxy(){
		Waiter waiter=context.getBean("naivewaiter",Waiter.class);
		waiter.serverTo("asd");
	}
	@Test
	public void bindAnno(){
		Waiter waiter=context.getBean("naivewaiter",Waiter.class);
		waiter.serverTo("asd");
		FService service=context.getBean("fservice",FService.class);
		service.add();
		service.delete();
	}
	@Test
	public void bindReturn(){
		Waiter waiter=context.getBean("naivewaiter",Waiter.class);
		waiter.returnTo();
	}
	@Test
	public void bindThrow() throws IllegalAccessException, SQLException{
		Waiter waiter=context.getBean("naivewaiter",Waiter.class);
		waiter.throwEx(1);
	}
	@Test
	public void schemaPre(){
		Waiter waiter=context.getBean("naivewaiter",Waiter.class);
		waiter.greetTo("asd");;
	}
	public static void main(String[] args) {
		NaiveWaiter waiter=new NaiveWaiter();
		AspectJProxyFactory factory=new AspectJProxyFactory();
		factory.setTarget(waiter);
		factory.addAspect(PreGreetingAspect.class);
		NaiveWaiter pWaiter=factory.getProxy();
		pWaiter.serverTo("asd");
		pWaiter.greetTo("zxc");
	}
}
