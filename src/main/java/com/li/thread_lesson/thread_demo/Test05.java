package com.li.thread_lesson.thread_demo;

import java.util.concurrent.TimeUnit;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description : 龟兔赛跑
 * @date : 2020-11-28 11:02:53
 */
public class Test05 {
    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "乌龟").start();
        new Thread(race, "兔子").start();
    }
}


class Race implements Runnable {

    private int num = 100;

    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <= num; i++) {
            // 模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子")) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 判断比赛是否结束
            boolean flag = gameOver(i);
            if (flag) break;
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "步");
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null) {
            System.out.println("出现胜利者");
            return true;
        } else {
            if (steps >= num) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is" + winner);
                return true;
            }
        }
        return false;
    }
}