package com.tingyu.thread;

import sun.util.resources.cldr.ka.LocaleNames_ka;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程同时读一个资源类没有
 */
class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    private Lock lock=new ReentrantLock();
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t ---写入数据");
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t ----写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        readWriteLock.writeLock().unlock();
        }

    }
    public void get(String key){
        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 读取数据");
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        readWriteLock.readLock().unlock();
        }

    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 1; i <=10 ; i++) {
            final int temp=i;
            new Thread(() -> {
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <=10 ; i++) {
            final int temp=i;
            new Thread(() -> {
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}
