package com.mzw.java8.service.ServiceImpl;

import com.mzw.java8.service.Mypredate;
import com.mzw.java8.service.entity.Employee;

/**
 * @PACKAGE_NAME: com.mzw.lambda.service.ServiceImpl
 * @AUTHOR: mzw
 * @DATE: 2021/1/17
 */
public class MypredateImpl implements Mypredate<Employee> {

    @Override
    public boolean test(Employee emplyee) {
        return emplyee.getAge()>=30;
    }
}
