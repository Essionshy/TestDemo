package com.tingyu.thread;

/**
 * 题目：初始变量为0，一个线程加1，一个线程减1，重复打印10轮
 *
 * 为了避免虚假唤醒，判断用while，而不用if
 */

class SharedData{
    private int number=0;
    public synchronized  void increment() throws InterruptedException {
        //1.判断
        while(number != 0){
            this.wait();
        }
        //2.干活
        ++number;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3.唤醒通知
        this.notifyAll();
    }
    public synchronized  void decrement() throws InterruptedException {
        //1.判断
        while(number == 0){
            this.wait();
        }
        //2.干活
        --number;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3.唤醒通知
        this.notifyAll();
    }
}
public class ThreadCommunication {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                try {
                    sharedData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(() -> {

            for (int i = 1; i <=10 ; i++) {
                try {
                    sharedData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                try {
                    sharedData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();
        new Thread(() -> {

            for (int i = 1; i <=10 ; i++) {
                try {
                    sharedData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}
