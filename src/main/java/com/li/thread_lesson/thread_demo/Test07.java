package com.li.thread_lesson.thread_demo;

/**
 * @author : LiWenBo
 * @program : thread_lesson
 * @description : lambda表达式
 * @date : 2020-11-28 14:11:08
 */
public class Test07 {
    public static void main(String[] args) {
        ILike iLike = new Like();
        iLike.lambda();
        ILike iLike2 = new Like2();
        iLike2.lambda();

        // 4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        }
        ILike iLike3 = new Like3();
        iLike3.lambda();

        // 5.匿名内部类 没有类名 必须借助父类或者接口

        ILike iLike4 = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };
        iLike4.lambda();

        // 6.lambda简化
        ILike iLike5 = ()->{
            System.out.println("I like lambda5");
        };
        iLike5.lambda();
        /*
        * 为什么要是用lambda表达式
        * 1.避免内部类定义过多
        * 2.让代码看起来更加简洁
        * 3.去掉了一堆没有意义的代码。只留下核心逻辑
        * */

    }
    // 3.静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda2");
        }
    }
}

// 1.定义函数式接口
interface ILike{
    void lambda();
}
// 2.实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}