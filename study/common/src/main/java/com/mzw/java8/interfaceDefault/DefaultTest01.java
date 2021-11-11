package com.mzw.java8.interfaceDefault;

import org.junit.jupiter.api.Test;

/**
 * @PACKAGE_NAME: com.mzw.java8.interfaceDefault
 * @AUTHOR: mzw
 * @DATE: 2021/1/22
 */
public class DefaultTest01 extends DefaultClass implements DefaultInterface01 {
    //场景1：继承class和实现的interface 方法重写冲突
    @Test
    public void test01(){
        new DefaultTest01().getName();
    }
}
