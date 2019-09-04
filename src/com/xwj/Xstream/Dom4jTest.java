package com.xwj.Xstream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/17 9:39
 * @Version 1.0
 **/
public class Dom4jTest {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader=new SAXReader();
        Document document=reader.read("D:\\test\\book.xml");
        //获取root节点(bookStore)
        Element bookStore=document.getRootElement();
        //获取root子节点(book)
        Iterator iterator=bookStore.elementIterator();
        //遍历book
        while (iterator.hasNext()){
            Element book= (Element) iterator.next();
            List<Attribute> bookAttrs=book.attributes();
            //遍历book的属性(id)
            for (Attribute bookAttr : bookAttrs) {
                System.out.println("属性名："+bookAttr.getName()+";属性值："+bookAttr.getValue());
            }
            Iterator it=book.elementIterator();
            //遍历book的节点(name/year/price/language)
            while (it.hasNext()){
                Element element= (Element) it.next();
                System.out.println("节点名："+element.getName()+";节点值："+element.getStringValue());
            }
        }
    }
}
