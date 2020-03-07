package com.tingyu.demo.lock;


import java.util.concurrent.TimeUnit;

/**
 * 线程8锁问题探究
 * 1、标准访问，请问打印顺序 IOS ---Android
 * 2、先睡4秒钟，打印顺序是怎样？ IOS -- Android
 * 3、新增一个普通hello方法，请问打印IOS还是hello？ hello --- IOS --- Android
 * 4、有两部手机，请问先打印IOS还是Android？ Android --- IOS
 * 5、两个静态同步方法，有1部手机，请问先打印IOS还是Android？IOS ---Android
 * 6、两个静态同步方法，有2部手机，请问先打印IOS还是Android? IOS --- Android
 * 7、1个静态同步方法，1个普通同步方法，有1部手机，请问是先打印IOS还是Android？  Android --- IOS
 * 8、1个静态同步方法，1个普通同步方法，有2部手机，请问是先打印IOS还是Android？  Android --- IOS
 *
 * 结论：
 * 1、普通同步方法锁的是当前对象
 * 2、静态同步方法锁的是class文件
 */


class Phone{

    public static synchronized void getIOS()throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println( Thread.currentThread().getName()+"\t -----IOS------");
    }
    public  synchronized void getAndroid() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t -----Android------");
    }
    public void hello(){
        System.out.println(Thread.currentThread().getName()+"\t ----------Hello-----");
    }
}
public class ThreadLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        //接口可以直接new ,匿名内部类的方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    phone.getIOS();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        },"A").start();
        //Lambda表达式  口诀：复制小括号，写死右箭头，落地大括号
        new Thread(() -> {
            try {
              //  phone.getAndroid();
                phone2.getAndroid();
            }catch (Exception e){
                e.printStackTrace();
            }

        },"B").start();


    }
}
