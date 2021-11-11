package com.mzw.designpattern.decorate;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.decorate
 * @AUTHOR: mzw
 * @DATE: 2021/5/21
 */
public class Espresso extends Coffee {
    public Espresso(){
        super.setDes("意大利咖啡");
        super.setPrice(1.00f);
    }
}
