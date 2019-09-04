package com.xwj.quartz;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/14 20:58
 * @Version 1.0
 **/
public class TimeTaskRunner {
    public static void main(String[] args) {
        Timer timer=new Timer();
        TimerTask timerTask=new SimpleTimerTask();
        timer.schedule(timerTask,1000,1000);
    }
}
