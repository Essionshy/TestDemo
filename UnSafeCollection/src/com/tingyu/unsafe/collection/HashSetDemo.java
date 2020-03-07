package com.tingyu.unsafe.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> stringSet=new HashSet<>();
        stringSet.add("tingyu");
        stringSet.add("at home");
        for (String str:stringSet) {
            System.out.println(str);
        }


    }
}
