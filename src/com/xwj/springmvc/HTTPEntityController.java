package com.xwj.springmvc;

import com.alibaba.fastjson.JSONObject;
import com.xwj.entity.People;
import com.xwj.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/21 9:57
 * @Version 1.0
 **/
@Controller
@RequestMapping("/http")
public class HTTPEntityController {
    @RequestMapping(value = "/entity",method = RequestMethod.POST)
    public ResponseEntity<String> httpReq(HttpEntity<String> entity){
        String body=entity.getBody().toString();
        ResponseEntity responseEntity=new ResponseEntity<>(body,HttpStatus.OK);
        return responseEntity;
    }
}
