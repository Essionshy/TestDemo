package com.tingyu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedData02{
    private int number=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public  void increment() throws InterruptedException {
        lock.lock();
        try{
            //1.判断
            while(number != 0){
                condition.await();
            }
            //2.干活
            ++number;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3.唤醒通知
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void decrement() throws InterruptedException {
        lock.lock();
        try{
            //1.判断
            while(number == 0){
                condition.await();
            }
            //2.干活
            --number;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3.唤醒通知
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class ThreadCommunicationByLock {
    public static void main(String[] args) {
        SharedData02 sharedData = new SharedData02();
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
