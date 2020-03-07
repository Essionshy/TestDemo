package com.tingyu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedData03{
    private int number=1;//1 A;2 B; 3 C
    private Lock lock=new ReentrantLock();
    private Condition condition01=lock.newCondition();
    private Condition condition02=lock.newCondition();
    private Condition condition03=lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            //1 判断
            while(number != 1){
                condition01.await();
            }
            //2 干活

            for (int i = 1; i <= 5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //3 通知
            condition02.signal();
            //4 修改标志位
            number=2;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try{
            //1 判断
            while(number != 2){
                condition02.await();
            }
            //2 干活

            for (int i = 1; i <= 10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t "+i);
            }
            //3 通知
            condition03.signal();
            //4 修改标志位
            number=3;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try{
            //1 判断
            while(number != 3){
                condition03.await();
            }
            //2 干活

            for (int i = 1; i <= 15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t "+i);
            }
            //3 通知
            condition01.signal();
            //4 修改标志位
            number=1;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class ThreadCommunication02 {
    public static void main(String [] args){
        SharedData03 sharedData03 = new SharedData03();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                sharedData03.print5();
            }

        },"A").start();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                sharedData03.print10();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                sharedData03.print15();
            }
        },"C").start();
    }
}
