package com.mzw.java8.interview;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PACKAGE_NAME: com.mzw.java8.interview
 * @AUTHOR: mzw
 * @DATE: 2021/8/22
 */
class ShareSource {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private Integer number = 1;
    public void print5(){
        lock.lock();
        try {
            while(number !=1){
                condition1.await();
                ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
                objectObjectConcurrentHashMap.put("","");
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 2;
            condition2.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try {
            while(number !=2){
                condition2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 3;
            condition3.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try {
            while(number !=3){
                condition3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 1;
            condition1.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
public class LockConditionTest {
    public static void main(String[] args) {
        ShareSource shareSource = new ShareSource();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareSource.print5();
            }
        },"AAA").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareSource.print10();
            }
        },"BBB").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareSource.print15();
            }
        },"CCC").start();
    }
}
