package com.tingyu.thread;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
       BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<String>(3);
       /*
       *  add()  向队列中添加元素,返回值为true或false ，队满时会抛出异常 java.lang.IllegalStateException: Queue full
       *
       * */
       /* System.out.println(blockingQueue.add("A"));
        System.out.println(blockingQueue.add("B"));*/
       // System.out.println(blockingQueue.add("C"));
        //System.out.println(blockingQueue.add("D"));//测试队满时的情况

        /*
        * remove() 从队列中获取元素,返回值为被移出的对象,队空时会抛出异常 java.util.NoSuchElementException
        * */


      /*System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/

      /*
      * element() 检查队列中是否有元素并返回队首元素的值，如果队列为空，则抛出异常 java.util.NoSuchElementException
      *
      * */

       // System.out.println(blockingQueue.element());
    /*
    *  offer()  向队列中添加元素，队列满时，返回false而非抛出异常
    * */
        //System.out.println(blockingQueue.offer("A"));
    /*
    *  poll() 从队列中获取元素，并返回该元素的值；当队空时，返回null
    * */
       /*System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        */

     /*
     * peek()  检查队列，如果队列为空时，返回null
     *
     * */
    // System.out.println(blockingQueue.peek());

     /*
     * put 阻塞   不见不散
     *
     * */
     blockingQueue.put("CC");
     blockingQueue.put("DD");
     blockingQueue.put("EE");
     blockingQueue.put("FF");

     //blockingQueue.take();
     //blockingQueue.take();
     //blockingQueue.take();
        /*
        * 超时   过时不候
        * */
        System.out.println(blockingQueue.offer("GG", 3L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(4L, TimeUnit.SECONDS));

    }
}
