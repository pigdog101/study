package com.mzw.java8.lambda;

/**
 * @PACKAGE_NAME: com.mzw.java8.lambda
 * @AUTHOR: mzw
 * @DATE: 2021/1/18
 */
@FunctionalInterface
public interface MyFunction<R,T> {
    public R getValue(T t1,T t2);
}
