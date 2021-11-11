package com.mzw.designpattern.decorate;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.decorate
 * @AUTHOR: mzw
 * @DATE: 2021/5/21
 */
public class Order {
    public static void main(String[] args) {
        //点一个单品咖啡
        Drink order = new ShortBlack();
        System.out.println("费用 " + order.getPrice() + " 描述 " + order.getDes());
        order = new Milk(order);
        System.out.println("加了一份牛奶后的价格" + order.cost() + " 描述 " + order.getDes());

        order = new Chocolate(order);
        System.out.println("加了一份牛奶 又加了一个巧克力后的价格" + order.cost() + " 描述 " + order.getDes());


    }
}
