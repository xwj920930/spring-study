package com.xwj.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/11 10:11
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/exc")
public class ExceptionController {
    @RequestMapping(value = "/run")
    public String throwException(){
        if (true){
            throw new RuntimeException();
        }
        return "";
    }
//    @ExceptionHandler(RuntimeException.class)
//    public String getException(RuntimeException e){
//        return "forward:/error.jsp";
//    }
}
