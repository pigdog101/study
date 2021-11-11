package com.mzw.designpattern.decorate;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.decorate
 * @AUTHOR: mzw
 * @DATE: 2021/5/21
 */
public class Chocolate extends Decorate {
    public Chocolate(Drink drink) {
        super(drink);
        setDes("巧克力");
        setPrice(3.00f);
    }


}
