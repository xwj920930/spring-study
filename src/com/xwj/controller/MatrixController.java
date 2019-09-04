package com.xwj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/27 9:03
 * @Version 1.0
 **/
@Controller
@RequestMapping("/matrix")
public class MatrixController {
    @RequestMapping(value = "/get/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public String getMatrix(@MatrixVariable() int a,@MatrixVariable() int b){
        System.err.println("");
        System.err.println(a);
        return "";
    }
    @RequestMapping("/getMap/{userId}")
    @ResponseBody
    public String getMatrix1(@MatrixVariable() Map a){
        System.err.println(a);
        return String.valueOf(a);
    }
    @RequestMapping("/getMap/{id1}/{id2}")
    @ResponseBody
    public String getMatrix2(@MatrixVariable(pathVar = "id1") Map a,@MatrixVariable(pathVar = "id2") Map b){
        System.err.println(a);
        return String.valueOf(a)+String.valueOf(b);
    }
}
