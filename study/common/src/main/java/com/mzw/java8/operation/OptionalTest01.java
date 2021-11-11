package com.mzw.java8.operation;

import com.mzw.java8.service.entity.Employee;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @PACKAGE_NAME: com.mzw.java8.operation
 * @AUTHOR: mzw
 * @DATE: 2021/1/21
 */
public class OptionalTest01 {
    @Test
    //Optional容器
    public void test1(){
        //创建一个Optional实例
        Optional<Employee> op = Optional.of(new Employee());
    }

    @Test
    public void test2(){

    }
}
