package com.coin.base.config;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ClassName DateUtil
 * @Description: TODO
 * @Author kh
 * @Date 2020/6/2 15:41
 * @Version V1.0
 **/
public class DateUtil {

    /**
     * @MethodName getDayBegin
     * @Description 获取天的开始
     * @param
     * @return java.util.Date
     * @throws
     * @author kh
     * @date 2020-11-12 15:57
     */
    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * @MethodName getWeekBegin
     * @Description 获取周的第一天
     * @param
     * @return java.util.Date
     * @throws
     * @author kh
     * @date 2020-11-12 15:58
     */
    public static Date getWeekBegin() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }

    public static Date getWeekBegin(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek);
        return getDayStartTime(cal.getTime());
    }

    public static Date getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) {
            calendar.setTime(d);
        }
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Date(calendar.getTimeInMillis());
    }

    public static LocalDateTime longToLocalDateTime(long l) {
        return dateToLocalDateTime(new Date(l));
    }

    public static LocalDateTime longToLocalDateTime(long l, String offsetId) {
        return dateToLocalDateTime(new Date(l), offsetId);
    }

    public static long localDateTimeToLong(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static long localDateTimeToLong(LocalDateTime localDateTime, String offsetId) {
        return localDateTime.toInstant(ZoneOffset.of(offsetId)).toEpochMilli();
    }

    public static String localDateTimeToString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTime = localDateTime.format(formatter);
        return dateTime;
    }

    public static String localDateTimeToString(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String dateTime = localDateTime.format(formatter);
        return dateTime;
    }

    public static String localDateTimeToString(LocalDateTime localDateTime, String pattern, String offsetId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String dateTime = LocalDateTime.now(ZoneOffset.of(offsetId)).format(formatter);
        return dateTime;
    }

    public static LocalDateTime stringToLocalDateTime(String datetimeStr) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(datetimeStr, df);
        return dateTime;
    }

    public static LocalDateTime stringToLocalDateTime(String datetimeStr, String pattern) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime dateTime = LocalDateTime.parse(datetimeStr, df);
        return dateTime;
    }

    public static String longToDateTimeString(long l) {
        return localDateTimeToString(dateToLocalDateTime(new Date(l)));
    }

    public static String longToDateTimeString(long l, String pattern) {
        return localDateTimeToString(dateToLocalDateTime(new Date(l)), pattern);
    }

    public static String longToDateTimeString(long l, String pattern, String offsetId) {
        return localDateTimeToString(dateToLocalDateTime(new Date(l), offsetId), pattern, offsetId);
    }

    public static LocalDateTime dateToLocalDateTime(Date date) {
        return date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
    }

    public static LocalDateTime dateToLocalDateTime(Date date, String offsetId) {
        return date.toInstant().atOffset(ZoneOffset.of(offsetId)).toLocalDateTime();
    }

    public static LocalDateTime dateToLocalDateTime(Date date, ZoneId zoneId) {
        return date.toInstant().atZone(zoneId).toLocalDateTime();
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
    }

    public static Date localDateTimeToDate(LocalDateTime localDateTime, String offsetId) {
        return Date.from(localDateTime.toInstant(ZoneOffset.of(offsetId)));
    }

    private static String getStartEndofCurrentMonth() {
        Calendar ca=Calendar.getInstance();
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat f2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int minmum=ca.getActualMinimum(Calendar.DAY_OF_MONTH);
        int day=ca.get(Calendar.DAY_OF_MONTH);
        Calendar cal=(Calendar)ca.clone();
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date endDate=cal.getTime();
        String end=f2.format(endDate);
        cal=(Calendar)ca.clone();
        cal.add(Calendar.DATE, minmum-day);

        Date startDate=cal.getTime();
        String start=f.format(startDate);
        return start + "," + end;
    }

    public static String getMonth(int year, int month) {
        Calendar ca=Calendar.getInstance();
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");

        SimpleDateFormat f2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar cal=(Calendar)ca.clone();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DATE, 1);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date endDate=cal.getTime();
        String end=f2.format(endDate);
        cal=(Calendar)ca.clone();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, 1);
        Date startDate=cal.getTime();
        String start=f.format(startDate);
        return start + "," + end;
    }

    private static String getMonth2(int year, int month) {
        Calendar ca=Calendar.getInstance();
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");

        SimpleDateFormat f2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Calendar cal=(Calendar)ca.clone();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DATE, 1);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, -1);
        // cal.add(Calendar.DATE, 1);
        Date endDate=cal.getTime();
        String end=f2.format(endDate);
        cal=(Calendar)ca.clone();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, 1);
        Date startDate=cal.getTime();
        String start=f.format(startDate);
        return start + "," + end;
    }

    private static String getStartEndOfCurrentWeek() {
        Calendar ca=Calendar.getInstance();
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
        int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek==1) {
            dayOfWeek=7;
        }else{
            dayOfWeek--;
        }
        Calendar  cal=(Calendar)ca.clone();
        cal.add(Calendar.DATE,1-dayOfWeek);
        Date date1=cal.getTime();
        cal=(Calendar)ca.clone();
        cal.add(Calendar.DATE,7-dayOfWeek);
        Date date2=cal.getTime();
        String startDate=f.format(date1);
        String endDate=f.format(date2);

        return startDate + "," + endDate;
    }

    public static String getStartEndOfQuarter(Integer year, int quarter) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
        try {
            start.set(Calendar.YEAR, year);
            end.set(Calendar.YEAR, year);
            if (quarter == 1 ) {
                start.set(Calendar.MONTH, 0);
                start.set(Calendar.DATE,1);
                end.set(Calendar.MONTH, 2);
                end.set(Calendar.DATE, 31);
            } else if (quarter == 2) {
                start.set(Calendar.MONTH, 3);
                start.set(Calendar.DATE,1);
                end.set(Calendar.MONTH, 5);
                end.set(Calendar.DATE, 30);
            } else if (quarter == 3) {
                start.set(Calendar.MONTH, 6);
                start.set(Calendar.DATE,1);
                end.set(Calendar.MONTH, 8);
                end.set(Calendar.DATE, 30);
            } else if (quarter == 4) {
                start.set(Calendar.MONTH, 9);
                start.set(Calendar.DATE,1);
                end.set(Calendar.MONTH, 11);
                end.set(Calendar.DATE, 31);
            }
            // end.add(Calendar.DATE,1);
            String startStr = f.format(start.getTime());
            String endStr = f.format(end.getTime());
            return startStr + "," + endStr;
        } catch (Exception e) {
        }
        return null;
    }

    public static String getStartEndOfQuarterWithMonth(Integer year, int month) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
        try {
            start.set(Calendar.YEAR, year);
            end.set(Calendar.YEAR, year);
            if (month >= 1 && month <= 3 ) {
                start.set(Calendar.MONTH, 0);
                start.set(Calendar.DATE,1);
                end.set(Calendar.MONTH, 2);
                end.set(Calendar.DATE, 31);
            } else if (month >= 4 && month <= 6) {
                start.set(Calendar.MONTH, 3);
                start.set(Calendar.DATE,1);
                end.set(Calendar.MONTH, 5);
                end.set(Calendar.DATE, 30);
            } else if (month >= 7 && month <= 9) {
                start.set(Calendar.MONTH, 6);
                start.set(Calendar.DATE,1);
                end.set(Calendar.MONTH, 8);
                end.set(Calendar.DATE, 30);
            } else if (month >= 10 && month <= 12) {
                start.set(Calendar.MONTH, 9);
                start.set(Calendar.DATE,1);
                end.set(Calendar.MONTH, 11);
                end.set(Calendar.DATE, 31);
            }
            // end.add(Calendar.DATE,1);
            String startStr = f.format(start.getTime());
            String endStr = f.format(end.getTime());
            return startStr + "," + endStr;
        } catch (Exception e) {

        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("getBeginDayOfWeek() = " + getWeekBegin());
        System.out.println("getDayBegin() = " + getDayBegin());
        Date date = new Date(System.currentTimeMillis() - 8 * 24 * 60 * 60 * 1000);
        System.out.println("date = " + date);
        System.out.println("getWeekBegin() = " + getWeekBegin(date));
        BigDecimal divide = new BigDecimal(2).divide(new BigDecimal(15), 4, RoundingMode.HALF_UP);
        String format = String.format("%.2f", divide);
        System.out.println("format = " + format);
    }


}
