package com.xwj.websocket;

import com.xwj.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/9/10 9:48
 * @Version 1.0
 **/
@RequestMapping("/websocket")
@Controller
public class MsgController {
    @Autowired
    private MsgScoketHandle msgScoketHandle;
    @RequestMapping("/login")
    public String login(People people, HttpServletRequest request){
        request.getSession().setAttribute("people",people);
        return "socket";
    }
    @ResponseBody
    @RequestMapping(value = "/sendMsg",produces = "application/json; charset=utf-8")
    public String sendMsgToUser(String content,String toUserName){
        People people = new People();
        people.setUserName(toUserName);
        TextMessage textMessage = new TextMessage(content);
        msgScoketHandle.sendMessageToUser(people,textMessage);
        return "发送成功";
    }
    @ResponseBody
    @RequestMapping(value = "/sendMsg2",produces = "application/json; charset=utf-8")
    public String sendMsgToAll(String content) throws Exception {
        TextMessage textMessage = new TextMessage(content);
        msgScoketHandle.sendMsgToAllUsers(textMessage);
        return "发送成功";
    }
}
