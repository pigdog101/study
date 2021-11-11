package com.mzw.java8.interview;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.*;

/**
 * @PACKAGE_NAME: com.mzw.java8.interview
 * @AUTHOR: mzw
 * @DATE: 2021/8/19
 */
public class QueueTest {
    public static void main(String[] args) {
//        List<User> users = Collections.synchronizedList(new ArrayList<User>());
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.add("d"));
        //获取队首元素
        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
    }

    @Test
    public void offerPollTest(){
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("c"));

        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

    }

    @Test
    public void putTakeTest() throws Exception {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
//        blockingQueue.put("a");

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }

    @Test
    public void offerTimeTest() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a",2l, TimeUnit.SECONDS));
    }

    @Test
    public void synQueueTest() throws InterruptedException {
        BlockingQueue<String> synBlockQueue = new SynchronousQueue();

        new Thread(()->{
            try {
                synchronized (synBlockQueue){
                    synBlockQueue.wait(10000);
                }
                System.out.println("put \t 1");
                synBlockQueue.put("1");
                System.out.println("put \t 2");
                synBlockQueue.put("2");
                System.out.println("put \t 3");
                synBlockQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            try {
                synchronized (synBlockQueue){
                    Thread.sleep(3000);
                    synBlockQueue.notifyAll();
                }
                System.out.println(synBlockQueue.take());
                Thread.sleep(1000);
                System.out.println(synBlockQueue.take());
                Thread.sleep(1000);
                System.out.println(synBlockQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){

        }

    }



}
