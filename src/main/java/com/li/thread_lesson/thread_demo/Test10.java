package com.li.thread_lesson.thread_demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description : 模拟网络延时
 * @date : 2020-11-28 14:47:23
 */
public class Test10 {
    public static void main(String[] args) {
        tenDown();
        // 放大问题的发生性

        Date date = new Date(System.currentTimeMillis()); // 获取系统当前时间
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
                date = new Date(System.currentTimeMillis()); // 更新时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void tenDown() {
        int num = 10;
        while (num > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num--);
        }
    }


}
