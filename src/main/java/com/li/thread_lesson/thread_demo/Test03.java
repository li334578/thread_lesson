package com.li.thread_lesson.thread_demo;

import java.util.concurrent.*;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description :
 * @date : 2020-11-28 10:56:35
 */
public class Test03 {
    public static void main(String[] args) {
        MyThread3 m1 = new MyThread3();
        MyThread3 m2 = new MyThread3();
        MyThread3 m3 = new MyThread3();
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<String> futureTask1 = service.submit(m1);
        Future<String> futureTask2 = service.submit(m2);
        Future<String> futureTask3 = service.submit(m3);
        try {
            System.out.println(futureTask1.get());
            System.out.println(futureTask2.get());
            System.out.println(futureTask3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }


    }
}

class MyThread3 implements Callable {

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + "success";
    }
}

