package com.mzw.designpattern.Factory.factorymethod;


/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory
 * @AUTHOR: mzw
 * @DATE: 2021/5/14
 */
public class LDCheesePizza extends Pizza {
    @Override
    void prepare() {
        System.out.println("LD芝士材料" + "正在准备");
    }
}
