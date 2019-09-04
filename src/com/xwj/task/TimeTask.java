package com.xwj.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description spring task 测试
 * @Author yuki
 * @Date 2018/8/8 19:45
 * @Version 1.0
 **/
@Component
public class TimeTask {
    @Scheduled(cron = "* * * * * ?")
    public void test(){
        System.err.println(new Date()+":执行");
    }
}
