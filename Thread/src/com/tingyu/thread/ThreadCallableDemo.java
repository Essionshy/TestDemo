package com.tingyu.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t----Create thread by implements callable interface------");
        return 1024;
    }
}
/**
 * 创建线程的第三方式  实现Callable 接口
 */
public class ThreadCallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask01=new FutureTask<>(new MyThread());
        new Thread(futureTask01,"AA").start();
        FutureTask<Integer> futureTask02=new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName()+"\t ---Callable Interface");
                //线程睡眠4秒钟
                TimeUnit.SECONDS.sleep(4);
                return 1000;
            }
        });
        new Thread(futureTask02,"BB").start();
        new Thread(futureTask02,"CC").start();
        FutureTask<Integer> futureTask03=new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+"\t -----Lambda Callable interface");
            return 10000;
        });
        new Thread(futureTask03,"DD").start();
        System.out.println(Thread.currentThread().getName()+"\t main线程计算完成！！！！");
        System.out.println(futureTask01.get());
        Integer sum=futureTask01.get()+futureTask02.get()+futureTask03.get();
        System.out.println(sum);
    }
}
