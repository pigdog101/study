package com.mzw.designpattern.Proxy;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.Proxy
 * @AUTHOR: mzw
 * @DATE: 2021/6/2
 */
public class TeacherDaoImpl implements TeacherDao {
    @Override
    public void teach() {
        System.out.println("教师执教中");
    }
}
