package com.heima.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * xuan
 * 2018/1/5
 */
public class ThreadPoolExecutorTest1 extends Thread {
    static AtomicInteger count = new AtomicInteger(0);

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = count.incrementAndGet();
        System.out.println("任务" + i + "执行");
    }

    public static void main(String[] args) {
        //对于有界队列，最多同时处理的任务数是：maximumPoolSize + 队列长度，多余的会丢掉（默认：RejectedExecutionException）
        //RejectedExecutionException: [Running, pool size = 5, active threads = 5, queued tasks = 4, completed tasks = 0]
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, //corePoolSize
                                                            5, //maximumPoolSize
                                                            5,//keepAliveTime
                                                            TimeUnit.SECONDS,//unit
//                                                            new ArrayBlockingQueue<Runnable>(4));  //workQueue
                                                            new LinkedBlockingQueue<Runnable>());  //workQueue

        executor.prestartAllCoreThreads();
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getActiveCount());
        for (int i = 0; i < 10; i++) {  //丢掉1个任务
            executor.execute(new ThreadPoolExecutorTest1());
        }
        executor.shutdown();
    }
}
