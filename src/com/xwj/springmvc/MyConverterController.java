package com.xwj.springmvc;

import com.alibaba.fastjson.JSONObject;
import com.xwj.entity.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/3 17:29
 * @Version 1.0
 **/
@Controller
@RequestMapping("/converter")
public class MyConverterController {
    @RequestMapping(value = "/convert",method = RequestMethod.GET)
    public String convert(@RequestParam("people") People people, ModelMap modelMap){
        modelMap.addAttribute("people",people);
        return "model";
    }
    @RequestMapping(value = "/format",method = RequestMethod.POST)
    @ResponseBody
    public People format(People people, ModelMap modelMap){
        people.setTime(new Date());
        return people;
    }

}
