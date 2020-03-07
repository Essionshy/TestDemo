package com.tingyu.singleton;

/**
 * 单例 懒汉式
 * 多线程安全
 */
public class Singleton05 {
    private static Singleton05 instance;
    private Singleton05(){}
    public static Singleton05 getInstance(){
        if(instance == null){
            synchronized (Singleton05.class){
                if(instance == null){
                    instance=new Singleton05();
                }
            }
        }
        return instance;
    }
}
