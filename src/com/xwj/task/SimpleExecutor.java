package com.xwj.task;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Description executor
 * @Author yuki
 * @Date 2018/8/16 9:14
 * @Version 1.0
 **/
public class SimpleExecutor {
    public static void main(String[] args) {
        Executor executor= Executors.newFixedThreadPool(3);
        for(int i=0;i<12;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.err.println("task"+Thread.currentThread().getId());
                }
            });
        }
    }
}
