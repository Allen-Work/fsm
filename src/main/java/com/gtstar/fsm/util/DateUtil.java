package com.gtstar.fsm.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @ClassName DateUtilForJDK8
 * @Description TODO
 * @Author yuxiang
 * @Date 2019/7/30 17:17
 **/
public class DateUtil {
    /**
     * 年月日格式 LocalDate\LocalDateTime
     *
     * @param temporal
     * @return
     */
    public static String formatYYYYMMDD(TemporalAccessor temporal) {
        return format(temporal, "yyyy-MM-dd");
    }

    /**
     * 时分秒格式化
     *
     * @param localTime
     * @return
     */
    public static String formatHHmmss(LocalTime localTime) {
        return format(localTime, "HH:mm:ss");
    }

    /**
     * 年月日时分秒格式 LocalDate\LocalDateTime
     *
     * @param temporal
     * @return
     */
    public static String formatYMDHMS(TemporalAccessor temporal) {
        return format(temporal, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 字符串解析成LocalDateTime
     *
     * @param time
     * @param pattern
     * @return
     */
    public static LocalDateTime parseLocalDateTime(String time, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(time, formatter);
    }


    /**
     * LocalDate解析成字符串
     * @param localDate
     * @param pattern
     * @return
     */
    public static String parseLocalTime(LocalDate localDate,String pattern){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String format = formatter.format(localDate);
        return format;
    }

    /**
     * 字符串解析成LocalDate
     *
     * @param time
     * @param pattern
     * @return
     */
    public static LocalDate parseLocalDate(String time, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(time, formatter);
    }

    /**
     * 字符串解析成Date
     *
     * @param time    格式化的时间
     * @param pattern 匹配的格式
     * @return
     */
    public static Date parse2Date(String time, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return Date.from(LocalDate.parse(time, formatter).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 格式化
     */
    private static String format(TemporalAccessor temporal, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(temporal);
    }

    /**
     * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
     */
    public static Long convertTimeToLong(String time) {
//        Assert.notNull(time, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(time, ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String convertTimeToString(Long time) {
//        Assert.notNull(time, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }

    /**
     * 将Long类型的时间戳转换成 LocalDateTime 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static LocalDateTime convertTimeToLocatDateTime(Long time) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
    }

    /**
     * 与当前时间对比 选择最近的时间(转为时间戳对比)
     *
     * @param timeArr
     * @return
     */
    public static String getClosestTime(String[] timeArr) {
        //当前时间
        Instant nowTime = Instant.now();
        //初始化最近时间默认为第一个
        long minDiff = nowTime.toEpochMilli() - convertTimeToLong(timeArr[0]);
        int min = 0;
        for (int i = 0; i < timeArr.length; i++) {
            long diff = nowTime.toEpochMilli() - convertTimeToLong(timeArr[i]);
            if (diff < minDiff) {
                min = i;
                minDiff = diff;
            }
        }
        return timeArr[min];
    }

    /**
     * 与当前日期对比 选择最近的日期(日期相差的天数对比)
     *
     * @param timeArr
     * @return
     */
    public static String getClosestDate(String[] timeArr) {
        //当前日期
        LocalDate nowTime = LocalDate.now();
        //初始化最近时间默认为第一个
        long minDiff = Math.abs(ChronoUnit.DAYS.between(nowTime, parseLocalDate(timeArr[0], "yyyy-MM-dd")));
        int min = 0;
        for (int i = 0; i < timeArr.length; i++) {
            long diff = Math.abs(ChronoUnit.DAYS.between(nowTime, parseLocalDate(timeArr[i], "yyyy-MM-dd")));
            if (diff < minDiff) {
                min = i;
                minDiff = diff;
            }
        }
        return timeArr[min];
    }

    /**
     * 取本月第一天
     */
    public static LocalDate firstDayOfThisMonth() {
        LocalDate today = LocalDate.now();
        return today.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 取本月第N天
     */
    public static LocalDate dayOfThisMonth(int n) {
        LocalDate today = LocalDate.now();
        return today.withDayOfMonth(n);
    }

    /**
     * 取本月最后一天
     */
    public static LocalDate lastDayOfThisMonth() {
        LocalDate today = LocalDate.now();
        return today.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 取本月第一天的开始时间
     */
    public static LocalDateTime startOfThisMonth() {
        return LocalDateTime.of(firstDayOfThisMonth(), LocalTime.MIN);
    }

    /**
     * 取本月最后一天的结束时间
     */
    public static LocalDateTime endOfThisMonth() {
        return LocalDateTime.of(lastDayOfThisMonth(), LocalTime.MAX);
    }

    /**
     * 增加 n 小时后的时间
     * @param localTime
     * @param hours
     * @return
     */
    public static LocalTime plusCountTime(LocalTime localTime,long hours){
        return localTime.plusHours(hours);
    }

    /**
     * 获取 n 周后的日期
     * @param localDate
     * @return
     */
    public static LocalDate plusCountWeek(LocalDate localDate,int weekCount){
        return localDate.plus(weekCount, ChronoUnit.WEEKS);
    }

    /**
     * 获取 n 周前的日期
     * @param localDate
     * @return
     */
    public static LocalDate minusCountWeek(LocalDate localDate,int weekCount){
        return localDate.minus(weekCount, ChronoUnit.WEEKS);
    }

    /**
     * 获取 n 年前的日期
     * @param localDate
     * @return
     */
    public static LocalDate minusCountYear(LocalDate localDate,int yearCount){
        return localDate.minus(yearCount, ChronoUnit.YEARS);
    }

    /**
     * 获取 n 年后的日期
     * @param localDate
     * @return
     */
    public static LocalDate plusCountYear(LocalDate localDate,int yearCount){
        return localDate.plus(yearCount, ChronoUnit.YEARS);
    }


    public static void main(String[] args) {
      /*  String [] timeArr = {"2018-01-01","2019-08-02","2019-07-25"};
        String closestDate = getClosestDate(timeArr);
        System.out.println(closestDate);
        String s = parseLocalTime(LocalDate.now(), "yyyy/MM/dd");
        System.out.println(s);*/
        System.out.println(plusCountWeek(LocalDate.now(),2));
    }

}
