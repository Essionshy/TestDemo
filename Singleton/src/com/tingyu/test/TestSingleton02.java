package com.tingyu.test;

import com.tingyu.singleton.Singleton02;

public class TestSingleton02 {
    public static void main(String[] args) {
        Singleton02 s1=Singleton02.INSTANCE;
        Singleton02 s2=Singleton02.INSTANCE;
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
    }
}
