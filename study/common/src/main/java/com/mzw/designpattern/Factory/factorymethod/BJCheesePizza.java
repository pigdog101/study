package com.mzw.designpattern.Factory.factorymethod;


/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory
 * @AUTHOR: mzw
 * @DATE: 2021/5/14
 */
public class BJCheesePizza extends Pizza {
    @Override
    void prepare() {
        System.out.println("BJ芝士材料" + "正在准备");
    }
}
