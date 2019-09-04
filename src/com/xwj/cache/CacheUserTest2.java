package com.xwj.cache;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Description spring cache test
 * @Author yuki
 * @Date 2018/8/7 10:28
 * @Version 1.0
 **/
public class CacheUserTest2 {
    public static void main(String[] args) {
        ApplicationContext context=new FileSystemXmlApplicationContext("D:\\工作\\project\\SpringTest\\WebContent\\resource\\beans7.xml");
        NewCacheUserService service=context.getBean("serviceBean", NewCacheUserService.class);
        System.err.println("first query...");
        service.getUserById("xwj");
        System.err.println("second query...");
        service.getUserById("xwj");
    }
}
