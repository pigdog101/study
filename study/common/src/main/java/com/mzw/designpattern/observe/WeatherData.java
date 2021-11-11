package com.mzw.designpattern.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.observe
 * @AUTHOR: mzw
 * @DATE: 2021/6/8
 */
public class WeatherData implements Subject {
    private List<Observer> observers = new ArrayList<>();
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {

    }
}
