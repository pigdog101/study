package com.mzw.java8.interview;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @PACKAGE_NAME: com.mzw.java8.interview
 * @AUTHOR: mzw
 * @DATE: 2021/8/15
 */
public class SpinLockTest {
    AtomicReference<Thread> lock = new AtomicReference<>();
    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " come in");

        while (!lock.compareAndSet(null,thread)){

        }

    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " invoke");
        lock.compareAndSet(thread,null);
    }

    public static void main(String[] args) {
        SpinLockTest spinLockTest = new SpinLockTest();

        new Thread(()->{
            spinLockTest.lock();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockTest.unlock();
        },"AA").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            spinLockTest.lock();
            spinLockTest.unlock();
        },"BB").start();
    }
}
