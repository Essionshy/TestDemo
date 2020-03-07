package com.tingyu.jvm;

import java.util.concurrent.TimeUnit;

/**
 * JMM Java Memory Model
 */

class MyNumber{
   // int number=10;  //如果没有加volatile 关键字，就不能保证线程间的可见性
    volatile int number=10;
    public void changeValue(){
        this.number=1024;
    }
}
public class JMMDemo {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"\t ***********Welcome to here");
                TimeUnit.SECONDS.sleep(3);
                myNumber.changeValue();
                System.out.println(Thread.currentThread().getName()+"\t update the number "+myNumber.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        },"AAA").start();
        while (myNumber.number ==10){
            //
        }
        System.out.println(Thread.currentThread().getName()+"\t game over");
    }
}
