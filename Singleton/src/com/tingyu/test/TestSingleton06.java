package com.tingyu.test;

import com.tingyu.singleton.Singleton06;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestSingleton06 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        
        Singleton06 s1=Singleton06.getInstance();
        Singleton06 s2=Singleton06.getInstance();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);
       
    }
}
