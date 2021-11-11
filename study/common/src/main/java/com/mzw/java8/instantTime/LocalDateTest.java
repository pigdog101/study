package com.mzw.java8.instantTime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @PACKAGE_NAME: com.mzw.java8.instantTime
 * @AUTHOR: mzw
 * @DATE: 2021/8/17
 */
public class LocalDateTest {

    @Test
    public void LocalDateTimeTest(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime ldt = LocalDateTime.of(2020, 8, 10, 10, 10);
        System.out.println(ldt);
        LocalDateTime ldt1 = ldt.plusYears(2);

        System.out.println(ldt1);

        System.out.println(ldt1.getYear());

    }

    //Instant 时间戳操作
    @Test
    public void instantTest(){
        Instant instant = Instant.now();
        System.out.println(instant);
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(instant);
        System.out.println(offsetDateTime.toLocalDateTime());
        System.out.println(instant.toEpochMilli());
    }

    /**
     * duration时间之间的间隔
     * period 日期之间的间隔
     */
    @Test
    public void durationAndPeriodTest(){
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant ins2 = Instant.now();
        Duration between1 = Duration.between(ins1, ins2);
        System.out.println(between1.toMillis());
        OffsetDateTime zonedDateTime1 = ins1.atOffset(ZoneOffset.ofHours(8));
        LocalDate localDateTime1 = zonedDateTime1.toLocalDate();
        System.out.println(localDateTime1);

        OffsetDateTime zonedDateTime2 = ins1.atOffset(ZoneOffset.ofHours(8));
        LocalDate localDateTime2 = zonedDateTime2.toLocalDate();
        System.out.println(localDateTime2);
        Period between2 = Period.between(localDateTime1,localDateTime2);
        System.out.println(between2.getDays());
    }
}
