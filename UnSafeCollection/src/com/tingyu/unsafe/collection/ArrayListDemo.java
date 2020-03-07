package com.tingyu.unsafe.collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        /**
        List<String> list=Arrays.asList("a","b","c");
        list.forEach(System.out::println);
        List<String> objects = Collections.synchronizedList(new ArrayList<>());
        */

       // List<String> list =new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 30 ; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
