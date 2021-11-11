package com.mzw.java8.interview;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @PACKAGE_NAME: com.mzw.java8.interview
 * @AUTHOR: mzw
 * @DATE: 2021/8/7
 * volatile 保证可见性和有序性，但不保证原子性
 */
public class VolatileTest {
    public static void main(String[] args) {
        MyData myData = new MyData();

        Thread thread = new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println("工作内存写入到主存");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+"complete and value = "+myData.num);
        },"AAA");
        thread.start();
        while (myData.num == 0){

        }
        System.out.println("main complete and value = " + myData.num);
    }
    //volatile不保证原子性

    /**
     * 如何解决volatile不保证原子性的问题
     * 1.sync
     * 2.juc包下的AtomicInteger
     */
    @Test void volatileAotomicTest(){
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(
                        ()->{
                        for (int j = 0; j <1000 ; j++) {
                            myData.addPlus();
                            myData.myAtomicAdd();
                        }
                    },"AAA"
            ).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println("finally value"+ myData.num);
        System.out.println("finally value"+ myData.atomicInteger);
    }

    @Test
    public void intTest(){
        Integer a = 127;
        Integer b = 127;
        Integer.valueOf(127);
        System.out.println(a==b);
    }
}

class MyData{
    int num = 0;
    public void addTo60(){
        this.num = 60;
    }
    public void addPlus(){
        this.num++;
    }
    AtomicInteger atomicInteger = new AtomicInteger();
    public void myAtomicAdd(){
        atomicInteger.getAndAdd(1);
    }
}