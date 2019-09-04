package com.xwj.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/10 9:37
 * @Version 1.0
 **/
public class CronTriggerWithCalendarRunner {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail=JobBuilder
                .newJob(SimpleJob.class)
                .withIdentity("myjob2")
                .build();
        AnnualCalendar annualCalendar=new AnnualCalendar();
        Calendar day=new GregorianCalendar(2018,7,13);
        annualCalendar.setDayExcluded(day,true);
        CronTrigger cronTrigger= TriggerBuilder
                .newTrigger()
                .withIdentity("mytrigger2")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                //注册日历
                .modifiedByCalendar("holiday")
                .build();
        SchedulerFactory factory=new StdSchedulerFactory();
        Scheduler scheduler=factory.getScheduler();
        //注册日历
        scheduler.addCalendar("holiday",annualCalendar,false,false);
        scheduler.scheduleJob(jobDetail,cronTrigger);
        scheduler.start();
    }
}
