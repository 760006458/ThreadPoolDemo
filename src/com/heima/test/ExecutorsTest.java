package com.heima.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * xuan
 * 2018/1/5
 */
public class ExecutorsTest{
    public static void main(String[] args) {
        ExecutorService threadPool1 = Executors.newCachedThreadPool();
        ExecutorService threadPool2 = Executors.newFixedThreadPool(100);
        ScheduledExecutorService threadPool3 = Executors.newScheduledThreadPool(100);
        ExecutorService threadPool4 = Executors.newSingleThreadExecutor();

    }
}
