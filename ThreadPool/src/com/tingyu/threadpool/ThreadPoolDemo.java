package com.tingyu.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService threadPool01= Executors.newFixedThreadPool(5);
        ExecutorService threadPool02= Executors.newSingleThreadExecutor();
        ExecutorService threadPool03= Executors.newCachedThreadPool();

        try{
            for (int i = 1; i <=10 ; i++) {
                threadPool01.execute(() ->{
                    System.out.println(Thread.currentThread().getName()+"\t  办理业务");

                });
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool01.shutdown(); //释放资源
        }


    }
}
