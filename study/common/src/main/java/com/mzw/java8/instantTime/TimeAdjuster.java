package com.mzw.java8.instantTime;

import java.text.DateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @PACKAGE_NAME: com.mzw.java8.instantTime
 * @AUTHOR: mzw
 * @DATE: 2021/8/18
 */
class TimeAdjuster {
    public static void main(String[] args) {
        //temporalAdjuster
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime localDateTime = now.withDayOfMonth(10);
        System.out.println(localDateTime);

        //TemporalAdjusters
        LocalDateTime nextSunday = now.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(nextSunday);

        //自定义TemporalAdjuster 下一个工作日
        LocalDateTime nextWorkDay = now.with((temporal) -> {
            LocalDateTime l = (LocalDateTime)temporal;
            if (l.getDayOfWeek().equals(DayOfWeek.FRIDAY)){
                return l.plusDays(3);
            }else if(l.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
                return l.plusDays(2);
            }else {
                return l.plusDays(1);
            }
        });
//        System.out.println(nextWorkDay);
//
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
//        System.out.println(LocalDateTime.now().format(dateTimeFormatter));
//
//        MonthDay monthDay = MonthDay.of(8,1);
//        System.out.println(monthDay.isBefore(MonthDay.now()));
    }


}
