package com.heima.thread;

/**
 * xuan
 * 2018/1/5
 */
public class MyTask implements Runnable {

    private int i;

    public MyTask() {
    }

    public MyTask(int i) {
        this.i = i;
    }

    public void run() {
        System.out.println("执行第" + i + "个");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
