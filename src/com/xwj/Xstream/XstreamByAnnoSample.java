package com.xwj.Xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/16 20:33
 * @Version 1.0
 **/
public class XstreamByAnnoSample {
    private static XStream xStream;
    static {
        xStream=new XStream(new DomDriver());
        xStream.processAnnotations(XAnnoEntity.class);
    }
    public static List<XAnnoEntity> getEntity(){
        XAnnoEntity entity=new XAnnoEntity();
        entity.setId(123123);
        entity.setName("xwj");
        entity.setTime(new Date());
        entity.setList(Arrays.asList(1,2,3));
        List<XAnnoEntity> list=new ArrayList<>();
        list.add(entity);
        XAnnoEntity entity1=new XAnnoEntity();
        entity1.setId(123123);
        entity1.setName("xwj");
        entity1.setTime(new Date());
        entity1.setList(Arrays.asList(1,2,3));
        list.add(entity1);
        return list;
    }
    //java to xml
    public static void objToXml() throws FileNotFoundException {
        List<XAnnoEntity> entity=getEntity();
        FileOutputStream out=new FileOutputStream("D:\\test\\test1.xml");
        xStream.toXML(entity,out);
    }
    //xml to java
    public static void xmlToObj() throws FileNotFoundException {
        FileInputStream in=new FileInputStream("D:\\test\\test1.xml");
        XAnnoEntity entity= (XAnnoEntity) xStream.fromXML(in);
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
