package com.li.thread_lesson.thread_demo;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description : 继承Thread
 * @date : 2020-11-28 10:08:31
 */
public class Test01 {
    public static void main(String[] args) {
        // main线程和myThread线程交替执行
        MyThread1 thread1 = new MyThread1();
        thread1.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+":Main线程执行"+i);
        }
        /*
        * 线程开启不一定立即执行需要CPU调度执行
        * */
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+":MyThread线程执行"+i);
        }
    }
}