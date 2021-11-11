package com.mzw.java8.instantTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @PACKAGE_NAME: com.mzw.java8.instantTime
 * @AUTHOR: mzw
 * @DATE: 2021/1/22
 */
public class ThreaLocalDateFormat {
    protected final static ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
        protected DateFormat initialValue(){
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    public static Date getDateFormat(String str) throws ParseException {
        return df.get().parse(str);
    }
}
