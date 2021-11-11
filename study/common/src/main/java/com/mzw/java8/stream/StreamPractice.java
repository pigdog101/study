package com.mzw.java8.stream;

import com.mzw.java8.service.entity.Employee;
import com.mzw.java8.service.entity.Status;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @PACKAGE_NAME: com.mzw.java8.stream
 * @AUTHOR: mzw
 * @DATE: 2021/1/20
 */
public class StreamPractice {
    public List<Employee> emplyees = Arrays.asList(
            new Employee(10,"mzw",5555.55, Status.BUSY),
            new Employee(20,"mzw",6555.55,Status.FREE),
            new Employee(30,"mzw",7555.55,Status.VOCATION),
            new Employee(40,"mzw",8555.55,Status.FREE),
            new Employee(50,"mzw",9555.55,Status.BUSY)
    );

    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.stream().map((x)->x*x).forEach(System.out::println);

        //用map和reduce计算有多少个employee
        Optional<Integer> op= emplyees.stream().map((x)->1).reduce((x, y)->x+y);
        //
        System.out.println(op.get());
    }


}
