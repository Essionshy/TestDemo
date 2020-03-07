package com.tingyu.test;

import com.tingyu.singleton.Singleton03;

public class TestSingleton03 {
    public static void main(String[] args) {
        Singleton03 s1=Singleton03.instance;
        Singleton03 s2=Singleton03.instance;
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
    }
}
