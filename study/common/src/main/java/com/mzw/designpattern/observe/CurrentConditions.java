package com.mzw.designpattern.observe;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.observe
 * @AUTHOR: mzw
 * @DATE: 2021/6/8
 */
public class CurrentConditions implements Observer{
    private float temperature;
    private float pressure;
    private float humidity;

    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void dispaly(){

    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
