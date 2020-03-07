package com.tingyu.singleton;

/**
 * 饿汉式
 * 1、构造方法私有化
 * 2、对外提供访问接口
 */
public class Singleton01 {
    public static final Singleton01 INSTANCE=new Singleton01();
    private Singleton01(){}
}
