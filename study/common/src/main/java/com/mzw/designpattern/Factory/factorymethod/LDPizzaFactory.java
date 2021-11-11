package com.mzw.designpattern.Factory.factorymethod;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory.factorymethod
 * @AUTHOR: mzw
 * @DATE: 2021/5/17
 */
public class LDPizzaFactory extends PizzaFactory {
    @Override
    Pizza createPizza(String name) {
        if (name.equals("greek")){
            return new LDGreekPizza();
        }else if (name.equals("cheese")){
            return new LDCheesePizza();
        }
        return null;
    }
}
