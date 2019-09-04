package com.xwj.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/9 9:45
 * @Version 1.0
 **/
public class SimpleJob implements Job{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        System.err.println(context.getTrigger()
//                .getJobDataMap()
//                .getString("name")+",time is:"+new Date());
    }
}
