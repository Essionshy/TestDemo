package com.tingyu.jvm;

public class JVMDemo {
    public static void main(String[] args) {
        String a=new String ("abc");
        Integer b=new Integer(5);
        System.out.println(b.getClass().getClassLoader());

        System.out.println(a.getClass().getClassLoader());
    }
}
