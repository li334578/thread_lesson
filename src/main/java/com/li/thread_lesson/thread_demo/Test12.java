package com.li.thread_lesson.thread_demo;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description : join 线程插队
 * @date : 2020-11-28 15:01:07
 */
public class Test12 {
    public static void main(String[] args) {
        MyJoin myJoin = new MyJoin();
        Thread threadVIP = new Thread(myJoin, "VIP");
        threadVIP.start();
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + "正在执行" + i);
            if (i==200){
                try {
                    threadVIP.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "正在执行" + i);
        }
    }
}