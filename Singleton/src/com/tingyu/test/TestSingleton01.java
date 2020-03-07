package com.tingyu.test;

import com.tingyu.singleton.Singleton01;

public class TestSingleton01 {
    public static void main(String[] args) {
        Singleton01 s1=Singleton01.INSTANCE;
        Singleton01 s2=Singleton01.INSTANCE;
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
    }
}
