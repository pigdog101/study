package com.mzw.java8.interview;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @PACKAGE_NAME: com.mzw.java8.interview
 * @AUTHOR: mzw
 * @DATE: 2021/8/14
 */
public class CollectionTest {
    static volatile ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        /**
         * 构建一个线程安全的list
         */
//        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        ConcurrentModifiedExceptionTest();
    }

    private static void ConcurrentModifiedExceptionTest() {
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                strings.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(strings);
            },String.valueOf(i)).start();
        }
    }

    /**
     * arrayList 线程安全问题 写时复制CopyOnWriteArrayList
     */
    @Test
    public void CopyOnWriteArrayListTest(){
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("");
    }

    /**
     * hashSet并发修改异常
     * Collections的synSet
     * juc.写时复制set
     */
    @Test
    public void setTest(){
        new HashSet<>().add("");
    }
}
