/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package util;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 日期转化工具类
 *
 * @author guominqiang
 * @version $Id DateUtil.java, v 0.1 2018-03-19 17:30 guominqiang Exp $$
 */
public class DateUtil {

    public static final String SHORT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String SHORT_DATE_GBK_FORMAT = "yyyy年MM月dd日";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";
    public static final String DATE_GBK_FORMAT = "yyyy年MM月dd日 HH时mm分";
    public static final String LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String LONG_DATE_GBK_FORMAT = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String MAIL_DATE_FORMAT = "yyyyMMddHHmmss";
    public static final String MAIL_DATE_HHMM_FORMAT = "HH:mm";
    public static final String FULL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String FULL_DATE_GBK_FORMAT = "yyyy年MM月dd日 HH时mm分ss秒SSS毫秒";
    public static final String FULL_DATE_COMPACT_FORMAT = "yyyyMMddHHmmssSSS";
    public static final String LDAP_DATE_FORMAT = "yyyyMMddHHmm'Z'";
    public static final String US_LOCALE_DATE_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";

    public static final String MAIL_DATE_DT_PART_FORMAT = "yyyyMMdd";
    public static final String MAIL_DATE_MD_PART_FORMAT = "MMdd";
    public static final String MAIL_DATE_HOUR_DT_PART_FORMAT = "yyyyMMddHH";
    public static final String MAIL_TIME_TM_PART_FORMAT = "HHmmss";
    public static final String LONG_DATE_TM_PART_FORMAT = "HH:mm:ss";
    public static final String Long_DATE_TM_PART_GBK_FORMAT = "HH时mm分ss秒";
    public static final String MAIL_DATA_DTM_PART_FORMAT = "MM月dd日HH:mm";
    public static final String POINT_DATA_DTM_PART_FORMAT = "yyyy.MM.dd";

    public static final String DEFAULT_DATE_FORMAT = US_LOCALE_DATE_FORMAT;

    public static long NANO_ONE_SECOND = 1000;
    public static long NANO_ONE_MINUTE = 60 * NANO_ONE_SECOND;
    public static long NANO_ONE_HOUR = 60 * NANO_ONE_MINUTE;
    public static long NANO_ONE_DAY = 24 * NANO_ONE_HOUR;

    public static final String DASH = "-";
    public static final String COLON = ":";

    public DateUtil() {
    }

    /**
     * 获取当前日期 ，格式类型yyyyMMdd
     */
    public static String getCurrentDate() {
        return toMailDateDtPartString(getNow());
    }

    /**
     * 获取当前月的yyyyMM格式
     *
     * @return
     */
    public static String getCurrentYearMonth() {
        return toFormatDateString(getNow(), "yyyyMM");
    }

    /**
     * 获取当前日期 ，格式类型yyyy-MM-dd
     */
    public static String getCurrentDate2() {
        return toShortDateString(getNow());
    }

    /**
     * 获取当前日期 ，格式类型yyyyMMddHH
     */
    public static String getCurrentDateHour() {
        return toMailDateHourDtPartString(getNow());
    }

    /**
     * 获取当期时间，类型HHmmss
     *
     * @return
     */
    public static String getCurrentTime() {
        return toMailTimeTmPartString(getNow());
    }

    /**
     * 获取当期时间MM月dd日HH:mm
     *
     * @return
     */
    public static String getCurrentMmDdHmTime() {
        return toMailDtmPart(getNow());
    }

    /**
     * 获取当前日期和时间，格式yyyyMMddHHmmss
     *
     * @return
     */
    public static String getCurrentDateTime() {
        return toMailDateString(getNow());
    }

    /**
     * 获取当前日期类型时间
     */
    public static Date getNow() {
        return new Date();
    }


    /**
     * 获取当前时间戳
     */
    public static long getNowTimestamp() {
        return getNow().getTime();
    }
    //============================1.Date2String=====================================

    /**
     * 将一个日期型转换为指定格式字串
     *
     * @param aDate
     * @param formatStr
     * @return
     */
    public static final String toFormatDateString(Date aDate, String formatStr) {
        if (aDate == null) return StringUtils.EMPTY;
        Assert.hasText(formatStr);
        return new SimpleDateFormat(formatStr).format(aDate);

    }

    /**
     * 将一个日期型转换为'yyyy-MM-dd'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toShortDateString(Date aDate) {
        return toFormatDateString(aDate, SHORT_DATE_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyyMMdd'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toMailDateDtPartString(Date aDate) {
        return toFormatDateString(aDate, MAIL_DATE_DT_PART_FORMAT);
    }

    /**
     * 将一个日期型转换为'MMdd'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toMailDateMdPartString(Date aDate) {
        return toFormatDateString(aDate, MAIL_DATE_MD_PART_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyyMMddHH'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toMailDateHourDtPartString(Date aDate) {
        return toFormatDateString(aDate, MAIL_DATE_HOUR_DT_PART_FORMAT);
    }

    /**
     * 将一个日期型转换为'HHmmss'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toMailTimeTmPartString(Date aDate) {
        return toFormatDateString(aDate, MAIL_TIME_TM_PART_FORMAT);
    }


    /**
     * 将一个日期型转换为'yyyyMMddHHmmss'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toMailDateString(Date aDate) {
        return toFormatDateString(aDate, MAIL_DATE_FORMAT);
    }

    /**
     *
     */
    /**
     * 将一个日期型转换为MM月dd日HH:mm格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toMailDtmPart(Date aDate) {
        return toFormatDateString(aDate, MAIL_DATA_DTM_PART_FORMAT);
    }

    /**
     *
     */
    /**
     * 将一个日期型转换为yyyy.MM.dd格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toPointDtmPart(Date aDate) {
        return toFormatDateString(aDate, POINT_DATA_DTM_PART_FORMAT);
    }


    /**
     * 将一个日期型转换为'yyyy-MM-dd HH:mm:ss'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toLongDateString(Date aDate) {
        return toFormatDateString(aDate, LONG_DATE_FORMAT);
    }

    /**
     * 将一个日期型转换为'HH:mm:ss'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toLongDateTmPartString(Date aDate) {
        return toFormatDateString(aDate, LONG_DATE_TM_PART_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyy年MM月dd日'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toShortDateGBKString(Date aDate) {
        return toFormatDateString(aDate, SHORT_DATE_GBK_FORMAT);
    }


    /**
     * 将一个日期型转换为'yyyy年MM月dd日 HH时mm分'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toDateGBKString(Date aDate) {
        return toFormatDateString(aDate, DATE_GBK_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyy年MM月dd日 HH时mm分ss秒'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toLongDateGBKString(Date aDate) {
        return toFormatDateString(aDate, LONG_DATE_GBK_FORMAT);
    }

    /**
     * 将一个日期型转换为'HH时mm分ss秒'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toLongDateTmPartGBKString(Date aDate) {
        return toFormatDateString(aDate, Long_DATE_TM_PART_GBK_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyy-MM-dd HH:mm:ss:SSS'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toFullDateString(Date aDate) {
        return toFormatDateString(aDate, FULL_DATE_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyy年MM月dd日 HH时mm分ss秒SSS毫秒'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toFullDateGBKString(Date aDate) {
        return toFormatDateString(aDate, FULL_DATE_GBK_FORMAT);
    }

    /**
     * 将一个日期型转换为'yyyyMMddHHmmssSSS'格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toFullDateCompactString(Date aDate) {
        return toFormatDateString(aDate, FULL_DATE_COMPACT_FORMAT);
    }

    /**
     * 将一个日期型转换为LDAP格式字串
     *
     * @param aDate
     * @return
     */
    public static final String toLDAPDateString(Date aDate) {
        return toFormatDateString(aDate, LDAP_DATE_FORMAT);
    }


    //============================2.String2Date=====================================

    /**
     * 将一个符合指定格式的字串解析成日期型
     *
     * @param aDateStr
     * @param formatter
     * @return
     * @throws ParseException
     */
    public static final Date parser(String aDateStr, String formatter) throws ParseException {
        if (StringUtils.isBlank(aDateStr)) return null;
        Assert.hasText(formatter);
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        return sdf.parse(aDateStr);

    }

    /**
     * 将一个符合'yyyy-MM-dd HH:mm:ss'格式的字串解析成日期型
     *
     * @param aDateStr
     * @return
     */
    public static final Date parseLongDateString(String aDateStr) throws ParseException {
        return parser(aDateStr, LONG_DATE_FORMAT);

    }

    /**
     * 将一个符合'yyyy-MM-dd HH:mm:ss'格式的字串解析成日期型
     *
     * @param aDateStr
     * @return
     */
    public static final Date parseLongDateDtPartString(String aDateStr) throws ParseException {
        return parser(aDateStr, LONG_DATE_FORMAT);

    }

    /**
     * 将一个符合'yyyy-MM-dd HH:mm:ss'格式的字串解析成日期型
     *
     * @param aDateStr
     * @return
     */
    public static final Date parseLongDateTmPartString(String aDateStr) throws ParseException {
        return parser(aDateStr, LONG_DATE_FORMAT);

    }

    /**
     * 将一个符合'yyyy-MM-dd'格式的字串解析成日期型
     *
     * @param aDateStr
     * @return
     */
    public static final Date parseShortDateString(String aDateStr) throws ParseException {
        return parser(aDateStr, SHORT_DATE_FORMAT);

    }

    /**
     * 将一个符合'yyyyMMddHHmmss'格式的字串解析成日期型
     *
     * @param aDateStr
     * @return
     */
    public static final Date parseMailDateString(String aDateStr) throws ParseException {
        return parser(aDateStr, MAIL_DATE_FORMAT);

    }

    /**
     * 将一个符合'yyyyMMdd'格式的字串解析成日期型
     *
     * @param aDateStr
     * @return
     */
    public static final Date parseMailDateDtPartString(String aDateStr) throws ParseException {
        return parser(aDateStr, MAIL_DATE_DT_PART_FORMAT);
    }

    /**
     * 将一个符合'HHmmss'格式的字串解析成日期型
     *
     * @param aDateStr
     * @return
     */
    public static final Date parseMailDateTmPartString(String aDateStr) throws ParseException {
        return parser(aDateStr, MAIL_TIME_TM_PART_FORMAT);
    }


    /**
     * 将一个符合'yyyy-MM-dd HH:mm:ss:SSS'格式的字串解析成日期型
     *
     * @param aDateStr
     * @return
     */
    public static final Date parseFullDateString(String aDateStr) throws ParseException {
        return parser(aDateStr, FULL_DATE_FORMAT);

    }

    /**
     * 将一个符合'yyyy-MM-dd'、'yyyy-MM-dd HH:mm:ss'或'EEE MMM dd HH:mm:ss zzz yyyy'格式的字串解析成日期型，
     * 如果为blank则返回空，如果不为blank又不符合格式则报错
     *
     * @param aDateStr
     * @return
     */
    public static Date parseDateString(String aDateStr) {
        Date ret = null;
        if (StringUtils.isNotBlank(aDateStr)) {
            try {
                if (DateUtil.isShortDateStr(aDateStr)) {
                    ret = DateUtil.parseShortDateString(aDateStr);
                } else if (DateUtil.isLongDateStr(aDateStr)) {
                    ret = DateUtil.parseLongDateString(aDateStr);
                } else if (DateUtil.isDateStrMatched(aDateStr, DateUtil.DEFAULT_DATE_FORMAT)) {
                    ret = DateUtil.parser(aDateStr, DateUtil.DEFAULT_DATE_FORMAT);
                } else {
                    throw new IllegalArgumentException("date format mismatch");
                }
            } catch (ParseException e) {
                //不可能到这里
            }
        }
        return ret;
    }


    //============================3.String2String=====================================


    /**
     * 转换日期格式 yyyy-MM-dd => yyyyMMdd
     *
     * @param dt yyyy-MM-dd
     * @return yyyyMMdd
     */
    public static String transfer2ShortDate(String dt) {
        if (dt == null || dt.length() != 10) {
            return dt;
        }
        Assert.notNull(dt);
        String[] tmp = StringUtils.split(dt, DASH);
        Assert.isTrue(tmp != null && tmp.length == 3);
        return tmp[0].concat(StringUtils.leftPad(tmp[1], 2, "0")).concat(StringUtils.leftPad(tmp[2], 2, "0"));
    }

    /**
     * 转换日期格式 yyyyMMdd => yyyy-MM-dd
     *
     * @param dt yyyyMMdd
     * @return yyyy-MM-dd
     */
    public static String transfer2LongDateDtPart(String dt) {
        if (dt == null || dt.length() != 8) {
            return dt;
        }
        Assert.notNull(dt);
        Assert.isTrue(dt.length() == 8);
        return dt.substring(0, 4).concat(DASH).concat(dt.substring(4, 6)).concat(DASH).concat(dt.substring(6));
    }

    /**
     * 转换日期格式 HHmmss => HH:mm:ss
     *
     * @param tm HHmmss
     * @return HH:mm:ss
     */
    public static String transfer2LongDateTmPart(String tm) {
        if (tm == null || tm.length() != 6) {
            return tm;
        }
        Assert.notNull(tm);
        Assert.isTrue(tm.length() == 6);
        return tm.substring(0, 2).concat(COLON).concat(tm.substring(2, 4)).concat(COLON).concat(tm.substring(4));
    }


    /**
     * 转换日期格式 yyyyMMdd => yyyy年MM月dd日
     *
     * @param dt yyyyMMdd
     * @return yyyy年MM月dd日
     */
    public static String transfer2LongDateGbkDtPart(String dt) {
        if (dt == null || dt.length() != 8) {
            return dt;
        }
        Assert.notNull(dt);
        Assert.isTrue(dt.length() == 8);
        return dt.substring(0, 4).concat("年").concat(dt.substring(4, 6)).concat("月").concat(dt.substring(6)).concat("日");
    }


    /**
     * 转换日期格式HHmmss => HH时mm分ss秒
     *
     * @param tm HHmmss
     * @return HH时mm分ss秒
     */
    public static String transfer2LongDateGbkTmPart(String tm) {
        if (tm == null || tm.length() != 6) {
            return tm;
        }
        Assert.notNull(tm);
        Assert.isTrue(tm.length() == 6);
        return tm.substring(0, 2).concat("时").concat(tm.substring(2, 4)).concat("分").concat(tm.substring(4)).concat("秒");
    }

    /**
     * yyyymmdd   -- > 月-日
     */
    public static String toMonthDayString(String tm) {
        Integer month = Integer.valueOf(tm.substring(4, 6));
        Integer day = Integer.valueOf(tm.substring(6));
        return String.valueOf(month).concat("月").concat(String.valueOf(day)).concat("日");
    }


    //============================4.时间加减=====================================


    /**
     * 为一个日期加上指定年数
     *
     * @param aDate
     * @param amount 年数
     * @return
     */
    public static final Date addYears(Date aDate, int amount) {
        return addTime(aDate, Calendar.YEAR, amount);
    }

    /**
     * 为一个日期加上指定月数
     *
     * @param aDate
     * @param amount 月数
     * @return
     */
    public static final Date addMonths(Date aDate, int amount) {
        return addTime(aDate, Calendar.MONTH, amount);
    }

    /**
     * 为一个日期加上指定天数
     *
     * @param aDate
     * @param amount 天数
     * @return
     */
    public static final Date addDays(Date aDate, int amount) {
        return addTime(aDate, Calendar.DAY_OF_YEAR, amount);
    }

    public static String getCurrentDate(int year, int month, int day, int beDay) {
        GregorianCalendar newCal = new GregorianCalendar(year, month, day);
        long milSec = newCal.getTimeInMillis() - (long) beDay * 24 * 3600 * 1000;
        GregorianCalendar other = new GregorianCalendar();
        other.setTimeInMillis(milSec);
        String newYear = String.valueOf(other.get(GregorianCalendar.YEAR));
        String newMonth = String.valueOf(other.get(GregorianCalendar.MONTH) + 1);
        newMonth = newMonth.length() == 1 ? "0" + newMonth : newMonth;
        String newDay = String.valueOf(other.get(GregorianCalendar.DAY_OF_MONTH));
        newDay = newDay.length() == 1 ? "0" + newDay : newDay;
        String date = newYear + "-" + newMonth + "-" + newDay;
        return date;
    }

    /**
     * 为一个日期减去一个指定天数
     *
     * @param amount 天数
     * @return yyyy-mm-dd
     */
    public static final String minusDays(int amount) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int moths = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return getCurrentDate(year, moths, day, amount - 1);
    }

    /**
     * 为一个日期减去一个指定天数
     *
     * @param amount 天数
     * @param date   日期
     * @return yyyy-MM-dd
     */
    public static final String minusDays(String date, int amount) {
        if (date == null || date.length() != 8) {
            return date;
        }
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)) - 1, Integer.parseInt(date.substring(6)));
            int moths = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int year = cal.get(Calendar.YEAR);
            return getCurrentDate(year, moths, day, amount);
        } catch (Exception e) {
            return null;
        }

    }


    public static String getCurrentDateYYYYMMDD(int year, int month, int day, int beDay) {
        GregorianCalendar newCal = new GregorianCalendar(year, month, day);
        long milSec = newCal.getTimeInMillis() - (long) beDay * 24 * 3600 * 1000;
        GregorianCalendar other = new GregorianCalendar();
        other.setTimeInMillis(milSec);
        String newYear = String.valueOf(other.get(GregorianCalendar.YEAR));
        String newMonth = String.valueOf(other.get(GregorianCalendar.MONTH) + 1);
        newMonth = newMonth.length() == 1 ? "0" + newMonth : newMonth;
        String newDay = String.valueOf(other.get(GregorianCalendar.DAY_OF_MONTH));
        newDay = newDay.length() == 1 ? "0" + newDay : newDay;
        String date = newYear + newMonth + newDay;
        return date;
    }

    /**
     * 为一个日期减去一个指定天数
     *
     * @param amount 天数
     * @param date   日期
     * @return yyyyMMdd
     */
    public static final String minusDaysYYYYMMDD(String date, int amount) {
        if (date == null || date.length() != 8) {
            return date;
        }
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)) - 1, Integer.parseInt(date.substring(6)));
            int moths = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int year = cal.get(Calendar.YEAR);
            return getCurrentDateYYYYMMDD(year, moths, day, amount);
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 为一个日期加上指定天数
     *
     * @param aDate  yyyyMMdd格式字串
     * @param amount 天数
     * @return
     */
    public static final String addDays(String aDate, int amount) {
        try {
            return DateUtil.toMailDateDtPartString(addTime(DateUtil.parseMailDateDtPartString(aDate), Calendar.DAY_OF_YEAR, amount));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 为一个日期加上指定小时数
     *
     * @param aDate
     * @param amount 小时数
     * @return
     */
    public static final Date addHours(Date aDate, int amount) {
        return addTime(aDate, Calendar.HOUR, amount);

    }

    /**
     * 为一个日期加上指定分钟数
     *
     * @param aDate
     * @param amount 分钟数
     * @return
     */
    public static final Date addMinutes(Date aDate, int amount) {
        return addTime(aDate, Calendar.MINUTE, amount);
    }

    /**
     * 为一个日期加上指定秒数
     *
     * @param aDate
     * @param amount 秒数
     * @return
     */
    public static final Date addSeconds(Date aDate, int amount) {
        return addTime(aDate, Calendar.SECOND, amount);

    }

    private static final Date addTime(Date aDate, int timeType, int amount) {
        if (aDate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(aDate);
        cal.add(timeType, amount);
        return cal.getTime();
    }


    //======================================5.时间国际化=================================

    /**
     * 得到当前时间的UTC时间
     *
     * @return
     */
    public static final String getUTCTime() {
        return getSpecifiedZoneTime(Calendar.getInstance().getTime(), TimeZone.getTimeZone("GMT+0"));
    }

    /**
     * 得到指定时间的UTC时间
     *
     * @param aDate 时间戳
     * @return yyyy-MM-dd HH:mm:ss 格式
     */
    public static final String getUTCTime(Date aDate) {
        return getSpecifiedZoneTime(aDate, TimeZone.getTimeZone("GMT+0"));
    }

    /**
     * 得到当前时间的指定时区的时间
     *
     * @param tz
     * @return
     */
    public static final String getSpecifiedZoneTime(TimeZone tz) {
        return getSpecifiedZoneTime(Calendar.getInstance().getTime(), tz);

    }

    /**
     * 得到指定时间的指定时区的时间
     *
     * @param aDate 时间戳,Date是一个瞬间的long型距离历年的位移偏量，
     *              在不同的指定的Locale/TimeZone的jvm中，它toString成不同的显示值，
     *              所以没有必要为它再指定一个TimeZone变量表示获取它时的jvm的TimeZone
     * @param tz    要转换成timezone
     * @return yyyy-MM-dd HH:mm:ss 格式
     */
    public static final String getSpecifiedZoneTime(Date aDate, TimeZone tz) {
        if (aDate == null) return StringUtils.EMPTY;
        Assert.notNull(tz);
        SimpleDateFormat sdf = new SimpleDateFormat(LONG_DATE_FORMAT);
        sdf.setTimeZone(tz);
        return sdf.format(aDate);
    }

    /*************************************************************
     * function:    add bar to a date string , such as if the date
     *              string is "20060912090807" , the return string is
     *              "2006-09-12 09:08:07"
     * input    :   date string as "20060912090807"
     * output   :   date string as "2006-09-12 09:08:07"
     * note     :   scottie xu
     *********************************************************/
    public static String addBarAndColonToDateString(String dateStr) {
        String retDateStr = "";

        if (dateStr == null || dateStr.length() != 14) {
            return dateStr;
        }

        retDateStr = dateStr.substring(0, 4) + "-"
                + dateStr.substring(4, 6) + "-"
                + dateStr.substring(6, 8) + " "
                + dateStr.substring(8, 10) + ":"
                + dateStr.substring(10, 12) + ":"
                + dateStr.substring(12);

        return retDateStr;

    }


    /*************************************************************
     * function:    remove the bar from a date string , such as if
     *              the date string is "2006-09-12" , the return
     *              string is "20060912" .
     * input    :   date string as "2006-09-12"
     * output   :   date string as "20060912"
     * note     :   scottie xu
     *********************************************************/
    public static String removeBarFromDateString(String dateStr) {
        String retDateStr = "";

        if (dateStr == null || dateStr.length() != 10) {
            return dateStr;
        }

        retDateStr = dateStr.substring(0, 4) + dateStr.substring(5, 7) + dateStr.substring(8);

        return retDateStr;

    }


    //==================================6. miscellaneous==========================

    /**
     * 计算两个日期之间相差的月数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static final int getDifferenceMonths(Date startDate, Date endDate) {
        Assert.notNull(startDate);
        Assert.notNull(endDate);
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        return Math.abs((startCal.get(Calendar.YEAR) - endCal.get(Calendar.YEAR)) * 12
                + (startCal.get(Calendar.MONTH) - endCal.get(Calendar.MONTH)));
    }

    /**
     * 计算两个日期之间相差的月数
     *
     * @param startDateStr yyyy-mm-dd
     * @param endDateStr   yyyy-mm-dd
     * @return
     */
    public static final int getDifferenceMonths(String startDateStr, String endDateStr) {
        DateUtil.checkShortDateStr(startDateStr);
        DateUtil.checkShortDateStr(endDateStr);
        try {
            return getDifferenceMonths(parseShortDateString(startDateStr), parseShortDateString(endDateStr));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param startDateStr yyyy-mm-dd
     * @param endDateStr   yyyy-mm-dd
     * @return
     */
    public static final int getDifferenceDays(String startDateStr, String endDateStr) {
        return new Long(getDifferenceMillis(startDateStr, endDateStr) / (NANO_ONE_DAY)).intValue();
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param startDateStr yyyymmdd
     * @param endDateStr   yyyymmdd
     * @return
     */
    public static final int getDifferenceDays2(String startDateStr, String endDateStr) {
        return new Long(getDifferenceMillis(startDateStr, endDateStr, MAIL_DATE_DT_PART_FORMAT) / (NANO_ONE_DAY)).intValue();
    }

    /* ------- start ------------ */

    /**
     * 两个日期之间相减（存在负数）
     *
     * @param startDateStr yyyy-mm-dd
     * @param endDateStr   yyyy-mm-dd
     * @return
     */
    public static final int getDaysSubtract(String startDateStr, String endDateStr) {
        return new Long(getDaysSubtractMillis(startDateStr, endDateStr) / (NANO_ONE_DAY)).intValue();
    }

    /**
     * 两个日期之间相减（存在负数）
     *
     * @param startDateStr yyyymmdd
     * @param endDateStr   yyyymmdd
     * @return
     */
    public static final int getDaysSubtract2(String startDateStr, String endDateStr) {
        return new Long(getDaysSubtractMillis(startDateStr, endDateStr, MAIL_DATE_DT_PART_FORMAT) / (NANO_ONE_DAY)).intValue();
    }

    /**
     * 两个日期之间相减（存在负数）
     *
     * @param startDateStr yyyy-mm-dd
     * @param endDateStr   yyyy-mm-dd
     * @return
     * @throws ParseException
     */
    public static final long getDaysSubtractMillis(String startDateStr, String endDateStr) {
        return getDaysSubtractMillis(startDateStr, endDateStr, SHORT_DATE_FORMAT);
    }

    /**
     * 计算两个日期之间相差的的毫秒数（存在负数）
     *
     * @param startDateStr
     * @param endDateStr
     * @param dateFormat
     * @return
     */
    public static final long getDaysSubtractMillis(String startDateStr, String endDateStr, String dateFormat) {
        try {
            return getDaysSubtractMillis(parser(startDateStr, dateFormat), parser(endDateStr, dateFormat));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 计算两个日期之间相差的的毫秒数（存在负数）
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static final long getDaysSubtractMillis(Date startDate, Date endDate) {
        Assert.notNull(startDate);
        Assert.notNull(endDate);
        return endDate.getTime() - startDate.getTime();
    }

    /* ------- end ------------ */

    /**
     * 计算两个日期之间相差的天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static final int getDifferenceDays(Date startDate, Date endDate) {
        return new Long(getDifferenceMillis(startDate, endDate) / (NANO_ONE_DAY)).intValue();

    }

    /*************************************************************
     * function:    delete the space
     * input    :   string as "  2  "
     * output   :   string as "2"
     * note     :   richard zhang
     *********************************************************/
    public static String deleteLRSpace(String a) {
        int i, j;
        int m = 0, n = 0;
        int len = a.length();
        String c = "";
        for (i = 0; i < len; i++) {
            if (a.substring(i, i + 1).equals("　") || a.substring(i, i + 1).equals(" ")) {
                m++;
            } else {
                break;
            }
        }
        if (m < len) {
            for (j = len - 1; j > 0; j--) {
                if (a.substring(j, j + 1).equals("　") || a.substring(j, j + 1).equals(" ")) {
                    n++;
                } else {
                    break;
                }
            }
            c = a.substring(m, len - n);
        }
        return (c);
    }

    /**
     * 计算两个日期之间相差的的毫秒数
     *
     * @param startDateStr yyyy-mm-dd
     * @param endDateStr   yyyy-mm-dd
     * @return
     * @throws ParseException
     */
    public static final long getDifferenceMillis(String startDateStr, String endDateStr) {
        return getDifferenceMillis(startDateStr, endDateStr, SHORT_DATE_FORMAT);
    }

    /**
     * 计算两个日期之间相差的的毫秒数
     *
     * @param startDateStr yyyyMMddHHmmss
     * @param endDateStr   yyyyMMddHHmmss
     * @return
     * @throws ParseException
     */
    public static final long getDifferenceMillis2(String startDateStr, String endDateStr) {
        return getDifferenceMillis(startDateStr, endDateStr, MAIL_DATE_FORMAT);
    }

    /**
     * 计算两个日期之间相差的的毫秒数
     *
     * @param startDateStr
     * @param endDateStr
     * @param dateFormat
     * @return
     */
    public static final long getDifferenceMillis(String startDateStr, String endDateStr, String dateFormat) {
        try {
            return getDifferenceMillis(parser(startDateStr, dateFormat), parser(endDateStr, dateFormat));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 计算两个日期之间相差的的毫秒数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static final long getDifferenceMillis(Date startDate, Date endDate) {
        Assert.notNull(startDate);
        Assert.notNull(endDate);
        return Math.abs(endDate.getTime() - startDate.getTime());
    }


    /**
     * 检验 日期是否在指定区间内，如果格式错误，返回false
     * <p>
     * 如果maxDateStr或minDateStr为空则比较时变为正负无穷大，如果都为空，则返回false
     *
     * @param aDate
     * @param minDateStr 必须是yyyy-MM-dd格式，时分秒为00:00:00
     * @param maxDateStr 必须是yyyy-MM-dd格式，时分秒为00:00:00
     * @return
     */
    public static final boolean isDateBetween(Date aDate, String minDateStr, String maxDateStr) {
        Assert.notNull(aDate);
        boolean ret = false;
        try {
            Date dMaxDate = null;
            Date dMinDate = null;
            dMaxDate = DateUtil.parseShortDateString(maxDateStr);
            dMinDate = DateUtil.parseShortDateString(minDateStr);
            switch ((dMaxDate != null ? 5 : 3) + (dMinDate != null ? 1 : 0)) {
                case 6:
                    ret = aDate.before(dMaxDate) && aDate.after(dMinDate);
                    break;
                case 5:
                    ret = aDate.before(dMaxDate);
                    break;
                case 4:
                    ret = aDate.after(dMinDate);
            }
        } catch (ParseException e) {
        }
        return ret;
    }

    /**
     * 检验 日期是否在指定区间内，如果格式错误，返回false
     * <p>
     * 如果maxDateStr或minDateStr为空则比较时变为正负无穷大，如果都为空，则返回false
     *
     * @param aDate      必须是yyyyMMdd格式，时分秒为00:00:00
     * @param minDateStr 必须是yyyyMMdd格式，时分秒为00:00:00
     * @param maxDateStr 必须是yyyyMMdd格式，时分秒为00:00:00
     * @return
     */
    public static final boolean isDateShortBetween(String aDate, String minDateStr, String maxDateStr) {
        Assert.notNull(aDate);
        boolean ret = false;
        try {
            Date dMaxDate = null;
            Date dMinDate = null;
            Date iDate = null;
            iDate = DateUtil.parseMailDateDtPartString(aDate);
            dMaxDate = DateUtil.parseMailDateDtPartString(maxDateStr);
            dMinDate = DateUtil.parseMailDateDtPartString(minDateStr);
            switch ((dMaxDate != null ? 5 : 3) + (dMinDate != null ? 1 : 0)) {
                case 6:
                    ret = iDate.before(dMaxDate) && iDate.after(dMinDate);
                    break;
                case 5:
                    ret = iDate.before(dMaxDate);
                    break;
                case 4:
                    ret = iDate.after(dMinDate);
            }
        } catch (ParseException e) {
            ret = false;
        }
        return ret;
    }


    /**
     * 计算某日期所在月份的天数
     *
     * @param aDateStr yyyy-mm-dd
     * @return
     */
    public static final int getDaysInMonth(String aDateStr) {
        DateUtil.checkShortDateStr(aDateStr);
        try {
            return getDaysInMonth(parseShortDateString(aDateStr));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 计算某日期所在月份的天数
     *
     * @param aDateStr yyyymmdd
     * @return
     */
    public static final int getMailDaysInMonth(String aDateStr) {
        DateUtil.isMailDateDtPartStr(aDateStr);
        try {
            return getDaysInMonth(parseMailDateDtPartString(aDateStr));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 计算某日期所在月份的天数
     *
     * @param aDate
     * @return
     */
    public static final int getDaysInMonth(Date aDate) {
        Assert.notNull(aDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(aDate);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /*************************************************************
     * function:    add Chinese to a date string , such as if the date
     *              string is "20060912" , the return string is
     *              "2006-09-12"
     * input    :   date string as "20060912"
     * output   :   date string as "2006-09-12"
     * note     :   man wu
     *********************************************************/
    public static String toDateString(String dateStr) {
        String retDateStr = "";

        if (dateStr == null || dateStr.length() != 8) {
            return dateStr;
        }

        retDateStr = dateStr.substring(0, 4) + "-"
                + dateStr.substring(4, 6) + "-"
                + dateStr.substring(6);

        return retDateStr;

    }

    public static boolean isDate(String dateStr, String formatStr) {
        if (dateStr == null) {
            return false;
        }
        if (formatStr == null) {
            return false;
        }
        if (dateStr.length() != formatStr.length()) return false;
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            format.setLenient(false);
            format.parse(dateStr);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 判断字串是否符合yyyy-MM-dd格式
     *
     * @param aDateStr
     * @return
     */
    public static final boolean isShortDateStr(String aDateStr) {
        try {
            DateUtil.parseShortDateString(aDateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 判断字串是否符合yyyy-MM-dd HH:mm:ss格式
     *
     * @param aDateStr
     * @return
     */
    public static final boolean isLongDateStr(String aDateStr) {
        try {
            DateUtil.parseLongDateString(aDateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 判断字串是否符合指定的日期格式
     *
     * @param aDateStr
     * @return
     */
    public static final boolean isDateStrMatched(String aDateStr, String formatter) {
        try {
            Date sss = DateUtil.parser(aDateStr, formatter);
            System.out.println(sss);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 检查字串是否符合yyyy-MM-dd格式
     *
     * @param aDateStr
     */
    public static final void checkShortDateStr(String aDateStr) {
        Assert.isTrue(isShortDateStr(aDateStr), "The str-'" + aDateStr + "' must match 'yyyy-MM-dd' format.");
    }

    /**
     * 判断字串是否符合yyyyMMdd格式
     *
     * @param aDateStr
     * @return
     */
    public static final boolean isMailDateDtPartStr(String aDateStr) {
        try {
            DateUtil.parseMailDateDtPartString(aDateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 检查yyyMMdd格式日期
     *
     * @param sDate
     * @return
     */
    public static boolean checkShortDate(String sDate) {
        boolean ret = true;
        if (sDate == null || sDate.length() != 8) {
            ret = false;
        }
        try {
            int year = new Integer(sDate.substring(0, 4)).intValue();
            int month = new Integer(sDate.substring(4, 6)).intValue();
            int day = new Integer(sDate.substring(6)).intValue();
            Calendar cal = Calendar.getInstance();
            cal.setLenient(false);   //允许严格检查日期格式
            cal.set(year, month - 1, day);
            cal.getTime();//该方法调用就会抛出异常
        } catch (Exception e) {
            ret = false;
        }
        return ret;
    }
}