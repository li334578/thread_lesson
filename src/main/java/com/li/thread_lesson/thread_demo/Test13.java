package com.li.thread_lesson.thread_demo;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description : 线程优先级Priority
 * @date : 2020-11-28 15:16:58
 */
public class Test13 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "主线程优先级:" + Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();
        Thread thread1 = new Thread(myPriority, "A");
        Thread thread2 = new Thread(myPriority, "B");
        Thread thread3 = new Thread(myPriority, "C");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "优先级:" + Thread.currentThread().getPriority());
    }
}