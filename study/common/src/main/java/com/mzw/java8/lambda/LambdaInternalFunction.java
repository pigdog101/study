package com.mzw.java8.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @PACKAGE_NAME: com.mzw.java8.lambda
 * @AUTHOR: mzw
 * @DATE: 2021/1/18
 * lambda内置函数式接口 测试
 *
 * 1.Consumer<T> : 消费型接口
 *     void accept(T t);
 *
 * 2.Supplier<T> : 供给型接口
 *     T get();
 *
 * 3.Function<T,R> : 函数型接口
 *     R apply(T t);
 *
 * 4.Predicate<T> : 断言型接口
 *     boolean test(T t);
 */
public class LambdaInternalFunction {

    @Test
    public void test1(){
        consume((m)-> System.out.println("消费"+m+"元"),10000);
    }
    public void consume(Consumer<Double> con,double money){
        con.accept(money);
    }

    @Test
    public void test2(){
        getInteger(()->(int)(Math.random()*100),10);
    }

    public List<Integer> getInteger(Supplier<Integer> sup,int num){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }
}
