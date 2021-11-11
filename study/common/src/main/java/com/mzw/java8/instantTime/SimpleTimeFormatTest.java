package com.mzw.java8.instantTime;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @PACKAGE_NAME: com.mzw.java8.instantTime
 * @AUTHOR: mzw
 * @DATE: 2021/1/22
 */
public class SimpleTimeFormatTest {

    @Test
    public void test1(){
        Callable<Date> cal = ()-> ThreaLocalDateFormat.getDateFormat("2010-01-02");
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add(pool.submit(cal));
        }
        list.forEach((x)-> {
            try {
                System.out.println(x.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }
}
