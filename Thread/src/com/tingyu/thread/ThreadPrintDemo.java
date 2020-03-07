package com.tingyu.thread;


class ShowData{
     public synchronized void showNumber() throws InterruptedException {
        for (int i = 1; i <= 52 ; i++) {
           // System.out.println(Thread.currentThread().getName()+"\t"+i);
            System.out.print(i);
            if(i % 2 ==0){
                this.wait();
            }
            this.notifyAll();
        }
    }
    public synchronized void showABC() throws InterruptedException {
        for (char i ='A'; i <='Z' ; i++) {
           // System.out.println(Thread.currentThread().getName()+"\t"+i);
            System.out.print(i);
            this.notifyAll();
            this.wait();
        }
    }
}

public class ThreadPrintDemo {
    public static void main(String[] args) {
        ShowData showData = new ShowData();
        new Thread(() -> {
                try {
                    showData.showNumber();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        },"AAA").start();

        new Thread(() -> {
                try {
                    showData.showABC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        },"BBB").start();
    }
}
