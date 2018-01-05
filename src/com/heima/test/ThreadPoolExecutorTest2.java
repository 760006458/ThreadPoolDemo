package com.heima.test;

import com.heima.thread.MyTask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * xuan
 * 2018/1/5
 */
public class ThreadPoolExecutorTest2 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 2, 5, TimeUnit.SECONDS, new ArrayBlockingQueue(3));
        //注意：一旦抛出RejectedExecutionException，那么线程池的shutdown和shutdownNow就会失效，导致线程池无法关闭
        for (int i = 0; i < 6; i++) {
            threadPool.execute(new MyTask(i));
        }
        threadPool.shutdownNow();
    }
}
