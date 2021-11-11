package com.mzw.designpattern.observe;

import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;

/**
 * @PACKAGE_NAME: com.mzw.designpattern.observe
 * @AUTHOR: mzw
 * @DATE: 2021/6/8
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
