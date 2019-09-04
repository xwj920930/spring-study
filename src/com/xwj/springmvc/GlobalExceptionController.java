package com.xwj.springmvc;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/11 10:38
 * @Version 1.0
 **/
@ControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(RuntimeException.class)
    public String runtimeException(){
        return "forward:/error.jsp";
    }
}
