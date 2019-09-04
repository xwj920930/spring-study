package com.xwj.springmvc;

import com.alibaba.fastjson.JSONObject;
import com.xwj.entity.People;
import com.xwj.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/21 9:57
 * @Version 1.0
 **/
@Controller
@RequestMapping("/people")
@SessionAttributes("people")
public class UserController {
    @Autowired
    PeopleService peopleService;
//    @ResponseBody
//    @ModelAttribute("people")
//    public People getPeople(){
//        People people=new People();
////        people.setPassWord("123");
//        return people;
//    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView create(People people){
        peopleService.insert(people);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("createSuccess");
        modelAndView.addObject("people",people);
        return modelAndView;
    }
    @RequestMapping(value = "/create1",method = RequestMethod.POST)
    @ResponseBody
    public String create1(@RequestParam("userName") String userName,
    @CookieValue(value = "JSESSIONID",required = false) String JSESSIONID,
    @RequestHeader("Connection") String Connection
    ){
        return "userName"+userName+";sessionId:"+JSESSIONID+";Connection:"+Connection;
    }
    @RequestMapping(value = "/req")
    public String toReqPage(){
        return "req";
    }
    //前台json对象，后台@requestParam，pojo
    @RequestMapping(value = "/json1",method = RequestMethod.POST)
    @ResponseBody
    public String json1(@RequestParam("userName") String userName,People people){
        return people.getUserName();
//        return new JSONObject().toJSONString();
    }
    //前台json字符串，后台@requestBody,pojo
    @RequestMapping(value = "/json2",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public People json2(@RequestBody People people){
        return people;
    }
    //前台json字符串，后台返回jsonobject
    @RequestMapping(value = "/json3",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject json3(@RequestBody People people){
        JSONObject object=new JSONObject();
        object.put("asd",people.getUserName());
        return object;
    }
    //前台json字符串
    @RequestMapping(value = "/httpReq",method = RequestMethod.POST)
    @ResponseBody
    public void httpReq(HttpServletRequest request, HttpServletResponse response){
        String name=request.getParameter("userName");
        try {
            response.getWriter().write(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "/model",method = RequestMethod.POST)
    public ModelAndView modelAndView(People people){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("people",people);
        modelAndView.setViewName("model");
        return modelAndView;
    }
    @RequestMapping(value = "/model1",method = RequestMethod.POST)
    public String modelAndView1(@ModelAttribute("people") People people){
        return "model";
    }
    @RequestMapping(value = "/model2",method = RequestMethod.POST)
    public String modelAndView2(ModelMap modelMap){
        modelMap.addAttribute("testAtt","value");
        People people= (People) modelMap.get("people");
        people.setUserName("asd");
        return "model";
    }
//    @RequestMapping(value = "/session",method = RequestMethod.GET)
//    public String session(ModelMap modelMap){
//        People people= new People();
//        people.setUserName("xwj");
//        people.setPassWord("123123");
//        modelMap.addAttribute("people",people);
//        return "redirect:/index.jsp";
//    }
@RequestMapping(value = "/session",method = RequestMethod.GET)
public String session(@ModelAttribute("people")People people){
        people.setPassWord("111");
    return "redirect:/index.jsp";
}
    @RequestMapping(value = "/session1",method = RequestMethod.GET)
    public String session1(ModelMap modelMap, SessionStatus sessionStatus){
        People people= (People) modelMap.get("people");
        System.err.println(people.getUserName());
        if(people!=null){
            sessionStatus.setComplete();
        }
        return "model";
    }
    @RequestMapping(value = "/jspp",method = RequestMethod.GET)
    public String session1(){
        return "createSuccess";
    }
}
