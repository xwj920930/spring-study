package com.xwj.testNg;

import com.xwj.entity.User;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/20 11:06
 * @Version 1.0
 **/
public class DemoTest2 {
    @Test(enabled = true,expectedExceptions = RuntimeException.class)
    public void test(){
        throw new RuntimeException();
    }
    @Test(timeOut = 10)
    public void timeout() throws InterruptedException {
        Thread.currentThread().sleep(1000);
        Assert.assertNotNull(new User());
    }
    @DataProvider(name = "testData")
    public Object[][] getParam(){
        String[][] param={{"qwe"},{"asd"},{"zxc"}};
        return param;
    }
    @Test(dataProvider = "testData")
    public void testParam(String s){
        System.out.println(s);
    }
    @Test
    public void test1(){
        System.out.println("this is test1 method");
    }
    @Test(dependsOnMethods = {"test1"})
    public void testOrder(){
        System.out.println("this is testOrder method");
    }
}
