package com.weidong.blog.commons.until;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	/**
	 * 默认日期格式
	 */
	public static String DEFAULT_FORMAT = "yyyy-MM-dd";


	public static void main(String[] args) {
		System.out.println(formatDate(getCurrYearFirst()));
		System.out.println(formatDate(getCurrYearLast()));
	}


	/**
	 * 格式化日期
	 *
	 * @param date
	 *            日期对象
	 * @return String 日期字符串
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
		String sDate = f.format(date);
		return sDate;
	}
	/**
	 * 获取当年的第一天
	 *
	 * @param year
	 * @return
	 */
	public static Date getCurrYearFirst() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearFirst(currentYear);
	}
	/**
	 * 获取当前年份 2018
	 */
	public static String getSysYear() {
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		return year;
	}

	/**
	 * 获取当年的最后一天
	 *
	 * @param year
	 * @return
	 */
	public static Date getCurrYearLast() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearLast(currentYear);
	}

	/**
	 * 获取某年第一天日期
	 *
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getYearFirst(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	/**
	 * 获取某年最后一天日期
	 *
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getYearLast(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();

		return currYearLast;
	}

	/**
	 * 得到型如：2010-02-03 01:02:16 的时间
	 *
	 * @return
	 */
	public static String getDateAndTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(cal.getTime());
	}

	/**
	 * 日期转化为字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	/**
	 * 将Date型转换为String型
	 * 
	 * @param dtDate
	 *            Date 要转换的时间
	 * @param strPattern
	 *            String 转换的格式
	 * @return String 转换后的时间 说明：格式可以为 yyyy-MM-dd HH:mm:ss等，可任意组合，如 yyyy年MM月dd日
	 *         yyyy代表年 MM代表月 dd代表日 HH hh kk代表小时 mm代表分钟 ss代表秒钟 format
	 */
	public static String dateToString(Date dtDate, String strPattern) {
		SimpleDateFormat lsdfDate = new SimpleDateFormat(strPattern);
		return lsdfDate.format(dtDate);
	}

	/**
	 * 
	 * @Description:将某种日期转换成指定格式的日期数据 <获取相应格式的Date>
	 * @param date
	 *            需要格式的日期参数
	 * @param pattern
	 *            日期格式
	 * @ReturnType Date
	 * @author:
	 * @Created 2012 2012-9-20上午09:08:24
	 */
	public static Date getFormatDate(Date date, String pattern) {
		if (date == null) {
			throw new IllegalArgumentException("date can not be null!");
		}
		if (pattern == null) {
			pattern = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dateStr = sdf.format(date);
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {

		}
		return date;
	}

	/**
	 * 日期转化为字符串
	 * 
	 * @author limj
	 * @Date 2016年4月19日 上午9:32:11
	 * @Note 日期转化为字符串
	 *
	 * @param paramDate
	 *            日期
	 * @param formatStr
	 *            格式串
	 * @return
	 *
	 * @return String
	 */
	public static String formatDateTime(Date paramDate, String formatStr) {

		if (paramDate == null)
			return null;
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(formatStr);
		localSimpleDateFormat.setLenient(false);
		return localSimpleDateFormat.format(paramDate);

	}

	/**
	 * 日期格式化为字符串
	 * 
	 * @author limj
	 * @Date 2016年4月19日 上午9:31:42
	 * @Note 日期格式化为字符串
	 *
	 * @param paramDate
	 *            日期
	 * @return
	 *
	 * @return String
	 */
	public static String formatDateTime(Date paramDate) {
		return formatDateTime(paramDate, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 功能：字符串转化为日期
	 * 
	 * @param paramString
	 * @return
	 * @throws Exception
	 */
	public static Date parseDate(String paramString) throws Exception {
		if ((paramString == null) || (paramString.trim().equals("")))
			return null;
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd");
		localSimpleDateFormat.setLenient(false);
		try {
			return localSimpleDateFormat.parse(paramString);
		} catch (ParseException localParseException) {
			throw new Exception("日期解析出错！", localParseException);
		}
	}

	/** 字符串转化为一定格式的日期 **/
	public static Date parseDate(String paramString, String format)
			throws Exception {
		if ((paramString == null) || (paramString.trim().equals("")))
			return null;
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(format);
		localSimpleDateFormat.setLenient(false);
		try {
			return localSimpleDateFormat.parse(paramString);
		} catch (ParseException localParseException) {
			throw new Exception("日期解析出错！", localParseException);
		}
	}

	/**
	 * 
	 * @Description:获取当天日期，日期格式为YYYY-MM-DD HH:mm:ss
	 * @return
	 * @ReturnType Date
	 * @author:
	 * @Created 2012 2012-9-20上午09:58:36
	 */
	public static Date getCurrentlyDate() {
		Date currentDate = new Date();
		return getFormatDate(currentDate, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 功能：日期转化为一定格式的字符串类型日期
	 * 
	 * @param date
	 * @param simpleDateFormat
	 * @return
	 */
	public static String getDateStr(Date date, String simpleDateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
		return sdf.format(date);
	}
	
	/**
	 * 根据当前日期获得其它日期
	 * 
	 * @param counter
	 *            ：度量。如果得到昨天，则counter=-1.
	 * @return
	 */
	public static String getDateDepdNow(int counter) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, counter);
		Date d = cal.getTime();
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		return sp.format(d);// 获取昨天日期
	}

	/**
	 * 获取当前日期加上一个月后的日期
	 * 
	 * @param counter
	 *            ：所加的月数
	 * @return
	 */
	public static String getDateDepdNowMonth(int counter) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, counter);
		Date d = cal.getTime();
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		return sp.format(d);
	}

	/**
	 * 获取当前月份加上传入月数时间的当月最后一天日期 如：2013-11-3 传入2 --> 2014-1-31
	 * 
	 * @param counter
	 * @return
	 */
	public static String getDateAddMonth(int counter) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.MONTH, counter);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		Date d = cal.getTime();
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
		return sp.format(d);
	}

	/**
	 * 获得 下个月的第一天
	 * 
	 * @return
	 */
	public static String getDateNext() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}

	/**
	 * 根据当前日期获得一定格式的其他日期
	 * 
	 * @param counter
	 *            度量。如果得到昨天，则counter=-1.
	 * @param formatStr
	 * @return
	 */
	public static String getDateDepdNow(int counter, String formatStr) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, counter);
		Date d = cal.getTime();
		SimpleDateFormat sp = new SimpleDateFormat(formatStr);
		return sp.format(d);// 获取昨天日期
	}

	/**
	 * 获取输入日期的下一天 返回 8位 like 20050101
	 * 
	 * @param today
	 * @return
	 */
	public static String getNextDay(String day) {
		return getNextDay(day, 1);
	}

	/**
	 * 获取输入日期的下 n 天 返回 8位 like 20050101
	 * 
	 * @param day
	 * @param n
	 * @return
	 */
	public static String getNextDay(String day, int n) {
		if (day == null || "".equals(day) || day.length() != 8) {
			throw new RuntimeException("由于缺少必要的参数，系统无法进行制定的日期换算.");
		}
		try {
			String sYear = day.substring(0, 4);
			int year = Integer.parseInt(sYear);
			String sMonth = day.substring(4, 6);
			int month = Integer.parseInt(sMonth);
			String sDay = day.substring(6, 8);
			int dday = Integer.parseInt(sDay);
			Calendar cal = Calendar.getInstance();
			cal.set(year, month - 1, dday);
			cal.add(Calendar.DATE, n);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			return df.format(cal.getTime());

		} catch (Exception e) {
			throw new RuntimeException("进行日期运算时输入得参数不符合系统规格." + e);

		}
	}
	
	
	/**
	 * 基于某天+-一定天数获取新的日期
	 * @param day 格式为：yyyy-MM-dd
	 * @param n
	 * @return
	 */
	public static String getNextDayByDate(String day, int n) {
		if (day == null || "".equals(day) || day.length() != 10) {
			throw new RuntimeException("由于缺少必要的参数，系统无法进行制定的日期换算.");
		}
		try {
			String sYear = day.substring(0, 4);
			int year = Integer.parseInt(sYear);
			String sMonth = day.substring(5, 7);
			int month = Integer.parseInt(sMonth);
			String sDay = day.substring(8, 10);
			int dday = Integer.parseInt(sDay);
			Calendar cal = Calendar.getInstance();
			cal.set(year, month - 1, dday);
			cal.add(Calendar.DATE, n);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format(cal.getTime());

		} catch (Exception e) {
			throw new RuntimeException("进行日期运算时输入得参数不符合系统规格." + e);

		}
	}
	
	/**
	 * 校验字符串是否为 simpleDateFormatStr 规定的格式
	 * 
	 * @param str
	 * @param simpleDateFormatStr :日期格式   如"yyyy-MM-dd"
	 * @return boolean
	 *
	 * @Author taozhaocai
	 * @Date 2016年7月29日 下午7:05:54
	 */
	public static boolean isValidDate(String str,String simpleDateFormatStr) {
        boolean convertSuccess=true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
         SimpleDateFormat format = new SimpleDateFormat(simpleDateFormatStr);
         try {
        	 // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
         } catch (ParseException e) {
           // e.printStackTrace();
 // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess=false;
        } 
        return convertSuccess;
 }

	/**
	 * 功能：Date类型对分钟进行加减法后得到日期
	 * 
	 * @param d
	 * @param minutes
	 * @return Date类型
	 */
	public static Date getDateAfterMinute(Date d, int minutes) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + minutes);
		return now.getTime();
	}

	/*** 日期对分钟做加减法，返回“yyyy-MM-dd HH:mm:ss”格式字符串类型日期 ****/
	public static String getDateAfterMinuteString(Date d, int minutes) {
		return dateToString(getDateAfterMinute(d, minutes),
				"yyyy-MM-dd HH:mm:ss");
	}

	/*** 日期对分钟做加减法，返回一定格式字符串类型日期 ****/
	public static String getDateAfterMinuteString(Date d, int minutes,
			String format) {
		return dateToString(getDateAfterMinute(d, minutes), format);
	}

	/***
	 * 日期对分钟做加减法，返回一定格式字符串类型日期 注意：此方法日期参数为字符串类型，做加减法后返回的仍为字符串时间 调用方式： String dd
	 * = getDateAfterMinuteString("2015-05-06 12:30:20", -30,
	 * "yyyy-MM-dd HH:mm:ss"); dd最后为“2015-05-06 12:00:20”
	 * 
	 * //获取前一天日期 dd = getDateAfterMinuteString("2015-05-01", -24*60,
	 * "yyyy-MM-dd")
	 ****/
	public static String getDateAfterMinuteString(String d, int minutes,
			String format) throws Exception {
		return dateToString(getDateAfterMinute(parseDate(d, format), minutes),
				format);
	}


	/**
	 * 传入月份返回月的最后一天，如果是当前月返回当前天
	 * 
	 * @param counter
	 * @return
	 */
	public static int getDayMonth(String counter) {
		int lastDay = 0;
		Calendar cal = Calendar.getInstance();
		Date d = cal.getTime();
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sp1 = new SimpleDateFormat("dd");
		if (counter.equals(sp.format(d))) {
			lastDay = Integer.parseInt(sp1.format(d));
		} else {

			try {
				cal.setTime(sp.parse(counter));
				lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		}
		return lastDay;
	}

	/**
	 * 功能：字符串转化为时间
	 * 
	 * @param paramString
	 * @return
	 * @throws Exception
	 */
	public static Date parseDateTime(String paramString)
			throws Exception {
		if ((paramString == null) || (paramString.trim().equals("")))
			return null;
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		localSimpleDateFormat.setLenient(false);
		try {
			return localSimpleDateFormat.parse(paramString);
		} catch (ParseException localParseException) {
			throw new Exception("时间解析异常！", localParseException);
		}
	}


	/**
	 * 获取"2015年5月21日"格式字符串
	 * 
	 * @param paramCalendar
	 * @return
	 */
	public static String getChineseDate(Calendar paramCalendar) {
		int i = paramCalendar.get(1);
		int j = paramCalendar.get(2);
		int k = paramCalendar.get(5);
		StringBuffer localStringBuffer = new StringBuffer();
		localStringBuffer.append(i);
		localStringBuffer.append("年");
		localStringBuffer.append(j + 1);
		localStringBuffer.append("月");
		localStringBuffer.append(k);
		localStringBuffer.append("日");
		return localStringBuffer.toString();
	}

	/**
	 * 获取当前周次
	 * 
	 * @param paramCalendar
	 * @return
	 */
	public static String getChineseWeekday(Calendar paramCalendar) {
		switch (paramCalendar.get(7)) {
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
		case 1:
			return "星期日";
		}
		return "未知";
	}

	/**
	 * 
	 * @Description: 获取时间的小时数（24小时制）
	 * @param date
	 * @return
	 * @ReturnType int
	 * @author:
	 * @Created 2012 2012-9-25下午08:33:44
	 */
	public static int getTime24Hour() {
		Calendar calender = Calendar.getInstance();
		calender.setTime(getCurrentlyDate());
		return calender.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 
	 * @Description:获取前一日
	 * @param date
	 * @return
	 * @ReturnType Date
	 * @author:
	 * @Created 2012 2012-9-25下午08:32:00
	 */
	@SuppressWarnings("static-access")
	public static Date getBeforeDate(Date date) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		calender.add(calender.DATE, -1);
		return calender.getTime();
	}

	/**
	 * 
	 * @Description:取得当前日期的下一日
	 * @ReturnType String
	 * @author:
	 * @Created 2012 2012-9-20上午09:12:06
	 */
	@SuppressWarnings("static-access")
	public static String getTomorrowDate() {
		Date myDate = new Date();
		Calendar calender = Calendar.getInstance();
		calender.setTime(myDate);
		calender.add(calender.DATE, 1);
		return dateToString(calender.getTime(), "yyyy-MM-dd");
	}

	/**
	 * 
	 * @Description:取当前日期后的第二日
	 * @return
	 * @ReturnType String
	 * @author:
	 * @Created 2012 2012-9-20上午10:37:47
	 */
	public static String getNextTomorrowDate() {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate = new Date();
		long myTime = (myDate.getTime() / 1000) - 60 * 60 * 24 * 365;
		myDate.setTime(myTime * 1000);
		String mDate = formatter.format(myDate);
		myTime = (myDate.getTime() / 1000) + 60 * 60 * 24;
		myDate.setTime(myTime * 1000);
		mDate = formatter.format(myDate);
		return mDate;
	}

	/**
	 * 
	 * @Description:获取当前星期在当前月份中的第几个星期
	 * @param date
	 * @return
	 * @ReturnType int
	 * @author:
	 * @Created 2012 2012-10-29上午11:45:13
	 */
	public static int getTimeWeekOfMonth(Date date) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		return calender.get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 
	 * 功能描述：获取时间在当前星期的第几天
	 * 
	 * @author <p>
	 *         创建日期 ：2012 2012-10-29上午11:45:52
	 *         </p>
	 * 
	 * @param date
	 * @return 返回星期数,其中: 1表示星期一, ...7表示星期天
	 * 
	 *         <p>
	 *         修改历史 ：(修改人，修改时间，修改原因/内容)
	 *         </p>
	 */
	public static int getTimeDateOfWeek(Date date) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		int week = calender.get(Calendar.DAY_OF_WEEK) - 1;
		if (week == 0)
			week = 7;
		return week;
	}

	/**
	 * 
	 * 功能描述：获取时间在当前星期的第几天
	 * 
	 * @author <p>
	 *         创建日期 ：2012 2012-10-29上午11:45:52
	 *         </p>
	 * 
	 * @param date
	 * @return 返回星期数,其中: 7表示星期六..1表示星期天
	 * 
	 *         <p>
	 *         修改历史 ：(修改人，修改时间，修改原因/内容)
	 *         </p>
	 */
	public static int getQuartzTimeDateOfWeek(Date date) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		int week = calender.get(Calendar.DAY_OF_WEEK);
		return week;
	}

	/**
	 * 
	 * @Description:2个时间求差，返回相差天数
	 * @param date
	 * @return
	 * @ReturnType long
	 * @author:
	 * @Created 2012 2012-12-12下午01:00:53
	 */
	public static long getAppointTimeDifference(Date startDate, Date endDate) {
		long l = endDate.getTime() - startDate.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		return day;
	}

	/**
	 * 功能：将日期转化为汉字描述
	 * 
	 * @param date
	 * @return
	 */
	@SuppressWarnings("unused")
	public static long getTimeDifference(Date date) {
		/** 获取当前系统时间 **/
		Date currentlyDate = getCurrentlyDate();
		long l = date.getTime() - currentlyDate.getTime();
		long day = l / (24 * 60 * 60 * 1000);
		long hour = (l / (60 * 60 * 1000) - day * 24);
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		return day;
	}

	/**
	 * 功能：比较2个日期大小
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareToDate(Date date1, Date date2) {
		if (date1 != null && date2 != null) {
			if (date1.getTime() > date2.getTime()) {
				return 1;
			} else if (date1.getTime() < date2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		}
		return 0;
	}

	/**
	 * 功能：时间与分钟做加减法得到的时间
	 * 
	 * @param mm
	 *            ：秒 可为正负
	 * @return
	 */
	/*
	 * public static String getTimeAfterMinute(int mm) { Calendar cal =
	 * Calendar.getInstance(); SimpleDateFormat formatter = new
	 * SimpleDateFormat("yyyyMMddHHmmss"); String hhmm =
	 * formatter.format(cal.getTime()); SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyyMMddHHmmss");// 小写的mm表示的是分钟 String dateStr = "";
	 * java.util.Date date = null; try { date = sdf.parse(hhmm); Date d =
	 * getDateAfterMinute(date, mm); java.text.DateFormat format1 = new
	 * java.text.SimpleDateFormat( "yyyyMMddHHmmss"); dateStr =
	 * format1.format(d); } catch (ParseException e) { e.printStackTrace(); }
	 * return dateStr; }
	 */

	/**
	 * 两个时间之间相差距离多少天
	 * 
	 * @param one
	 *            时间参数 1：
	 * @param two
	 *            时间参数 2：
	 * @return 相差天数
	 */
	public static long getDistanceDays(String str1, String str2)
			throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date one;
		Date two;
		long days = 0;
		try {
			one = df.parse(str1);
			two = df.parse(str2);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff;
			if (time1 < time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			days = diff / (1000 * 60 * 60 * 24);
		} catch (ParseException e) {
			throw new Exception(e);
		}
		return days;
	}

	/**
	 * 两个时间相差距离多少天多少小时多少分多少秒
	 * 
	 * @param str1
	 *            时间参数 1 格式：1990-01-01 12:00:00
	 * @param str2
	 *            时间参数 2 格式：2009-01-01 12:00:00
	 * @return long[] 返回值为：{天, 时, 分, 秒}
	 */
	public static long[] getSubtractTimes(String str1, String str2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date one;
		Date two;
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		try {
			one = df.parse(str1);
			two = df.parse(str2);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff;
			if (time1 < time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			day = diff / (24 * 60 * 60 * 1000);
			hour = (diff / (60 * 60 * 1000) - day * 24);
			min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		long[] times = { day, hour, min, sec };
		return times;
	}

	/**
	 * 两个时间相差距离多少天多少小时多少分多少秒
	 * 
	 * @param str1
	 *            时间参数 1 格式：1990-01-01 12:00:00
	 * @param str2
	 *            时间参数 2 格式：2009-01-01 12:00:00
	 * @return String 返回值为：xx天xx小时xx分xx秒
	 */
	public static String getSubtractTime(String str1, String str2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date one;
		Date two;
		long day = 0;
		long hour = 0;
		long min = 0;
		long sec = 0;
		try {
			one = df.parse(str1);
			two = df.parse(str2);
			long time1 = one.getTime();
			long time2 = two.getTime();
			long diff;
			if (time1 < time2) {
				diff = time2 - time1;
			} else {
				diff = time1 - time2;
			}
			day = diff / (24 * 60 * 60 * 1000);
			hour = (diff / (60 * 60 * 1000) - day * 24);
			min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
			sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return day + "天" + hour + "小时" + min + "分" + sec + "秒";
	}

	/**
	 * 功能：计算2个时间做差得到的秒数
	 * 
	 * @param str1
	 *            格式为:yyyy-MM-dd HH:mm:ss
	 * @param str2
	 *            格式为:yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static long getSubtractSecendTime(String str1, String str2) {
		long[] t = getSubtractTimes(str1, str2);
		return (t[0] * 24 * 60 + t[1] * 60 + t[2]) * 60 + t[3];
	}

	/**
	 * 功能：计算2个时间做差得到的分钟数
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static long getSubtractMinuteTime(String str1, String str2) {
		long[] t = getSubtractTimes(str1, str2);
		return (t[0] * 24 * 60 + t[1] * 60 + t[2]) * 60;
	}

	/**
	 * 功能：用于获取指定日期该月的所有日期 注意：2个日期转化为： java.util.Date utilDate = new
	 * java.util.Date(); java.sql.Date sqlDate = new
	 * java.sql.Date(utilDate.getTime());
	 * 
	 * @param date
	 *            java.sql.Date 要获取的月日期列表的指定日期
	 * @return Date[] java.sql.Date 返回的日期列表
	 */
	public static java.sql.Date[] getMonthDays(java.sql.Date date) {

		Calendar cale = Calendar.getInstance();
		cale.setTime(date);

		int today = cale.get(Calendar.DAY_OF_MONTH);
		int days = cale.getActualMaximum(Calendar.DAY_OF_MONTH);
		long millis = cale.getTimeInMillis();

		java.sql.Date dates[] = new java.sql.Date[days];
		for (int i = 1; i <= days; i++) {
			long sub = (today - i) * 24 * 60 * 60 * 1000L;
			dates[i - 1] = new java.sql.Date(millis - sub);
		}

		cale = null;
		return dates;
	}

	// ================java中获取本周内所有日期start=============
	/**
	 * java中获取本周内所有日期 调用方法： printWeekdays(); 可根据实际情况修改
	 */
	private static final int FIRST_DAY = Calendar.MONDAY;

	@SuppressWarnings("unused")
	private static void printWeekdays() {
		Calendar calendar = Calendar.getInstance();
		setToFirstDay(calendar);
		for (int i = 0; i < 7; i++) {
			printDay(calendar);
			calendar.add(Calendar.DATE, 1);
		}
	}

	private static void setToFirstDay(Calendar calendar) {
		while (calendar.get(Calendar.DAY_OF_WEEK) != FIRST_DAY) {
			calendar.add(Calendar.DATE, -1);
		}
	}

	@SuppressWarnings("unused")
	private static void printDay(Calendar calendar) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd EE");
	}

	public static Date parseDate(String paramString, boolean b)
			throws Exception {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("");
		localSimpleDateFormat.setLenient(b);
		try {
			return localSimpleDateFormat.parse(paramString);
		} catch (ParseException localParseException) {
			throw new Exception("日期解析出错！", localParseException);
		}
	}
	
	/**
	 * 打印某年的周六周日（可根据实际情况提炼工具方法）
	 * @param year
	 */
	public static void printWeekDays(int year){
		Calendar calendar = new GregorianCalendar(year, 0, 1); // 2014年1月1日
		int i = 1;
		while (calendar.get(Calendar.YEAR) == year) {
			calendar.set(Calendar.WEEK_OF_YEAR, i++);
			
			//System.out.println("1、Calendar.DAY_OF_WEEK:"+Calendar.DAY_OF_WEEK+", Calendar.SUNDAY:"+Calendar.SUNDAY);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			if (calendar.get(Calendar.YEAR) == year) {
				System.out.printf("星期天：%tF%n", calendar);
			}
			
			//System.out.println("2、Calendar.DAY_OF_WEEK:"+Calendar.DAY_OF_WEEK+", Calendar.SATURDAY:"+Calendar.SATURDAY);
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
			if (calendar.get(Calendar.YEAR) == year) {
				System.out.printf("星期六：%tF%n", calendar);
			}
		}
	
	}

}
