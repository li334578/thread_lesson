package com.li.thread_lesson.thread_demo;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description : 测试停止线程
 * @date : 2020-11-28 14:37:51
 */
public class Test09 {
    /*
     * 1.建议线程正常停止 -> 利用变量
     * 2.使用标志位
     * 3.不要使用stop、destroy
     */

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop,"A").start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("Main"+i);
            if (i==900){
                testStop.stop();
                System.out.println("线程停止");
            }
        }
    }
}

class TestStop implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() +"->"+ i);
            i++;
        }
    }

    public void stop(){
        this.flag = false;
    }
}