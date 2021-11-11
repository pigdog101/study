package com.mzw.java8.stream;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @PACKAGE_NAME: com.mzw.java8.stream
 * @AUTHOR: mzw
 * @DATE: 2021/1/21
 *
 * ForkJoin 任务拆分处理 work-stealing 工作窃取模式 更加高效的利用cpu
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {
    private static final long serialVersionUID = 1L;
    private Long start;
    private Long end;

    private final Long FLAG = 10000L;

    public ForkJoinCalculate(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    public ForkJoinCalculate() {
    }

    @Override
    protected Long compute() {
        if(start - end<=FLAG){
            Long sum = 0l;
            for (long i = start; i <= end ; i++) {
                sum+=i;
            }
            return sum;
        }else{
            Long middle = (start+end)/2;
            ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
            left.fork();
            ForkJoinCalculate right = new ForkJoinCalculate(middle,end);
            right.fork();
            return left.join()+right.join();
        }
    }
}

class ForkJoinTest{

    /**
     * ForkJoin 框架 耗时
     */
    @Test
    public void test1(){
        Instant start = Instant.now();
        ForkJoinTask<Long> fjc = new ForkJoinCalculate(0l,100000000l);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long result = forkJoinPool.invoke(fjc);
        Instant end = Instant.now();
        System.out.println("耗费时间为"+ Duration.between(start,end).toMillis());
    }

    /**
     * 使用并行流处理
     */
    @Test
    public void test3(){
        Instant start = Instant.now();
        Long sum = LongStream.rangeClosed(0,100000000).parallel().reduce(0,Long::sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为"+ Duration.between(start,end).toMillis());
    }
}
