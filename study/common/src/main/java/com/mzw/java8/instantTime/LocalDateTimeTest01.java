package com.mzw.java8.instantTime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @PACKAGE_NAME: com.mzw.java8.instantTime
 * @AUTHOR: mzw
 * @DATE: 2021/1/22
 */
public class LocalDateTimeTest01 {

    @Test
    public void test1(){
        //1.LocalDate  LocalTime  LocalDateTime
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime ldt2 = LocalDateTime.of(2020,10,10,10,10,10);
        System.out.println(ldt2);

        //加时间(年)
        LocalDateTime ldt3 = ldt.plusYears(2);
        System.out.println(ldt3);
        //减时间
        LocalDateTime ldt4 = ldt.minusMonths(10);
        System.out.println(ldt4);
        //获取年月日时分秒
        System.out.println(ldt4.getDayOfMonth());
        System.out.println(ldt4.getHour());
        System.out.println(ldt4.getMinute());
        System.out.println(ldt4.getSecond());
    }

    /**
     * Instant:时间戳 以unix元年1970.01.01起始至今的毫秒值
     */
    @Test
    public void test2(){
        Instant ins1 = Instant.now();//默认UTC时区
        System.out.println(ins1);
        OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

    }

    /**
     * Duration : 计算两个时间之间的间隔
     * Period : 计算两个日期之间的间隔
     */
    @Test
    public void test3() throws InterruptedException {
        Instant ins1 = Instant.now();
        Thread.sleep(1000);
        Instant ins2 = Instant.now();
        Duration duration = Duration.between(ins1,ins2);
        System.out.println(duration.toMillis());

        LocalTime lt = LocalTime.now();
        LocalTime lt1 = lt.plusMinutes(10);
        Duration duration1 = Duration.between(lt,lt1);
        System.out.println(duration1.toMillis());

        LocalDate ld1 = LocalDate.of(2015,01,02);
        LocalDate ld2 = ld1.plusDays(10);
        Period period = Period.between(ld1,ld2);
    }
    /**
     * TemporalAdjuster
     */
    @Test
    public void test4(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);
        ldt.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime ldt4 = ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        //自定义下个工作日
        LocalDateTime ldt6 = ldt.with((l)->{
            LocalDateTime ldt5 = (LocalDateTime) l;
            DayOfWeek dayOfWeek = ldt5.getDayOfWeek();
            if (DayOfWeek.FRIDAY.equals(dayOfWeek)){
                return ldt5.plusDays(3);
            }else if(DayOfWeek.SATURDAY.equals(dayOfWeek)){
                return ldt5.plusDays(2);
            }else{
                return ldt5.plusDays(1);
            }
        });
        System.out.println(ldt6);
    }

    /**
     * 时间日期格式化
     * DateTimeFormatter
     */
    @Test
    public void test6(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(dtf.format(ldt));

        //自定义时间格式
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        //str -> ldt
    }
    /**
     * ZoneTime  ZoneDate  ZoneDateTime
     */
    @Test
    public void test7(){
//        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
//        zoneIds.forEach(System.out::println);
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("America/Panama"));
        System.out.println(ldt);

        LocalDateTime ldt1 = LocalDateTime.now(ZoneId.of("America/Panama"));
        ZonedDateTime zdt = ldt1.atZone(ZoneId.of("America/Panama"));
        System.out.println(zdt);
    }
}
