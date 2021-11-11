package com.mzw.java8.instantTime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * @PACKAGE_NAME: com.mzw.java8.instantTime
 * @AUTHOR: mzw
 * @DATE: 2021/8/18
 */
public class DateTimeFormatTest {
    public static void main(String[] args) {
        //时间日期格式化
        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(isoDate));

        //自定义格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = dateTimeFormatter.format(now);
        System.out.println(format);

        LocalDate parse = LocalDate.parse("2020-01-02", dateTimeFormatter);
        System.out.println(parse);

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("MM-dd");
        MonthDay parse1 = MonthDay.parse("08-01", dateTimeFormatter1);
        String format1 = parse1.format(dateTimeFormatter1);
        

    }
    //时区
    @Test
    public void zoneTest(){
        //获取所有时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(availableZoneIds);

        ZoneId america = ZoneId.of("America/Panama");
        LocalDateTime americaDateTime = LocalDateTime.now(america);
        System.out.println(americaDateTime);

        LocalDateTime now = LocalDateTime.now(america);
        ZonedDateTime zonedDateTime = now.atZone(america);
        System.out.println(zonedDateTime);
    }
}
