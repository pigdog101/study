package com.mzw.designpattern.Factory;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory
 * @AUTHOR: mzw
 * @DATE: 2021/5/14
 */
public class OrderPizza {
    public static void main(String[] args) {
        try {
            Pizza pizza = PizzaFactory.createPizza("GreekPizza", "希腊披萨");
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.pack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
