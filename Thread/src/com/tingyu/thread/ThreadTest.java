package com.tingyu.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1、线程操作资源类
 * 2、高内聚、低耦合
 */


class Ticket{
    private int number=30;
    private Lock lock=new ReentrantLock();

    public void sale(){
        lock.lock();
        try{
            if (number >0){
                System.out.println(Thread.currentThread().getName()+"\t 卖出第"+(number--)+"张票\t 剩余"+number+"张票");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> { for (int i = 0; i <40 ; i++)  ticket.sale();},"AA").start();
        new Thread(() -> { for (int i = 0; i <40 ; i++)  ticket.sale();},"BB").start();
        new Thread(() -> { for (int i = 0; i <40 ; i++)  ticket.sale();},"CC").start();

        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <40 ; i++) {

                    ticket.sale();
                }
            }
        },"AAA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <40 ; i++) {

                    ticket.sale();
                }
            }
        },"BBB").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <40 ; i++) {

                    ticket.sale();
                }
            }
        },"CCC").start();
         */
    }

}
