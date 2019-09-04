package com.xwj.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/9 9:45
 * @Version 1.0
 **/
@Component("simpleService")
public class SpringSimpleJob{
    private static int times=0;
    public void doJob(){
//        System.err.println("springSimpleJob");
//        System.err.println(new Date()+"执行"+ ++times +"次");
    }
}
