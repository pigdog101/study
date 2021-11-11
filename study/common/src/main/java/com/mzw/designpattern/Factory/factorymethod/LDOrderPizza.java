package com.mzw.designpattern.Factory.factorymethod;


/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory.factorymethod
 * @AUTHOR: mzw
 * @DATE: 2021/5/17
 */
public class LDOrderPizza extends OrderPizza {
    public LDOrderPizza(String orderName) {
        super(orderName);
    }

    @Override
    Pizza createPizza(String orderName) {
        PizzaFactory pizzaFactory = new LDPizzaFactory();
        return pizzaFactory.createPizza(orderName);
    }
}
