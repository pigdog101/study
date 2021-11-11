package com.mzw.java8.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @PACKAGE_NAME: com.mzw.java8.interview
 * @AUTHOR: mzw
 * @DATE: 2021/8/23
 */
class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call ----------------");
        Thread.sleep(3000);
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new MyCallable());
        Thread t1 = new Thread(futureTask,"AA");
        t1.start();
        Integer result2 = futureTask.get();

        System.out.println("main ++++++++++++++++++");
        int result1 = 1024;
        System.out.println(result1 + result2);
    }
}
