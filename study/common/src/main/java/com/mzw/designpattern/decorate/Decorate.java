package com.mzw.designpattern.decorate;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.decorate
 * @AUTHOR: mzw
 * @DATE: 2021/5/21
 * 装饰者
 */
public class Decorate extends Drink{
    //被装饰者
    private Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        //super.getPrice() 自己（调料）的价格
        //drink.getPrice() 咖啡的价格
        return super.getPrice()+drink.cost();
    }

    @Override
    public String getDes() {
        return super.getDes() + " " + getPrice() + " " + drink.getDes() + " ";
    }
}
