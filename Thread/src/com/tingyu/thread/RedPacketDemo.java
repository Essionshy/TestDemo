package com.tingyu.thread;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class RedPacket{
    private int count;//红包个数
    private int amount;//红包金额
    private int sum; //随机红包已经被抢的总金额
    private int generalAmount;//普通红包金额
    private Lock lock=new ReentrantLock();

    public RedPacket() {
    }

    public RedPacket(int count, int amount) {
        this.count = count;
        this.amount = amount;

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getGeneralAmount() {
        return generalAmount;
    }

    public void setGeneralAmount(int generalAmount) {
        this.generalAmount = generalAmount;
    }

    /**
     * 随机红包
     * @return
     */
    public int getRedPacket(){
        int redPacketAmount=0; //抢到的单个红包金额
        //lock.lock();
        try{
            if(count<=0){
                System.out.println(Thread.currentThread().getName()+"\t红包已经抢完");
            }else if(count ==1){
                redPacketAmount=amount-sum;
                System.out.println(Thread.currentThread().getName()+"最后一个抢到红包");
            }
            else {
               // System.out.println(Thread.currentThread().getName()+"\t"+count);
                redPacketAmount=new Random().nextInt((amount-sum)/2);
                sum=sum+redPacketAmount;
            }
            count--;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
        //    lock.unlock();
        }
        return redPacketAmount;
    }
    public int getGeneralRedPacket(){
        int result=-1;

        lock.lock();
        try{
            if(count <=0){
                System.out.println(Thread.currentThread().getName()+"\t红包已经抢完"+new Date());
            }else{

                result=generalAmount;
            }
            TimeUnit.SECONDS.sleep(2L);
            count --;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        return result;
    }
}

public class RedPacketDemo {
    public static void main(String[] args) {
        RedPacket redPacket = new RedPacket(5, 100*100); //金额单位 分
        /*for (int i = 1; i <=8 ; i++) {
            new Thread(() -> {
                double result=redPacket.getRedPacket();
                if(result !=0){
                    System.out.println(Thread.currentThread().getName()+"\t 抢到了"+result/100);
                }
            },String.valueOf(i)).start();
        }*/
        System.out.println("===============================");
        RedPacket redPacket1 = new RedPacket();
        redPacket1.setCount(5);
        redPacket1.setGeneralAmount(20*100);
        for (int i = 1; i <=10 ; i++) {
            new Thread(() -> {
                double result=redPacket1.getGeneralRedPacket();
                if(result != -1){
                    System.out.println(Thread.currentThread().getName()+"\t 抢到了"+result/100 +"\t"+new Date());
                }

            },String.valueOf(i)).start();
        }
    }
}
