package com.li.thread_lesson.thread_demo;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description : 线程礼让 yield
 * @date : 2020-11-28 14:57:06
 */
public class Test11 {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"A").start();
        new Thread(myYield,"B").start();
    }
}

class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield(); // 礼让
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}
