package com.mzw.java8.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PACKAGE_NAME: com.mzw.java8.interview
 * @AUTHOR: mzw
 * @DATE: 2021/8/22
 */
class ShareData{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private Integer number = 0;
    public void increment(){
        lock.lock();
        try {
            //试用while被唤醒之后会重新执行while的判断条件(if则会继续执行不判断) 防止虚拟唤醒
            while (number!=0){
                System.out.println(Thread.currentThread().getName() + "\t" + "被等待");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            number++;
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement(){
        lock.lock();
        try {
            while (number==0){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            number--;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class IndecrementTest {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
//        new Thread(()->{
//            for (int i = 0; i < 5; i++) {
//                shareData.increment();
//            }
//        },"AAA").start();
//
//        new Thread(()->{
//            for (int i = 0; i < 5; i++) {
//                shareData.decrement();
//            }
//        },"BBB").start();
//
//        new Thread(()->{
//            for (int i = 0; i < 5; i++) {
//                shareData.increment();
//            }
//        },"CCC").start();
//
//        new Thread(()->{
//            for (int i = 0; i < 5; i++) {
//                shareData.decrement();
//            }
//        },"DDD").start();

        for (int i = 0; i < 5; i++) {
            final int j = i;
            new Thread(()->{
                shareData.increment();
            },j + "生").start();
        }

        for (int i = 0; i < 5; i++) {
            final int j = i;
            new Thread(()->{
                shareData.decrement();
            },j + "消").start();
        }
    }
}


