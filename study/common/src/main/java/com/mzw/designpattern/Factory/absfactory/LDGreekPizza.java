package com.mzw.designpattern.Factory.absfactory;


/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory
 * @AUTHOR: mzw
 * @DATE: 2021/5/14
 */
public class LDGreekPizza extends Pizza {
    @Override
    void prepare() {
        System.out.println("LD希腊材料" + "正在准备");
    }
}
