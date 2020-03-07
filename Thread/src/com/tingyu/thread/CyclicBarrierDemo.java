package com.tingyu.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * 集齐七颗龙珠，召唤神龙
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> { System.out.println(Thread.currentThread().getName()+"\t 全员到齐，开始开会");
        });
        for (int i = 1; i <=7 ; i++) {
            final int tempInt=i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 第"+tempInt+"号员工到位");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
