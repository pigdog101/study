package com.mzw.java8.interview;

import java.util.Collections;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @PACKAGE_NAME: com.mzw.java8.interview
 * @AUTHOR: mzw
 * @DATE: 2021/8/24
 */
public class ThreadPoolExcutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(2,5,1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                final int j = i;
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t" + j);
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
