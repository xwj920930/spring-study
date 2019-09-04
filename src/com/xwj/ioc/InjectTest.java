package com.xwj.ioc;

import com.xwj.reflect.Boss;
import com.xwj.reflect.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.annotations.Test;

public class InjectTest {
	ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans.xml");
	@Test
	public void carSetter() {
		CarSetter car=context.getBean("carsetter",CarSetter.class);
		car.introduce();
	}
	@Test
	public void carConstructor() {
		CarContructor car=context.getBean("carconstructor",CarContructor.class);
		car.introduce();
	}
	@Test
	public void carFactory1() {
		Car car=context.getBean("carfactory1",Car.class);
		car.introduce();
	}
	@Test
	public void carFactory2() {
		Car car=context.getBean("carFactory2",Car.class);
		car.introduce();
	}
	@Test
	public void boss() {
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans2.xml");
		Boss boss=context.getBean("bossref",Boss.class);
		Boss boss1=context.getBean("bossref",Boss.class);
		boss.introduce();
		System.err.println(boss.getCar()==boss1.getCar());
	}
	@Test
	public void boss1() {
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans.xml");
		ApplicationContext context2=new FileSystemXmlApplicationContext(new String[]{"D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans2.xml"}, context);
		Boss boss=context2.getBean("bossref1",Boss.class);
		boss.introduce();
	}
	@Test
	public void innerBoss(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans2.xml");
		Boss boss=context.getBean("innerboss",Boss.class);
		boss.introduce();
	}
	@Test
	public void nullCar(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans2.xml");
		Car car=context.getBean("nullcar",Car.class);
		car.introduce();
	}
	@Test
	public void cascadeboss(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans2.xml");
		CascadeBoss boss=context.getBean("cascadeboss",CascadeBoss.class);
		boss.introduce();
	}
	@Test
	public void arrayboss(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans2.xml");
		ArrayBoss boss=context.getBean("arrayboss",ArrayBoss.class);
		boss.introduce();
	}
	@Test
	public void mergeboss(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans2.xml");
		ArrayBoss boss=context.getBean("childboss",ArrayBoss.class);
		boss.introduce();
	}
	@Test
	public void pcar(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans2.xml");
		Car boss=context.getBean("pcar",Car.class);
		boss.introduce();
	}
	@Test
	public void carref(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans2.xml");
		Car car1=context.getBean("carref",Car.class);
		Car car2=context.getBean("carref",Car.class);
		System.err.println(car1==car2);
	}
	@Test
	public void magicBoss(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans2.xml");
		MagicBoss boss1=context.getBean("magicboss",MagicBoss.class);
		MagicBoss boss2=context.getBean("magicboss",MagicBoss.class);
		System.err.println(boss1.getCar()==boss2.getCar());
	}
	@Test
	public void replaceBoss(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans2.xml");
		Boss1 boss1=context.getBean("boss1",Boss1.class);
		System.err.println(boss1.getCar().getBrand());
	}
	@Test
	public void absCar(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans3.xml");
		Car car1=context.getBean("abstractcar",Car.class);
		/*Car car2=context.getBean("abscar2",Car.class);
		car1.introduce();
		car2.introduce();*/
	}
	@Test
	public void refBoss(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans3.xml");
		Idref idref=context.getBean("idref",Idref.class);
		System.err.println(idref.getCar());
	}
	@Test
	public void pBoss(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans3.xml","D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans2.xml");
		Boss boss=context.getBean("pboss",Boss.class);
		boss.introduce();
	}
	@Test
	public void carinfo() throws Exception{
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans3.xml");
		/*CarInfo carInfo=context.getBean("&carinfo",CarInfo.class);
		carInfo.getObject().introduce();*/
		Car car=context.getBean("carinfo",Car.class);
		car.introduce();
	}
	@Test
	public void annoBoss(){
		ApplicationContext context=new FileSystemXmlApplicationContext("D:\\BeclipseWorkSpace\\SpringTest\\WebContent\\resource\\beans3.xml");
		AnnoBoss boss=context.getBean("annboss",AnnoBoss.class);
		((FileSystemXmlApplicationContext)context).destroy();
	}
}
