package com.tingyu.jvm;


class SequenceDemo{
    public SequenceDemo(){
        System.out.println("SequenceDemo Constructor 11111");
    }
    {
        System.out.println("SequenceDemo Constructor 22222");
    }
    static {
        System.out.println("SequenceDemo Constructor 333333");
    }
}
public class ClassLoadSequenceDemo {
    public ClassLoadSequenceDemo(){
        System.out.println("ClassLoadSequenceDemo Constructor 4444444");
    }
    {
        System.out.println("ClassLoadSequenceDemo Constructor 666666");
    }
    static {
        System.out.println("ClassLoadSequenceDemo Constructor 777777");
    }
    public static void main(String[] args) {
        System.out.println("ClassLoadSequenceDemo Constructor 55555");
        new SequenceDemo();
        System.out.println("===================");
        new SequenceDemo();
        System.out.println("===================");
        new ClassLoadSequenceDemo();
    }
}
