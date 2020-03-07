package com.tingyu.threadpool;

import java.util.concurrent.*;

public class CustomThreadPoolDemo {
    //private static final int MAX_THREAD_SIZE=Runtime.getRuntime().availableProcessors();
    //自定义线程池，最大线程数根据 CPU核心数+1
    public static void main(String[] args) {
        ExecutorService threadPool=new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try{

            threadPool.execute(() ->{
                for (int i = 1; i <=100 ; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t  办理业务");
                }

            });

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }




}
