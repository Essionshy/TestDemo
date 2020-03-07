package com.tingyu.singleton;

/**
 * 懒汉式
 * 线程不安全
 */
public class Singleton04 {
    private static Singleton04 instance;
    private Singleton04(){}
    public static Singleton04 getInstance(){
        if(instance == null){
            instance=new Singleton04();
        }
        return instance;
    }
}
