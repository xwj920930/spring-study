package com.xwj.springmvc;

import com.xwj.entity.People;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @Description 对象转换器
 * @Author yuki
 * @Date 2018/9/3 17:20
 * @Version 1.0
 **/
public class StringToPeopleConverter implements Converter<String,People>{
    @Override
    public People convert(String s) {
        People people=new People();
        if(s != null){
            String[] strs=s.split(":");
            people.setUserName(strs[0]);
            people.setPassWord(strs[1]);
            return people;
        }else {
            return null;
        }
    }
}
