package com.xwj.quartz;

import java.util.Date;
import java.util.TimerTask;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/14 20:
 * @Version 1.0
 **/
public class SimpleTimerTask extends TimerTask{
    private int count=0;
    @Override
    public void run() {
        Date date=new Date(scheduledExecutionTime());
//        System.err.println("执行"+(count+1)+"次,时间为"+date);
        if(++count>5){
            cancel();
        }
    }
}
