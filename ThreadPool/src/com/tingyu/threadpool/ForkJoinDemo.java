package com.tingyu.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分支合并
 */
class MyTask extends RecursiveTask<Integer> {
    private static final int ADJUST_VALUE=10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end-begin<=10){
            for (int i = begin; i <=end ; i++) {
                result=result+i;
            }
        }else{
            int mid=(begin+end)/2;
            MyTask task01=new MyTask(begin,mid);
            MyTask task02=new MyTask(mid+1,end);
            task01.fork();
            task02.fork();
            result=task01.join()+task02.join();
        }
        return result;
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) {
        MyTask myTask = new MyTask(1, 10);
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        try {
            //submit() 方法提交任务
            ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);
            //类似FutureTask 的get()方法获取返回值
            System.out.println(forkJoinTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            //释放线程池资源
            forkJoinPool.shutdown();
        }
    }
}
