package com.li.thread_lesson.thread_demo;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description : 代理模式
 * @date : 2020-11-28 13:57:02
 */
public class Test06 {
    public static void main(String[] args) {

        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();

        new Thread(() -> System.out.println("Thanks♪(･ω･)ﾉ")).start();
        new WeddingCompany((new You())).HappyMarry();
    }
}

/*
 * 真实对象和代理对象都要实现同一个接口
 * 代理对象要代理真实对象
 * 好处：
 *   代理对象可以做很多真实对象做不了的事
 *   真实对象专注于做自己的事情
 * */
interface Marry {
    void HappyMarry();
}

// 真实角色
class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("你结婚了，超开心");
    }
}

// 代理角色
class WeddingCompany implements Marry {
    // 代理目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry(); // 真实对象调用方法
        after();
    }

    private void after() {
        System.out.println("之后");
    }

    private void before() {
        System.out.println("之前");
    }
}