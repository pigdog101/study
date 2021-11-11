package com.mzw.java8.interview;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @PACKAGE_NAME: com.mzw.java8.interview
 * @AUTHOR: mzw
 * @DATE: 2021/8/15
 */
public class LockTest {

    public static void main(String[] args) {
//        Phone phone = new Phone();
//        new Thread(()->{
//            phone.test01();
//        },"t1").start();
//        new Thread(()->{
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            phone.test03();
//        },"t2").start();
        System.out.println(test());
        ConcurrentHashMap<Object, Object> chm = new ConcurrentHashMap<>();
        chm.put("","");
        chm.keySet();
    }
    public static String test(){
        try{
            return "try";
        }catch (Exception e){
            throw e;
        }finally {
            return "finally";
        }
    }
}

class Phone{
    public synchronized void test01(){
        System.out.println(Thread.currentThread().getName() + " say test01");
        test02();
//        if (true){
//            throw new RuntimeException();
//        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void test02(){
        System.out.println(Thread.currentThread().getName() + " say test02");
    }
    public synchronized void test03(){
        System.out.println(Thread.currentThread().getName() + " say test03");
    }
}