package com.tingyu.singleton;

/**
 * 懒汉式  静态内部类的方式
 * 内部类初始化时创建实例对象
 *
 */
public class Singleton06 {

    private Singleton06(){}

    static class Inner{
        static final Singleton06 instance =new Singleton06();
    }

    public static Singleton06 getInstance(){
        return Inner.instance;
    }
}
