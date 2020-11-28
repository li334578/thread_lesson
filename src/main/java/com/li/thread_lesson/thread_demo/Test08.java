package com.li.thread_lesson.thread_demo;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description : lambda表达式2
 * @date : 2020-11-28 14:25:00
 */
public class Test08 {
    public static void main(String[] args) {

        ILove iLove = (a) -> System.out.println(a + "调用love方法");
        iLove.love("张三");
        /*
         * 接口必须是函数式接口
         * 只有一行代码的时候，可以省略{}
         * */
    }
}

interface ILove {
    void love(String a);
}

