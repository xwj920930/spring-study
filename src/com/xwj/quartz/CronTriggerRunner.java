package com.xwj.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/10 9:37
 * @Version 1.0
 **/
public class CronTriggerRunner {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail=JobBuilder
                .newJob(SimpleJob.class)
                .withIdentity("myjob1")
                .build();
        CronTrigger cronTrigger= TriggerBuilder
                .newTrigger()
                .withIdentity("mytrigger1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                .usingJobData("name","mytrigger1")
                .build();
        SchedulerFactory factory=new StdSchedulerFactory();
        Scheduler scheduler=factory.getScheduler();
        scheduler.scheduleJob(jobDetail,cronTrigger);
        scheduler.start();
    }
}
