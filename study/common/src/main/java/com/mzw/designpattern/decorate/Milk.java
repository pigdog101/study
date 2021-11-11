package com.mzw.designpattern.decorate;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.decorate
 * @AUTHOR: mzw
 * @DATE: 2021/5/21
 */
public class Milk extends Decorate {
    public Milk(Drink drink) {
        super(drink);
        setDes("牛奶");
        setPrice(4.00f);
    }
}
