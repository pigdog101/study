package com.mzw.designpattern.Factory.absfactory;


/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory.factorymethod
 * @AUTHOR: mzw
 * @DATE: 2021/5/17
 */
public class LDPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza(String name) {
        if (name.equals("greek")){
            return new LDGreekPizza();
        }else if (name.equals("cheese")){
            return new LDCheesePizza();
        }
        return null;
    }
}
