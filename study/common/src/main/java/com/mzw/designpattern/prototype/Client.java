package com.mzw.designpattern.prototype;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.prototype
 * @AUTHOR: mzw
 * @DATE: 2021/5/18
 */
public class Client {

    public static void main(String[] args) {
        Sheep sheep1 = new Sheep("mzw",24);
        Sheep friend = new Sheep("mzw",23);
        sheep1.setFriend(friend);
        Sheep sheep2 = (Sheep)sheep1.clone();
        Sheep sheep3 = (Sheep)sheep1.clone();
        Sheep sheep4 = (Sheep)sheep1.clone();
        Sheep sheep5 = (Sheep)sheep1.clone();
        Sheep sheep6 = (Sheep)sheep1.clone();
        System.out.println(sheep1.getFriend().hashCode());
        System.out.println(sheep2.getFriend().hashCode());
        System.out.println(sheep3.getFriend().hashCode());
    }
}
