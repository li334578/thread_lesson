package com.li.thread_lesson.thread_demo;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description : Runnable接口
 * @date : 2020-11-28 10:41:23
 */
public class Test02 {
    public static void main(String[] args) {
        MyThread2 thread2 = new MyThread2();
        Thread thread = new Thread(thread2);
        thread.start();

        new Thread(new MyThread2()).start();
    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+":Runnable线程执行"+i);
        }
    }
}
