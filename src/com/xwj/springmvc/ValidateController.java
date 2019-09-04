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

import java.util.List;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/3 17:29
 * @Version 1.0
 **/
@Controller
@RequestMapping("/validate")
public class ValidateController {
    @RequestMapping(value = "/jsp")
    public ModelAndView jsp(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("validate");
//        modelAndView.setViewName("redirect:/hello.jsp");
        return modelAndView;
    }
    @RequestMapping(value = "/locale")
    public String locale(){
        return "locale";
    }
    @RequestMapping(value = "/people",method = RequestMethod.POST)
    public String convert(ModelMap modelMap, @Validated People people, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> errors=bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                System.err.println(error.getDefaultMessage());
            }
            modelMap.addAttribute("errors",errors);
            return "validate";
        }
        modelMap.addAttribute("people",people);
        return "model";
    }
}
