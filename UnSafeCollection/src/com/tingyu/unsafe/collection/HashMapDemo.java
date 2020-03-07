package com.tingyu.unsafe.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map2 = new ConcurrentHashMap<>();
        Map<Integer,String> map=new HashMap<Integer,String>();
        Map<Integer, String> integerStringMap = Collections.synchronizedMap(new HashMap<Integer, String>());
        for (int i = 1; i <= 30 ; i++) {


            new Thread(() -> {

                integerStringMap.put((int) (Math.random()*10+1),UUID.randomUUID().toString().substring(0,8));
                System.out.println(integerStringMap);
            },String.valueOf(i)).start();
        }
    }
}
