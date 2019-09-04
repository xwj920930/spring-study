package com.xwj.Xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/16 20:33
 * @Version 1.0
 **/
public class XstreamSample {
    private static XStream xStream;
    static {
        xStream=new XStream(new DomDriver());
        xStream.alias("XstreamEntity",XstreamEntity.class);
//        xStream.aliasField("userId",XstreamEntity.class,"id");
        xStream.aliasAttribute(XstreamEntity.class,"id","userId");
        xStream.useAttributeFor(XstreamEntity.class,"id");
        xStream.addImplicitCollection(XstreamEntity.class,"list");
        xStream.registerConverter(new DateConverter(Locale.CHINA));
    }
    public static XstreamEntity getEntity(){
        XstreamEntity entity=new XstreamEntity();
        entity.setId(123123);
        entity.setName("xwj");
        entity.setTime(new Date());
        entity.setList(Arrays.asList(1,2,3));
        return entity;
    }
    //java to xml
    public static void objToXml() throws FileNotFoundException {
        XstreamEntity entity=getEntity();
        FileOutputStream out=new FileOutputStream("D:\\test\\test.xml");
        xStream.toXML(entity,out);
    }
    //xml to java
    public static void xmlToObj() throws FileNotFoundException {
        FileInputStream in=new FileInputStream("D:\\test\\test.xml");
        XstreamEntity entity= (XstreamEntity) xStream.fromXML(in);
        System.out.println(entity.getName());
    }

    public static void main(String[] args) {
        try {
            objToXml();
//            xmlToObj();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
