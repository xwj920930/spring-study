package com.xwj.springmvc;

import com.xwj.entity.People;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/3 17:29
 * @Version 1.0
 **/
@Controller
@RequestMapping("/excel")
public class ExcelController {
    @RequestMapping(value = "/jsp")
    public String jsp(ModelMap modelMap){
        List<People> list=new ArrayList<>();
        People people=new People();
        people.setUserName("xwj");
        people.setPassWord("123123");
        people.setTime(new Date());
        list.add(people);
        modelMap.addAttribute("people",list);
        return "userListView";
    }
}
