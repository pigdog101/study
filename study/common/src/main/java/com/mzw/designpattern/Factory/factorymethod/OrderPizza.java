package com.mzw.designpattern.Factory.factorymethod;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory.factorymethod
 * @AUTHOR: mzw
 * @DATE: 2021/5/17
 */
public abstract class OrderPizza {
    abstract Pizza createPizza(String orderName);
    public OrderPizza(String orderName){
        Pizza pizza = createPizza(orderName);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.pack();
    }
}
