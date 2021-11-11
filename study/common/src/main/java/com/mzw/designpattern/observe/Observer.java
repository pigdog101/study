package com.mzw.designpattern.observe;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.observe
 * @AUTHOR: mzw
 * @DATE: 2021/6/8
 */
public interface Observer {
    void update(float temperature, float pressure, float humidity);
}
