package com.mzw.designpattern.Factory.factorymethod;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.Factory
 * @AUTHOR: mzw
 * @DATE: 2021/5/14
 */
public abstract class PizzaFactory {
   abstract Pizza createPizza(String name);
}
