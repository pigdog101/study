package com.mzw.java8.interview;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @PACKAGE_NAME: com.mzw.java8.interview
 * @AUTHOR: mzw
 * @DATE: 2021/8/16
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 4; i++) {
            final int key = i;
            new Thread(()->{
                myCache.put(key+"",key+"");
                myCache.get(key+"");
            },String.valueOf(i)).start();
        }
    }
    @Test
    void test(){
        Integer i = 1;
        Integer.valueOf(1);
        i++;
        MyCache myCache = new MyCache();
        myCache.setCache(new HashMap<>());
    }
}

final class MyCache{
    private volatile Map<String,Object> cache = new HashMap<>();

    public Map<String, Object> getCache() {
        return cache;
    }

    public void setCache(Map<String, Object> cache) {
        this.cache = cache;
    }

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t" + "正在写入");
            cache.put(key, value);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" +"写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }

    }

    public void get(String key){
        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t" + "正在读取");
            Object o = cache.get(key);
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" +"读取完成" + o);

        }catch (Exception e){

        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}

