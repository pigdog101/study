package com.mzw.java8.stream;

import com.mzw.java8.service.entity.Employee;
import com.mzw.java8.service.entity.Status;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @PACKAGE_NAME: com.mzw.java8.stream
 * @AUTHOR: mzw
 * @DATE: 2021/1/20
 *
 * Stream终止操作
 */
public class StreamTest02 {

    public List<Employee> emplyees = Arrays.asList(
            new Employee(10,"mzw",8555.55,Status.FREE),
            new Employee(20,"mzw",7555.55,Status.VOCATION),
            new Employee(20,"mzw",6555.55,Status.FREE),
            new Employee(40,"mzw",5555.55,Status.BUSY),
            new Employee(50,"mzw",9555.55,Status.BUSY)
    );

    /**
     * 1.查找与匹配
     * allMatch-检查是否匹配所有元素
     * anyMatch-检查是否至少匹配一个元素
     * noneMatch-检查是否没有匹配所有元素
     * findFirst-返回第一个元素
     * findAny-返回当前流中的任意元素
     * count-返回流中元素的个数
     * max-返回流中元素的最大值
     * min返回流中元素的最小值
     */
    @Test
    public void test1(){
        //allMatch-检查是否匹配所有元素
        System.out.println(emplyees.stream().anyMatch((x)->x.getStatus().equals(Status.BUSY)));
        //findFirst-返回第一个元素
        Optional<Employee> op = emplyees.stream().sorted((x, y)->Double.compare(x.getSalary(),y.getSalary())).findFirst();
        System.out.println(op.get());

        //findAny-返回当前流中的任意元素
        Optional<Employee> op1 = emplyees.stream().filter((e)->e.getStatus().equals(Status.FREE))
                .findAny();
        System.out.println(op1.get());
    }

    /**
     * 2.归约
     * identity 起始值 ,BinaryOperator<T,T,T> BiFunction<T,T,R>的子接口
     * reduce(T identity , BinaryOperator) / reduce(BinaryOperator)-
     * 可以将流中的某个反复结合起来得到一个值
     */
    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //
        Optional<Integer> op = list.stream().reduce((x, y)-> x + y);
        System.out.println(op.get());

        Optional<Double> op1 = emplyees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(op1.get());
    }

    /**
     * 收集
     * collect：将流转化为其他形式。接收一个Collector接口的实现
     * 用于给Stream中的元素做汇总的方法
     */
    @Test
    public void test3(){
        //一般类型的集合
        List<String> strList =  emplyees.stream().map(Employee::getName).collect(Collectors.toList());
        //特殊类型的集合
        HashSet<String> strSet = emplyees.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        //总数
        Long count = emplyees.stream().collect(Collectors.counting());
        //平均值
        Double avg = emplyees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        //总合
        Double sum = emplyees.stream().collect(Collectors.summingDouble(Employee::getSalary));

        //最大工资的个人
        Optional<Employee> op3 = emplyees.stream().max((x,y)->Double.compare(x.getSalary(),y.getSalary()));
        System.out.println(op3.get());
        //最大工资的个人
        Optional<Employee> op4 = emplyees.stream().collect(Collectors.maxBy((x,y)->Double.compare(x.getSalary(),y.getSalary())));
        System.out.println(op4.get());

        //根据Status进行分组
        Map<Integer,List<Employee>> map0 = emplyees.stream().collect(Collectors.groupingBy(Employee::getAge,
                LinkedHashMap::new,Collectors.toList()));
        System.out.println(map0);
        //根据Status进行分组
        Map<Status,List<Employee>> map = emplyees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);

        //多级分组，先按status分再按年龄分
        Map<Status,Map<String,List<Employee>>> map1 = emplyees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,Collectors.groupingBy((x)->{
                    if (x.getAge()<=20){
                        return "青年";
                    }else{
                        return "壮年";
                    }
                })));

        System.out.println(map1);

        //根据age进行分组/分组完成后根据age进行排序
        Map<Integer,List<Employee>> map3 = emplyees.stream().collect(Collectors.groupingBy(Employee::getAge,
                LinkedHashMap::new,Collectors.toList()));
        System.out.println(map3);

        //分区
        Map<Boolean,List<Employee>>map2 = emplyees.stream().collect(Collectors.partitioningBy((x)->x.getSalary()>5000));


    }
    @Test
    public void test4(){
        //根据age进行分组/分组完成后根据age进行排序
        Map<Integer,List<Employee>> map3 = emplyees.stream().collect(Collectors.groupingBy(Employee::getAge,
                LinkedHashMap::new,Collectors.toList()));
        System.out.println(map3);
    }
}
