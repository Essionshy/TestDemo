package com.tingyu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedData04{
    private int number=1;//1 A;2 B; 3 C
    private Lock lock=new ReentrantLock();
    private Condition condition01=lock.newCondition();
    private Condition condition02=lock.newCondition();
    private Condition condition03=lock.newCondition();

    public void print(int count){
        lock.lock();
        try{
            switch (count){
                case 5:
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
                    break;
                case 10:
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
                    break;
                case 15:
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
                    break;
                default:
                    for (int i = 1; i <= count ; i++) {
                        System.out.println(Thread.currentThread().getName()+"\t "+i);
                    }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}

public class ThreadCommunication03 {
    public static void main(String [] args){
        SharedData04 sharedData = new SharedData04();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                sharedData.print(5);
            }

        },"A").start();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                sharedData.print(10);
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++) {
                sharedData.print(15);
            }
        },"C").start();
    }
}
