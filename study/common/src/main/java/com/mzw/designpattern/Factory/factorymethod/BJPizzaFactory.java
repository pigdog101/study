package com.mzw.designpattern.Factory.factorymethod;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory.factorymethod
 * @AUTHOR: mzw
 * @DATE: 2021/5/17
 */
public class BJPizzaFactory extends PizzaFactory {
    @Override
    Pizza createPizza(String name) {
        if (name.equals("greek")){
            return new BJGreekPizza();
        }else if (name.equals("cheese")){
            return new BJCheesePizza();
        }
        return null;
    }
}
