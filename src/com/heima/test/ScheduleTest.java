package com.heima.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * xuan
 * 2018/1/5
 */
public class ScheduleTest extends Thread {
    public void run() {
        System.out.println("定时执行");
    }

    public static void main(String[] args) {
        ScheduleTest scheduleTest = new ScheduleTest();
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(3);
        threadPool.scheduleAtFixedRate(scheduleTest,1,3, TimeUnit.SECONDS);
    }
}
