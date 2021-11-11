package com.mzw.designpattern.Factory;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory
 * @AUTHOR: mzw
 * @DATE: 2021/5/14
 */
public class PizzaFactory {
    public static Pizza createPizza(String eName,String cName) throws Exception {
        Class<Pizza> pizzaClass = (Class<Pizza>) Class.forName("com.mzw.designpattern.Factory." + eName);
        if (pizzaClass==null){
            return null;
        }
        Pizza pizza = pizzaClass.newInstance();
        pizza.setName(cName);
        return pizza;
    }

    public static void main(String[] args) {
        System.out.println("mzw"=="mzw");
    }
}
