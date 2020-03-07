package com.tingyu.threadpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步回调机制
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        try {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 没有返回值 update mysql successfully");
            });
            completableFuture.get();
            /*******************************************/

            CompletableFuture<Integer> completableFuture01 = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 有返回值 insert mysql successfully");
                int i=10/0;//模拟发生异常；
                return 1024;
            });
            Integer result = completableFuture01.whenComplete((t, u) -> {
                System.out.println("----t---\t" + t);
                System.out.println("----u---\t" + u);
            }).exceptionally(t -> {
                System.out.println("----Exception:" + t.getMessage());
                return 4444;
            }).get();
            System.out.println(result);//输出结果值
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
