package com.mzw.designpattern.bridge;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.bridge
 * @AUTHOR: mzw
 * @DATE: 2021/5/20
 */
public abstract class Phone {
    private Brand brand;

    public Phone(Brand brand) {
        this.brand = brand;
    }

    public void open(){
        brand.open();
    }
    public void call(){
        brand.call();
    }
}
