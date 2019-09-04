package com.xwj.Xstream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/18 16:35
 * @Version 1.0
 **/
public class SpringOXMTest {
    private Marshaller marshaller;

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    private Unmarshaller unmarshaller;
    public static XstreamEntity getEntity(){
        XstreamEntity entity=new XstreamEntity();
        entity.setId(123123);
        entity.setName("xwj");
        entity.setTime(new Date());
        return entity;
    }
    public void objToXml() throws IOException {
        XstreamEntity entity=getEntity();
        FileOutputStream out=new FileOutputStream("D:\\test\\test2.xml");
        this.marshaller.marshal(entity,new StreamResult(out));
    }
    public void xmlToObj() throws IOException {
        FileInputStream in=new FileInputStream("D:\\test\\test2.xml");
        XstreamEntity entity= (XstreamEntity) this.unmarshaller.unmarshal(new StreamSource(in));
        System.out.println(entity.getName());
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SpringOXMTest springOXMTest= (SpringOXMTest) context.getBean("springOxm");
        springOXMTest.objToXml();
        springOXMTest.xmlToObj();
    }
}
