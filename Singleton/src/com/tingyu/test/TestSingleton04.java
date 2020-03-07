package com.tingyu.test;

import com.tingyu.singleton.Singleton04;

import java.util.concurrent.*;

public class TestSingleton04 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

       /* Singleton04 s1=Singleton04.getInstance();
        Singleton04 s2=Singleton04.getInstance();
        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);*/

       Callable<Singleton04> callable1=new Callable<Singleton04>() {
           @Override
           public Singleton04 call() throws Exception {
               System.out.println("----------------");
               return Singleton04.getInstance();
           }
       };
        Callable<Singleton04> callable2=new Callable<Singleton04>() {
            @Override
            public Singleton04 call() throws Exception {
                System.out.println("----------------");
                return Singleton04.getInstance();
            }
        };
       FutureTask<Singleton04> futureTask=new FutureTask<>(callable1);
       FutureTask<Singleton04> futureTask2=new FutureTask<>(callable2);



        ExecutorService threadPool= Executors.newFixedThreadPool(5);
        threadPool.execute(futureTask);
        threadPool.execute(futureTask2);

        System.out.println(futureTask.get() == futureTask2.get());

        threadPool.shutdown();

    }
}
