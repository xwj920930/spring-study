package com.xwj.testNg;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/20 11:06
 * @Version 1.0
 **/
public class DemoTest {
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass...");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod...");
    }
    @Test
    public void test(){
        System.out.println("test...");
        Assert.assertEquals("123","123");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod...");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass...");
    }
}
