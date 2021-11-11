package com.mzw.designpattern.Factory.factorymethod;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory.factorymethod
 * @AUTHOR: mzw
 * @DATE: 2021/5/17
 */
public class BJOrderPizza extends OrderPizza {
    public BJOrderPizza(String orderName) {
        super(orderName);
    }

    @Override
    Pizza createPizza(String orderName) {
        PizzaFactory pizzaFactory = new BJPizzaFactory();
        return pizzaFactory.createPizza(orderName);
    }
}
