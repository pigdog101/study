package com.mzw.java8.service;

/**
 * @PACKAGE_NAME: com.mzw.lambda.service
 * @AUTHOR: mzw
 * @DATE: 2021/1/17
 */
@FunctionalInterface
public interface Mypredate<T> {
    boolean test(T t);
    default void test3(){

    };
}
