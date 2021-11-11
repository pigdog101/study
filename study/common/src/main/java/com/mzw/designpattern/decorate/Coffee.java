package com.mzw.designpattern.decorate;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.decorate
 * @AUTHOR: mzw
 * @DATE: 2021/5/21
 */
public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
