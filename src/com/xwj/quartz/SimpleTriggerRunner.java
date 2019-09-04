package com.xwj.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/10 9:37
 * @Version 1.0
 **/
public class SimpleTriggerRunner {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail=JobBuilder
                .newJob(SimpleJob.class)
                .withIdentity("myjob")
                .build();
        SimpleTrigger simpleTrigger= TriggerBuilder
                .newTrigger()
                .withIdentity("mytrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(2))
                .usingJobData("name","mytrigger")
                .build();
        SchedulerFactory factory=new StdSchedulerFactory();
        Scheduler scheduler=factory.getScheduler();
        scheduler.scheduleJob(jobDetail,simpleTrigger);
        scheduler.start();
    }
}
