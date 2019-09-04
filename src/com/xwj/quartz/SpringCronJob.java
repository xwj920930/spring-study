package com.xwj.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/9 9:45
 * @Version 1.0
 **/
public class SpringCronJob extends QuartzJobBean{
    private static int times=0;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        System.err.println(jobExecutionContext.getJobDetail().getJobDataMap().getString("name"));
//        System.err.println(new Date()+"执行"+ ++times +"次");
    }
}
