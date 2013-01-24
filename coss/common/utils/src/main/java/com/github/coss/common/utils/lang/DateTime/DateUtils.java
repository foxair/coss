package com.github.coss.common.utils.lang.DateTime;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.github.coss.common.utils.text.DateFormatUtils;

public class DateUtils {

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String MINUTE_DATE_FORMAT  = "yyyy-MM-dd HH:mm";

    public static final String DAY_DATE_FORMAT     = "yyyy-MM-dd";

    public static final String UNLINE_DATE_FORMAT  = "yyyy_MM_dd_HH_mm_ss";

    /**
     * <p>
     * Add field value
     * </p>
     * 
     * @param date the date to add
     * @param amount value
     * @param field
     * @see Calendar.YEAR, Calendar.MONTH ...
     * @return
     */
    public static Date add(Date date, int amount, int field) {
        Calendar c = toCalendar(date);
        c.add(field, amount);
        return toDate(c);
    }

    /**
     * <p>
     * Add year value
     * </p>
     * 
     * @param date the date to add
     * @param year value
     * @return
     */
    public static Date addYear(Date date, int year) {
        return add(date, year, Calendar.YEAR);
    }

    /**
     * <p>
     * Add month value
     * </p>
     * 
     * @param date the date to add
     * @param month month value
     * @return
     */
    public static Date addMonth(Date date, int month) {
        return add(date, month, Calendar.MONTH);
    }

    /**
     * <p>
     * Add date value
     * </p>
     * 
     * @param d the date to add
     * @param date date of month
     * @return
     */
    public static Date addDate(Date d, int date) {
        return TimeCalculate.addDay(d, date);
    }

    /**
     * <p>
     * Add hour value
     * </p>
     * 
     * @param date the date to add
     * @param hour hour of day
     * @return
     */
    public static Date addHour(Date date, int hour) {
        return TimeCalculate.addHour(date, hour);
    }

    /**
     * <p>
     * Add minute value
     * </p>
     * 
     * @param date the date to add
     * @param minute minute of hour
     * @return
     */
    public static Date addMinute(Date date, int minute) {
        return TimeCalculate.addMinute(date, minute);
    }

    /**
     * <p>
     * Add second value
     * </p>
     * 
     * @param date the date to add
     * @param second second of minute
     * @return
     */
    public static Date addSecond(Date date, int second) {
        return TimeCalculate.addSecond(date, second);
    }

    /**
     * <p>
     * Convert Date to Calendar
     * </p>
     * 
     * @param date
     * @return
     */
    public static Calendar toCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    /**
     * <p>
     * Convert Calendar to Date
     * </p>
     * 
     * @param c the Calendar to convert
     * @return
     */
    public static Date toDate(Calendar c) {
        if (c != null) {
            return c.getTime();
        }
        return null;
    }

    /**
     * <p>
     * Build a Date by appointing year,month and date
     * </p>
     * 
     * @param year
     * @param month
     * @param date
     * @return
     */
    public static Date buildDate(int year, int month, int date) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MILLISECOND, 0);
        c.set(year, month - 1, date, 0, 0, 0);
        return toDate(c);
    }

    /**
     * <p>
     * Build a Date by appointing year,month,date,hour,minute and second
     * </p>
     * 
     * @param year
     * @param month
     * @param date
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static Date buildDate(int year, int month, int date, int hour, int minute, int second) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MILLISECOND, 0);
        c.set(year, month - 1, date, hour, minute, second);
        return toDate(c);
    }

    public static Date toDate(String str) {
        if (str.contains(":")) {
            try {
                return DateFormatUtils.parse(DateFormatUtils.getDefaultTimeFormat(), str);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                return DateFormatUtils.parse(DateFormatUtils.getDefaultDateFormat(), str);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 对日期进行格式化 格式为：yyyy-MM-dd HH:mm:ss
     * 
     * @param date 需格式化的日期
     * @return 格式化后的字符串
     */
    public static String format(Date date) {
        DateFormat df = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return df.format(date);
    }

    public static final long  SECOND     = 1000;

    public static final long  MINUTE     = SECOND * 60;

    public static final long  HOUR       = MINUTE * 60;

    public static final long  DAY        = HOUR * 24;

    public static final long  WEEK       = DAY * 7;

    public static final long  YEAR       = DAY * 365;

    private static DateFormat YYYY_MM_DD = new SimpleDateFormat(DAY_DATE_FORMAT);

    /**
     * 解析日期 指定格式
     * 
     * @param date 日期字符串
     * @param pattern 日期格式
     * @return
     */
    public static Date parse(String date, String pattern) {
        Date resultDate = null;
        try {
            resultDate = new SimpleDateFormat(pattern).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    /**
     * 解析日期 yyyy-MM-dd
     * 
     * @param date 日期字符串
     * @param pattern 日期格式
     * @return
     */
    public static Date parseSimple(String date) {
        Date resultDate = null;
        try {
            resultDate = YYYY_MM_DD.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    /**
     * 格式化日期字符串
     * 
     * @param date 日期
     * @param pattern 日期格式
     * @return
     */
    public static String format(Date date, String pattern) {
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 取得当前日期时间戳
     * 
     * @return java.sql.Timestamp
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * @param offsetYear
     * @return 当前时间 + offsetYear
     */
    public static Timestamp getTimestampExpiredYear(int offsetYear) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, offsetYear);
        return new Timestamp(now.getTime().getTime());
    }

    /**
     * @param offsetMonth
     * @return 当前时间 + offsetMonth
     */
    public static Timestamp getCurrentTimestampExpiredMonth(int offsetMonth) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MONTH, offsetMonth);
        return new Timestamp(now.getTime().getTime());
    }

    /**
     * @param offsetDay
     * @return 当前时间 + offsetDay
     */
    public static Timestamp getCurrentTimestampExpiredDay(int offsetDay) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DATE, offsetDay);
        return new Timestamp(now.getTime().getTime());
    }

    /**
     * @param offsetSecond
     * @return 当前时间 + offsetSecond
     */
    public static Timestamp getCurrentTimestampExpiredSecond(int offsetSecond) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.SECOND, offsetSecond);
        return new Timestamp(now.getTime().getTime());
    }

    /**
     * @param offsetDay
     * @return 指定时间 + offsetDay
     */
    public static Timestamp getTimestampExpiredDay(Date givenDate, int offsetDay) {
        Calendar date = Calendar.getInstance();
        date.setTime(givenDate);
        date.add(Calendar.DATE, offsetDay);
        return new Timestamp(date.getTime().getTime());
    }

    /**
     * 实现ORACLE中ADD_MONTHS函数功能
     * 
     * @param offsetMonth
     * @return 指定时间 + offsetMonth
     */
    public static Timestamp getTimestampExpiredMonth(Date givenDate, int offsetMonth) {
        Calendar date = Calendar.getInstance();
        date.setTime(givenDate);
        date.add(Calendar.MONTH, offsetMonth);
        return new Timestamp(date.getTime().getTime());
    }

    /**
     * @param offsetSecond
     * @return 指定时间 + offsetSecond
     */
    public static Timestamp getTimestampExpiredSecond(Date givenDate, int offsetSecond) {
        Calendar date = Calendar.getInstance();
        date.setTime(givenDate);
        date.add(Calendar.SECOND, offsetSecond);
        return new Timestamp(date.getTime().getTime());
    }

    /**
     * @param offsetSecond
     * @return 指定时间 + offsetSecond
     */
    public static Timestamp getTimestampExpiredHour(Date givenDate, int offsetHour) {
        Calendar date = Calendar.getInstance();
        date.setTime(givenDate);
        date.add(Calendar.HOUR, offsetHour);
        return new Timestamp(date.getTime().getTime());
    }

    /**
     * @return 当前日期 yyyy-MM-dd
     */
    public static String getCurrentDay() {
        return DateUtils.format(new Date(), DAY_DATE_FORMAT);
    }

    /**
     * @return 当前的时间戳 yyyy-MM-dd HH:mm:ss
     */
    public static String getNowTime() {
        return DateUtils.format(new Date());
    }

    /**
     * @return 给出指定日期的月份的第一天
     */
    public static Date getMonthFirstDay(Date givenDate) {
        Date date = DateUtils.parse(DateUtils.format(givenDate, "yyyy-MM"), "yyyy-MM");
        return date;
    }

    /**
     * @return 给出指定日期的月份的最后一天
     */
    public static Date getMonthLastDay(Date givenDate) {
        Date firstDay = getMonthFirstDay(givenDate);
        Date lastMonthFirstDay = DateUtils.getTimestampExpiredMonth(firstDay, 1);
        Date lastDay = DateUtils.getTimestampExpiredDay(lastMonthFirstDay, -1);
        return lastDay;
    }

    /**
     * 判断指定时间是否在范围之内
     * 
     * @param theDate
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean inDatePart(Date theDate, Date startDate, Date endDate) {
        if (theDate.getTime() >= startDate.getTime() && theDate.getTime() <= endDate.getTime()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取整小时的时间
     * 
     * @param date
     * @param Hour
     * @return
     */
    public static Date getDateAtHourMinute(Date date, int Hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.HOUR_OF_DAY, Hour);
        return calendar.getTime();
    }

    /**
     * 取日期是星期几
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取一天凌晨起始的时间 如：2011-11-11 00:00:00
     * @return
     */
    public static Date getTodayFirstTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            calendar.setTime(new Date());
        } else {
            calendar.setTime(date);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 返回中文星期日期字符串
     * @param date
     * @return
     */
    public static String getDayOfWeekStr(Date date) {
        int i = getDayOfWeek(date);
        switch (i) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            default:
                return "无法识别的星期";
        }
    }

    /**
     * 把开始时间和结束时间按照一分钟步长来切分
     * 
     * @param gmtStart 起始时间
     * @param gmtEnd 结束时间
     * @param timeStep 步长
     * @return
     */
    public static List<TimePart> splitTimeUnit(Date gmtStart, Date gmtEnd, TimeUnit timeUnit,
                                               int timeStep) {
        List<TimePart> timePartList = new ArrayList<TimePart>();
        if ((gmtStart.before(gmtEnd) || gmtStart.compareTo(gmtEnd) == 0)
                && DateUtils.addTime(gmtStart, timeUnit, timeStep).after(gmtEnd)) {
            TimePart timePart = new TimePart(gmtStart, gmtEnd);
            timePartList.add(timePart);
            return timePartList;
        }
        Date dateCursorStart = gmtStart;
        Date dateCursorEnd = DateUtils.addTime(gmtStart, timeUnit, timeStep);
        while (dateCursorEnd.before(gmtEnd)) {
            TimePart timePart = new TimePart(dateCursorStart, dateCursorEnd);
            timePartList.add(timePart);
            dateCursorStart = dateCursorEnd;
            dateCursorEnd = DateUtils.addTime(dateCursorStart, timeUnit, timeStep);
            if (dateCursorEnd.after(gmtEnd) || dateCursorEnd.compareTo(gmtEnd) == 0) {
                timePartList.add(new TimePart(dateCursorStart, gmtEnd));
            }
        }
        return timePartList;
    }

    /**
     * 返回偏移量计算后的时间
     * @param gmtStart 起始时间
     * @param timeUnit 偏移时间单位
     * @param timeStep 偏移量
     * @return
     */
    public static Date addTime(Date gmtStart, TimeUnit timeUnit, int timeStep) {
        if (TimeUnit.YEAR == timeUnit) {
            return DateUtils.addYear(gmtStart, timeStep);
        } else if (TimeUnit.MONTH == timeUnit) {
            return DateUtils.addMonth(gmtStart, timeStep);
        } else if (TimeUnit.DAY == timeUnit) {
            return DateUtils.addDate(gmtStart, timeStep);
        } else if (TimeUnit.HOUR == timeUnit) {
            return DateUtils.addHour(gmtStart, timeStep);
        } else if (TimeUnit.MINUTE == timeUnit) {
            return DateUtils.addMinute(gmtStart, timeStep);
        } else if (TimeUnit.SECOND == timeUnit) {
            return DateUtils.addSecond(gmtStart, timeStep);
        } else {
            //默认返回Day
            return DateUtils.addDate(gmtStart, timeStep);
        }
    }

    /**
     * 计算两个日期之间的相差分钟数
     * 
     * @param gmtEnd 结束时间
     * @param gmtStart 起始时间
     * @return
     */
    public static long getDeltaMinutes(Date gmtEnd, Date gmtStart) {
        return (gmtEnd.getTime() - gmtStart.getTime()) / (1000 * 60);
    }

    /**
     * 计算两个日期直接的相差小时数
     * 
     * @param gmtEnd
     * @param gmtStart
     * @return
     */
    public static long getDeltaHours(Date gmtEnd, Date gmtStart) {
        return (gmtEnd.getTime() - gmtStart.getTime()) / (1000 * 60 * 60);
    }

    /**
     * 计算两个日期直接的相差天数
     * 
     * @param gmtEnd
     * @param gmtStart
     * @return
     */
    public static long getDeltaDays(Date gmtEnd, Date gmtStart) {
        return (gmtEnd.getTime() - gmtStart.getTime()) / (24 * 60 * 60 * 1000);
    }

    /**
     * 判断两个日期是否在同一天
     * 
     * @param day1
     * @param day2
     * @return
     */
    public static boolean isSameDay(Date day1, Date day2) {
        if (day1 != null && day2 != null) {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(day1);
            int y1 = c1.get(Calendar.YEAR);
            int m1 = c1.get(Calendar.MONTH);
            int d1 = c1.get(Calendar.DATE);
            Calendar c2 = Calendar.getInstance();
            c2.setTime(day2);
            int y2 = c2.get(Calendar.YEAR);
            int m2 = c2.get(Calendar.MONTH);
            int d2 = c2.get(Calendar.DATE);
            if (y1 == y2 && m1 == m2 && d1 == d2) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 获得两个日期之间的时间字符串列表
     * @param begin
     * @param end
     * @param formatStr
     * @return
     */
    public static List<String> getBetweenDays(Date begin, Date end, String formatStr) {
        List<String> list = new ArrayList<String>();
        Calendar c = Calendar.getInstance();
        c.setTime(begin);
        while (end.compareTo(c.getTime()) >= 0) {
            String tempDateStr = "";
            tempDateStr = new SimpleDateFormat(formatStr).format(c.getTime());
            list.add(tempDateStr);
            c.add(Calendar.DATE, 1);
        }
        return list;
    }

    /**
     * 求两个时间相差的毫秒数
     * 
     * @param endTime
     * @param startTime
     * @return
     */
    public static long getDeltaMilliseconds(Date endTime, Date startTime) {
        if (endTime == null || startTime == null) {
            return 0;
        }
        return endTime.getTime() - startTime.getTime();
    }

}
