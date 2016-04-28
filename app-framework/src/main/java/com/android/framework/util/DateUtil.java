package com.android.framework.util;

import android.content.SyncStatusObserver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * Created by xuhuanchao on 2015/11/19.
 */
public class DateUtil {

    private static final String TAG = "DateUtil";
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public static final String FULL_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";


    /**
     * 计算两个日期之间相差的天数
     * @param sDate
     * @param eDate
     * @return
     */
    public static final int getDiff(Date sDate, Date eDate) {
        long diff = sDate.getTime() - eDate.getTime();
        diff = diff / (1000 * 60 * 60 * 24);
        return Integer.parseInt(String.valueOf(diff));
    }

    /**
     * 获取date往后推dayCount天的时间
     * @param date
     * @param dayCount
     * @return
     */
    public static final Date getAfterDate(Date date, int dayCount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime() + dayCount * 24 * 60 * 60 * 1000);
        return calendar.getTime();
    }

    /**
     * 根据生日计算年龄
     * @param birthday
     * @return
     */
    public static final int getAge(Date birthday) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (calendar.before(birthday)) {
            throw new IllegalArgumentException(TAG + " 出生日期不正确，在当前日期之后");
        }
        int yearNow = calendar.get(Calendar.YEAR);
        int monthNow = calendar.get(Calendar.MONTH) + 1;
        int dayNow = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.setTime(birthday);
        int yearBirth = calendar.get(Calendar.YEAR);
        int dayBirth = calendar.get(Calendar.DAY_OF_MONTH);
        int monthBirth = calendar.get(Calendar.MONTH) + 1;
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayNow < dayBirth)
                    age--;
            } else
                age--;
        }
        return age;
    }

    /**
     * 获取当前的月份
     * @return
     */
    public static final int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return (calendar.get(Calendar.MONTH) + 1);
    }

    /**
     * 获取当前年份
     * @return
     */
    public static final int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取默认格式的当前日期的字符串
     * @return
     */
    public static final String getCurrentTime() {
//        return getDateString(new Date(), DEFAULT_DATE_PATTERN);
        return getCurrentTime(DEFAULT_DATE_PATTERN);
    }

    /**
     * 获取相应格式的当前日期的字符串
     * @param pattern
     * @return
     */
    public static final String getCurrentTime(String pattern) {
        return getDateString(new Date(), pattern);
    }

    /**
     * 通过日期字符串，获取对应格式的日期
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date getDate(String dateStr, String pattern) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            LogUtil.d(TAG, e.getMessage());
        }
        return date;
    }

    /**
     * 通过日期字符串，获取默认格式的日期
     * @param dateStr
     * @return
     */
    public static Date getDate(String dateStr) {
        return getDate(dateStr, DEFAULT_DATE_PATTERN);
    }

    /**
     * 将日期转换为相应格式的字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String getDateString(Date date, String pattern) {
//        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//        return sdf.format(date);
        String result = "";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            result = sdf.format(date);
        } catch (Exception e) {
            LogUtil.d(TAG, e.getMessage());
        }
        return result;
    }

    /**
     * 将日期转化为默认格式的字符串
     * @param date
     * @return
     */
    public static String getDateString(Date date) {
        return getDateString(date, DEFAULT_DATE_PATTERN);
    }

}
