package com.li.thread_lesson.thread_demo;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description : 售票
 * @date : 2020-11-28 10:58:33
 */
public class Test04 {
    public static void main(String[] args) {
        Sale sale = new Sale();
        new Thread(sale, "A").start();
        new Thread(sale, "B").start();
    }
}


class Sale implements Runnable {

    private int num = 10;

    @Override
    public synchronized void run() {
        while (true) {
            if (num <= 0) {
                break;
            }
            System.out.println(Thread
                    .currentThread()
                    .getName() + "拿到了第" + num + "张票");
            num--;
        }
    }
}