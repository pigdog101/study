package com.mzw.designpattern.Factory;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory
 * @AUTHOR: mzw
 * @DATE: 2021/5/14
 */
public class GreekPizza extends Pizza {
    @Override
    void prepare() {
        System.out.println("希腊材料" + "正在准备");
    }
}
