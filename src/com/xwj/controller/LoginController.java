package com.xwj.controller;

import com.xwj.entity.LoginCommand;
import com.xwj.entity.User;
import com.xwj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value= "/login")
	public String loginPage() throws IOException{
		/*ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
		Resource resource=resolver.getResource("classpath:springmvc.xml");
		System.err.println(resource.getFile().getAbsolutePath());*/
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
		String userName=loginCommand.getUserName();
		String password=loginCommand.getPassword();
		boolean b=userService.hasMatchUser(userName, password);
		if(!b){
			return new ModelAndView("login","error","用户名或者密码错误");
		}else{
			User user=userService.findUserByUserName(userName);
			user.setLastIp(request.getLocalAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}
}
