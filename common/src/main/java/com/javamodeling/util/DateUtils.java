package com.javamodeling.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {

	public DateUtils() {
	}

	/**
	 * 입력된 문자열이 yyyyMMdd 형식인지 체크한다.
	 * @param src yyyyMMdd형식의 문자열
	 * @return 입력한 값이 8자리이면서 월이 12이하이고 달이 31이하이면 true를 리턴한다.
	 */
	public static boolean isValidDefaultDateFormat(String src) {

		int month;
		int day;
		int year;
		if ((src.length() == 8)) {
			year = Integer.parseInt(src.substring(0, 4));
			month = Integer.parseInt(src.substring(4, 6));
			day = Integer.parseInt(src.substring(7, 8));

			if (month > 12 || month < 1 || day > Integer.parseInt(lastDayOfMonth(year, month))) {
				return false;
			}
			else {
				return true;
			}
		} else {
			return false;
		}
	}


	/**
	 * 날자 문자열에 해당 일수를 더하여 리턴한다.
	 * @param src yyyyMMdd형식의 문자열
	 * @param day 문자열에 더할 일수
	 * @return 더해진 일수를 String으로 리턴한다.
	 */
	public static String addDays(String src, int day) {
		GregorianCalendar cal = new GregorianCalendar();
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
		try {
			cal.setTime(simple.parse(src));
		} catch (ParseException ex) {
		}
		cal.add(GregorianCalendar.DATE, day);
		String result = simple.format(cal.getTime()).toString();

		return result;
	}

	/**
	 * 날짜 문자열(yyyyMMddHH 형식)에 해당 시간을 더하여 리턴, 마이너스는 빼서 리턴
	 * @param src 날짜 문자열(yyyyMMddHH 형식)
	 * @param time 더하거나 뺄 시간 수
	 * @return 계산된 날짜 문자열(yyyyMMddHH 형식)
	 */
	public static String addTimes(String src, int time) {

		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHH");

		GregorianCalendar cal = new GregorianCalendar();
		try {
			cal.setTime(simple.parse(src));
		} catch (ParseException ex) {
		}
		cal.add(GregorianCalendar.HOUR, time);
		String currentTime = simple.format(cal.getTime()).toString();

		return currentTime;
	}

	/**
	 * 날짜 문자열(yyyyMMddHHmmss 형식)에 해당 시간을, 주어진 형식에 맞춰서 더하면 리턴, 마이너스는 빼서 리턴
	 * @param src 날짜 문자열(yyyyMMddHHmmss 형식)
	 * @param time 더하거나 뺄 시간 수
	 * @param format 리턴할 날짜 형식
	 * @return 계산된 날짜 문자열(fomat 형식)
	 */
	public static String addTimes(String src, int time, String format) {

		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

		GregorianCalendar cal = new GregorianCalendar();
		try {
			cal.setTime(simple.parse(src));
		} catch (ParseException ex) {
		}
		cal.add(GregorianCalendar.HOUR, time);

		SimpleDateFormat simple2 = new SimpleDateFormat(format);

		String currentTime = simple2.format(cal.getTime()).toString();

		return currentTime;
	}

	/**
	 * 날짜 문자열(yyyyMMddHHmmss 형식)에 해당 시간(Hour)을, 주어진 형식에 맞춰서 더하면 리턴, 마이너스는 빼서 리턴
	 * @param src 날짜 문자열(yyyyMMddHHmmss 형식)
	 * @param time 더하거나 뺄 시간 수 (Hour)
	 * @param format 리턴할 날짜 형식
	 * @return 계산된 날짜 문자열(fomat 형식)
	 */
	public static String addHours(String src, int time, String format) {

		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

		GregorianCalendar cal = new GregorianCalendar();
		try {
			cal.setTime(simple.parse(src));
		} catch (ParseException ex) {
		}
		cal.add(GregorianCalendar.HOUR, time);

		SimpleDateFormat simple2 = new SimpleDateFormat(format);

		String currentTime = simple2.format(cal.getTime()).toString();

		return currentTime;
	}
	
	/**
	 * 날짜 문자열(yyyyMMddHHmmss 형식)에 해당 시간(Minutes)을, 주어진 형식에 맞춰서 더하면 리턴, 마이너스는 빼서 리턴
	 * @param src 날짜 문자열(yyyyMMddHHmmss 형식)
	 * @param time 더하거나 뺄 시간 수 (Minute)
	 * @param format 리턴할 날짜 형식
	 * @return 계산된 날짜 문자열(fomat 형식)
	 */
	public static String addMinutes(String src, int time, String format) {

		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

		GregorianCalendar cal = new GregorianCalendar();
		try {
			cal.setTime(simple.parse(src));
		} catch (ParseException ex) {
		}
		cal.add(GregorianCalendar.MINUTE, time);

		SimpleDateFormat simple2 = new SimpleDateFormat(format);

		String currentTime = simple2.format(cal.getTime()).toString();

		return currentTime;
	}
	

	/**
	 * 날짜 문자열(yyyyMMddHHmmss 형식)에 해당 시간(Second)을, 주어진 형식에 맞춰서 더하면 리턴, 마이너스는 빼서 리턴
	 * @param src 날짜 문자열(yyyyMMddHHmmss 형식)
	 * @param time 더하거나 뺄 시간 수 (Second)
	 * @param format 리턴할 날짜 형식
	 * @return 계산된 날짜 문자열(fomat 형식)
	 */
	public static String addSecons(String src, int time, String format) {

		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

		GregorianCalendar cal = new GregorianCalendar();
		try {
			cal.setTime(simple.parse(src));
		} catch (ParseException ex) {
		}
		cal.add(GregorianCalendar.SECOND, time);

		SimpleDateFormat simple2 = new SimpleDateFormat(format);

		String currentTime = simple2.format(cal.getTime()).toString();

		return currentTime;
	}
	
	
	/**
	 * 스트링문자열을 Calendar타입으로 리턴한다.
	 * @param src yyyyMMdd형식의 문자열
	 * @return Calendar
	 */
	public static Calendar changeToCalendarType(String src) {
		GregorianCalendar cal = new GregorianCalendar();
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
		try {
			cal.setTime(simple.parse(src));
		} catch (ParseException ex) {
		}

		return cal;
	}

	/**
	 * 스트링문자열을 Date타입으로 리턴한다.
	 * @param src yyyyMMddHHmmss형식의 문자열
	 * @return Date
	 */
	public static Date changeToDateType(String src) {
		GregorianCalendar cal = new GregorianCalendar();
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			cal.setTime(simple.parse(src));
		} catch (ParseException ex) {
		}

		return cal.getTime();
	}
	
	/**
	 * String 문자열을 Date 형식으로 변환하여 리턴한다.
	 * @param src String 의 날짜 데이터
	 * @param format 날짜 형식
	 */
	public static Date changeToDate(String src, String format) {
		
		Date date = null;
		try {
			
			date = new SimpleDateFormat(format).parse(src);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	/**
	 * 스트링 문자열을 해당 Locale 별로 변환해서 날짜 값으로 리턴
	 * @param src yyyyMMddHHmmss 형태의 문자열
	 * @return
	 */
	public static String convertToLocaleDateString(String src, Locale locale) {
		
		if (locale == null) {
			locale = Locale.getDefault();
		}
		
		int style = DateFormat.DEFAULT;
		
		Date date = DateUtils.changeToDateType(src);
	    DateFormat df;
	    df = DateFormat.getDateInstance(style, locale);
	    
	    String result = df.format(date);
	    return result;
	    
	}
	
	/**
	 * yyyyMMdd형식의 날자 문자열에 구분자 삽입하여 반환한다.
	 * @param src yyyyMMdd 형식의 날자 문자열
	 * @param delim 삽입하기위한 구분자
	 * @return 구분자가 삽입된 날자 문자열
	 */
	public static String changeToFormat(String src, String delim) {

		StringBuffer sb = new StringBuffer(src);
		sb.insert(4, delim);
		sb.insert(7, delim);
		
		return sb.toString();

	}

	/**
	 * 현재시간을  yyyyMMddHHmmss 형식의 형태로 반환한다.
	 * @return yyyyMMddHHmmss
	 */
	public static String getCurrentTime() {
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(System.currentTimeMillis());
		String result = simple.format(date).toString();

		return result;
	}

	/**
	 * 현재시간을  format 형식의 형태로 반환한다.
	 * @param format format형식
	 * @return result 포멧형식으로 변환된 현재시간
	 */
	public static String getCurrentTime(String format) {
		SimpleDateFormat simple = new SimpleDateFormat(format);
		Date date = new Date(System.currentTimeMillis());
		String result = simple.format(date).toString();
		return result;
	}

	/**
	 * 2개의 시간을 비교해서 차이를 리턴한다.
	 * @param from yyyyMMdd형 시작되는 날자
	 * @param to yyyyMMdd형 끝나는 날자
	 * @return 두날자간의 날자 차이를 리턴한다. 미래의 날자차이는 플러스값, 과거와의 날짜 차이는 마이너스 값이다.
	 * @throws java.lang.Exception
	 */

	public static int betweenFromTo(String from, String to) {
		GregorianCalendar cal1 = new GregorianCalendar();
		GregorianCalendar cal2 = new GregorianCalendar();
//		Date date = new Date();
		long fromTime;
		long toTime;
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");

		try {
			cal1.setTime(simple.parse(from));
			cal2.setTime(simple.parse(to));
		} catch (ParseException ex) {
		}
		
		fromTime = cal1.getTimeInMillis();
		toTime = cal2.getTimeInMillis();

		long resultTime = (toTime - fromTime) / 3600000 / 24;
		Long longValue = new Long(resultTime);
		return longValue.intValue();

	}

	/**
	 * 2개의 시간을 비교해서 차이를 리턴한다.
	 * @param from yyyyMMddHHmmss형 시작되는 날자
	 * @param to yyyyMMddHHmmss형 끝나는 날자
	 * @return 두날자간의 시간 차이를 리턴한다.
	 * @throws java.lang.Exception
	 */

	public static String betweenTimeFromTo(String from, String to) throws Exception {

		GregorianCalendar cal1 = new GregorianCalendar();
		GregorianCalendar cal2 = new GregorianCalendar();
//		Date date = new Date();
		long fromTime;
		long toTime;
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

		try {
			cal1.setTime(simple.parse(from));
			cal2.setTime(simple.parse(to));
		} catch (ParseException ex) {
		}
		fromTime = cal1.getTimeInMillis();
		toTime = cal2.getTimeInMillis();
		if (fromTime > toTime) {
			throw new Exception(
					"2nd paramater must be larger than 1nd parameter");
		}
		long resultTime = (toTime - fromTime) / 3600000 ;
		Long longValue = new Long(resultTime);
		return longValue.toString();

	}
	
	/**
	 * 2개의 시간을 비교해서 차이를 리턴한다.
	 * @param from yyyyMMddHHmmss형 시작되는 날자
	 * @param to yyyyMMddHHmmss형 끝나는 날자
	 * @return 두날자간의 시간 차이를 리턴한다.
	 */
	public static int betweenHourFromTo(String from, String to) {

		GregorianCalendar cal1 = new GregorianCalendar();
		GregorianCalendar cal2 = new GregorianCalendar();
		long fromTime;
		long toTime;
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

		try {
			cal1.setTime(simple.parse(from));
			cal2.setTime(simple.parse(to));
		} catch (ParseException ex) {
		}
		fromTime = cal1.getTimeInMillis();
		toTime = cal2.getTimeInMillis();

		long resultTime = (toTime - fromTime) / 3600000 ;
		Long longValue = new Long(resultTime);
		return longValue.intValue();

	}

	/**
	 * 2개 날자의 초를 비교해서 차이를 리턴한다.
	 * @param from yyyyMMddHHmmss형 시작되는 날자
	 * @param to yyyyMMddHHmmss형 끝나는 날자
	 * @return 두날자간의 초 차이를 리턴한다.
	 * @throws java.lang.Exception
	 */

	public static String betweenSecondFromTo(String from, String to) throws Exception {

		GregorianCalendar cal1 = new GregorianCalendar();
		GregorianCalendar cal2 = new GregorianCalendar();
		long fromTime;
		long toTime;
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMddHHmmss");

		try {
			cal1.setTime(simple.parse(from));
			cal2.setTime(simple.parse(to));
		} catch (ParseException ex) {
		}
		fromTime = cal1.getTimeInMillis();
		toTime = cal2.getTimeInMillis();
		if (fromTime > toTime) {
			throw new Exception(
					"2nd paramater must be larger than 1nd parameter");
		}
		long resultTime = (toTime - fromTime) / 1000 ;
		Long longValue = new Long(resultTime);
		return longValue.toString();

	}
	
	public static double betweenMilisecondFromTo(long from, long to) {
		
		long gap = to - from;
		
		double data = gap / 60.0;
		
		return data;
	}

	/**
	 * 해당년이 윤달인지 체크한다.
	 * @param year 해당년도
	 * @return 윤달이면 true를 리턴한다.
	 */

	public static boolean isLeapYear(int year) {
		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 해당 월의 마지막 날자를 리턴한다.
	 * @param year yyyy형식의 해당년도
	 * @param month 월
	 * @return 마지막 날자를 리턴한다.
	 */
	public static String lastDayOfMonth(int year, int month) {
		int[] monthArray = {
						   31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (!isLeapYear(year)) {
			monthArray[1] = 29;
		}
		Integer value = new Integer(monthArray[month - 1]);
		return value.toString();
	}

	/**
	 * yyyy-MM-dd HH:mm 형태를 Caledar 로 변환하여 리턴한다.
	 * @param src yyyy-MM-dd HH:mm 형식의 날짜 데이터
	 * @return
	 */
	public static Calendar convertDateFormat(String src) {
		GregorianCalendar cal = new GregorianCalendar();
		//Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			cal.setTime(simple.parse(src));
		} catch (ParseException ex) {
		}

		return cal;

	}

	/**
	 * 시간과 분으로 이루어진 4자리의 문자열을 시간형태로 다시 문자열을 만들어준다.
	 * 구분자에 해당하는 문자를 포함하여 시간을 표현한다.
	 * @param str String 숫자로만 이루어진 4자리의 문자열
	 * @param delimiter String 시간을 구분할 구분자
	 * @return String 시간 문자열
	 */
	public static String getTimeWithDelimiter(String str, String delimiter) {

		// 글자의 길이가 4자가 아닌 경우 null 리턴
		if (str.trim().length() != 4) {
			return null;
		}

		return str.substring(0, 2) + delimiter + str.substring(2);
	}

	/**
	 * 8자리의 날자를 년,월,일 으로 format 에 의해 구분 해서리턴한다.
	 * @param src 날자 문자열
	 * @param format 반환되는 format(Year,Month,Day)
	 * @return 지정된 format으로 더해진 년, 월, 일을 반환한다.
	 */
	public static String splitDateFormat(String src, String format) {
		if (format.equals("Year")) {
			src = src.substring(0, 4);
		} else if (format.equals("Month")) {
			src = src.substring(4, 6);
		} else if (format.equals("Day")) {
			src = src.substring(6, 8);
		}

		return src;
	}

	/**
	 * Timestamp 로 넘어온 값을 format 형식으로 만들어서 리턴한다.
	 * @param timestamp Timestamp
	 * @param format String
	 * @return String
	 */
	public static String getStringFormat(Timestamp timestamp, String format) {
		SimpleDateFormat simple = new SimpleDateFormat(format);
		String result = simple.format(timestamp).toString();
		return result;
	}

	/**
	 * long 형식의 날짜값으로 넘어온 값을 format 형식으로 만들어서 리턴한다.
	 * @param millitime long 형
	 * @param format
	 * @return
	 */
	public static String getStringFormat(long millitime, String format) {
		return getStringFormat(new Timestamp(millitime), format);
	}

	/**
	 * String 로 넘어온 값을 format 형식으로 만들어서 리턴한다.
	 * @param strdate String
	 * @param format String
	 * @return String
	 */
	public static String getDateStringFormat(String strdate, String format) {

		Date date = GregorianCalendar.getInstance().getTime();

		if (strdate != null && !strdate.equals("") && strdate.length() >= 8) {
			date = parseCalendar(strdate).getTime();
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		return sdf.format(date);
	}

	/**
	 * 6자리의 날자를 년-월 에 의해 구분 해서리턴한다.
	 * @param src 날자 문자열
	 * @param delim 구분자
	 * @return 지정된 format으로 더해진 년-월 을 반환한다.
	 */
	public static String fromStringToYearMonth(String src, String delim) {
		String str;
		if (src == null || src.equals("")) {
			return null;
		} else {
			str = src.substring(0, 4) + delim + src.substring(4, 6);
		}

		return str;
	}

	/**
	 * 4자리의 날자를 월:일 에 의해 구분 해서리턴한다.
	 * @param src 날자 문자열(MMdd)
	 * @param delim 구분자
	 * @return 지정된 format으로 더해진 년, 월, 일을 반환한다.
	 */
	public static String changeDateFormat(String src, String delim) {
		String str;
		if (src == null || src.equals("")) {
			return null;
		} else {
			str = src.substring(0, 2) + delim + src.substring(2, 4);
		}

		return str;
	}

	/**
	 * 4자리의 날자를 월:일 에 의해 구분 해서리턴한다.
	 * @param src 날자 문자열
	 * @param delim 구분자
	 * @param delim2 마지막
	 * @return 지정된 format으로 더해진 년, 월, 일을 반환한다.
	 */
	public static String changeDateFormat(String src, String delim, String delim2) {
		String str;
		if (src == null || src.equals("")) {
			return null;
		} else {
			str = src.substring(0, 2) + delim + src.substring(2, 4) + delim2;
		}

		return str;
	}

	/**
	 * toTimestampStringDate String 값을 Timestamp로 변환해준다.
	 *
	 * @param s_date String
	 * @return Timestamp
	 */
	public static Timestamp toTimestampStringDate(String s_date) {
		GregorianCalendar date = null;
		if (s_date == null || s_date.length() != 10) {
			date = (GregorianCalendar) Calendar.getInstance();
		} else {
			date = parseCalendar(s_date);
		}
		return new Timestamp(date.getTimeInMillis());
	}

	/**
	 * toTimestampStringDate String 값을 Timestamp로 변환해준다.
	 *
	 * @param s_date String
	 * @return Timestamp
	 */
	public static Timestamp toTimestampStringDate(String s_date, String hour) {
		GregorianCalendar date = null;
		if (s_date == null || s_date.length() != 10) {
			date = (GregorianCalendar) Calendar.getInstance();
		} else {
			date = parseCalendar(s_date);
		}

		return new Timestamp(date.getTimeInMillis() + (Integer.parseInt(hour) * 60 * 60000));
	}

	/**
	 * toTimestampStringDate String 값을 Timestamp로 변환해준다.
	 *
	 * @param s_date String
	 * @return Timestamp
	 */
	public static Timestamp toTimestampStringDate(String s_date, String hour, String minute) {
		GregorianCalendar date = null;
		if (s_date == null || s_date.length() != 10) {
			date = (GregorianCalendar) Calendar.getInstance();
		} else {
			date = parseCalendar(s_date);
		}

		return new Timestamp(date.getTimeInMillis() + (Integer.parseInt(hour) * 60 * 60000) +
							 (Integer.parseInt(minute) * 60000));
	}


	/**
	 * parseCalendar String 값을 파싱한 후 Calendsar로 변환한다.
	 *
	 * @param date_text String
	 * @return GregorianCalendar
	 */
	public static GregorianCalendar parseCalendar(String date_text) {

		GregorianCalendar gregorianCalendar = null;

		String yyyy = "";
		String MM = "";
		String dd = "";
		String hh = "";
		String mm = "";
		String ss = "";

		if (date_text.length() == 8) {
			//20051014
			yyyy = date_text.substring(0, 4);
			MM = date_text.substring(4, 6);
			dd = date_text.substring(6, 8);

		} else if (date_text.length() == 10) {
			//2005-10-14
			yyyy = date_text.substring(0, 4);
			MM = date_text.substring(5, 7);
			dd = date_text.substring(8, 10);

		} else if (date_text.length() == 12) {
			//200510141651
			yyyy = date_text.substring(0, 4);
			MM = date_text.substring(4, 6);
			dd = date_text.substring(6, 8);
			hh = date_text.substring(8, 10);
			mm = date_text.substring(10, 12);
			// ss = date_text.substring(12, 14);

		} else if (date_text.length() == 14) {
			//20051014165110
			yyyy = date_text.substring(0, 4);
			MM = date_text.substring(4, 6);
			dd = date_text.substring(6, 8);
			hh = date_text.substring(8, 10);
			mm = date_text.substring(10, 12);
			ss = date_text.substring(12, 14);
		} else if (date_text.length() == 21) {
			//2005-01-01 09:00:00.0
			yyyy = date_text.substring(0, 4);
			MM = date_text.substring(5, 7);
			dd = date_text.substring(8, 10);
			hh = date_text.substring(11, 13);
			mm = date_text.substring(14, 16);
			ss = date_text.substring(17, 19);
		}

		int year = Integer.parseInt(yyyy);
		int month = Integer.parseInt(MM);
		int day = Integer.parseInt(dd);

		if (date_text.length() >= 12) {
			int hour = Integer.parseInt(hh);
			int minute = Integer.parseInt(mm);

			if (date_text.length() >= 14) {
				int second = Integer.parseInt(ss);
				gregorianCalendar = new GregorianCalendar(year, month - 1, day, hour, minute, second);
			}else{
				gregorianCalendar = new GregorianCalendar(year, month - 1, day, hour, minute);
			}

		} else {

			gregorianCalendar = new GregorianCalendar(year, month - 1, day);
		}
		return gregorianCalendar;
	}

	/**
	 * @param y int 년
	 * @return int 배열선택값
	 */
	public static int isLeap(int year) {
		return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) ? 1 : 0;
	}

	/**
	 * @param x int 월 month -1 (0부터 시작한다.) -1(자기 달을 더해야 한다.)
	 * @param y int 년
	 * @return int 마지막날짜
	 */
	public static int leap(int x, int y) {
		x = x - 1 - 1; //-1 (0부터 시작한다.) -1(자기 달을 더해야 한다.)
		if (x < 0) {
			x += 12;
		}
		int[][] leap = { {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30,
					   31}
		};
		return leap[isLeap(y)][x];
	}

	/**
	 * 해당 월에 필요한 월을 더하고 빼는 기능, 1월에서 3달을 더하거나, 뺐을 때의 해당 월을 구한다.
	 * @param srcMonth 기준이 되는 년도월의 데이터(yyyyMM 값이 되어야 한다)
	 * @param value 더하거나 빼고자 하는 달의 값(3 : 이후 3달, -3 : 이전 3달)
	 * @return 해당 년도월의 값(yyyyMM)
	 */
	public static String addMonth(String srcMonth, int value) {
		
		String text = null;
		
		try {
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");

			Calendar cal = Calendar.getInstance();
			Date date = format.parse(srcMonth);
			
			cal.setTime(date);

			cal.add(Calendar.MONTH, value);

			text = format.format(cal.getTime());
						
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return text;
	}

	/**
	 * 파라미터로 주어진 문자열 형식의 날짜 데이터를 long 으로 변환하여 리턴
	 * @param src 문자열 형식의 날짜값
	 * @param format src 에 저장되어 있는 날짜의 형식
	 * @return long형으로 변환된 날짜값.
	 */
	public static long convertDateToLong(String src, String format) {

		long longDate = 0;

		try {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			Date date = simpleDateFormat.parse(src);

			longDate = date.getTime();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return longDate;
	}
	
	/**
	 * 파라미터로 주어진 long 형식의 날짜 데이터를 yyyyMMddHHmmss 으로 변환하여 리턴
	 * @param src long 형태의 millisecond 의 날짜값
	 * @return yyyyMMddHHmmss 형식으로 변환된 날짜값.
	 */
	public static String convertLongToDate(long src) {
		
		String result = "";

		try {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date(src);
			result = simpleDateFormat.format(date).toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	/**
	 * YYYY-MM-DDThh:mm 형태의 입력된 날짜를 YYYYMMDDhhmmss 형식으로 변환하여 리턴
	 * @param datetime input datetime으로 받은 날짜 형식
	 * @return YYYYMMDDhhmmss 형식으로 변환된 날짜값
	 */
	public static String changeDatetime(String datetime){
		String year = "";
		String month = "";
		String day = "";
		String hour = "";
		String minute = "";
		String second = "00";
		
		if (datetime == null || datetime.equals("")) {
			return null;
		} else {
		year = datetime.substring(0, 4);
		month = datetime.substring(5, 7);
		day = datetime.substring(8, 10);
		hour = datetime.substring(11, 13);
		minute = datetime.substring(14, 16);
		datetime = year + month + day + hour + minute + second;
		}
		return datetime;
	}

	/**
	 * YYYYMMDDhhmmss 형태의 입력된 날짜를 YYYY-MM-DDThh:mm 형식으로 변환하여 리턴
	 * @param datetime DB에서 가져온 날짜 형식
	 * @return input datetime 형식으로 변환된 날짜값
	 */
	public static String restoreDatetime(String datetime){
		String year = "";
		String month = "";
		String day = "";
		String hour = "";
		String minute = "";
		
		if (datetime == null || datetime.equals("")) {
			return null;
		} else {
		year = datetime.substring(0, 4);
		month = datetime.substring(4, 6);
		day = datetime.substring(6, 8);
		hour = datetime.substring(8, 10);
		minute = datetime.substring(10, 12);
		datetime = year + "-" + month + "-" + day + "T" + hour + ":" + minute;
		}
		return datetime;
	}
	
	/**
	 * YYYYMMDDhhmmss 형태의 입력된 날짜를 YYYY-MM-DD hh:mm:ss 형식으로 변환하여 리턴
	 * @param datetime DB에서 가져온 날짜 형식
	 * @return input datetime 형식으로 변환된 날짜값
	 */
	public static String traceDatetime(String datetime){
		String year = "";
		String month = "";
		String day = "";
		String hour = "";
		String minute = "";
		String second = "";
		
		if (datetime == null || datetime.equals("")) {
			return null;
		} else {
		year = datetime.substring(0, 4);
		month = datetime.substring(4, 6);
		day = datetime.substring(6, 8);
		hour = datetime.substring(8, 10);
		minute = datetime.substring(10, 12);
		second = datetime.substring(12, 14);
		datetime = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
		}
		return datetime;
	}
	

	/**
	 * YYYY-MM-DD 형태의 입력된 날짜를 YYYYMMDD 형식으로 변환하여 리턴
	 * @param date input date으로 받은 날짜 형식
	 * @return YYYYMMDD 형식으로 변환된 날짜값
	 */
	public static String changeDate(String date){
		String year = "";
		String month = "";
		String day = "";
		
		if (date == null || date.equals("")) {
			return null;
		} else {
		year = date.substring(0, 4);
		month = date.substring(5, 7);
		day = date.substring(8, 10);
		date = year + month + day;
		}
		return date;
	}
	
	/**
	 * YYYYMMDDhhmmss 형태의 입력된 날짜를 YYYY-MM-DD 형식으로 변환하여 리턴
	 * @param date DB에서 가져온 날짜 형식
	 * @return input date 형식으로 변환된 날짜값
	 */
	public static String restoreDate(String date){
		String year = "";
		String month = "";
		String day = "";
		
		if (date == null || date.equals("")) {
			return null;
		} else {
		year = date.substring(0, 4);
		month = date.substring(4, 6);
		day = date.substring(6, 8);
		
		date = year + "-" + month + "-" + day;
		}
		return date;
	}
	
	/**
	 * 날자 문자열에 해당 일수를 더하여 리턴한다.
	 * @param src yyyyMMdd형식의 문자열
	 * @param day 문자열에 더할 일수
	 * @return 더해진 일수를 String으로 리턴한다.
	 */
	public static String addchangeDays(String src, int inputDay) {
		
		String inputDate= "";	
		inputDate = src.substring(0, 8);
		
		
		GregorianCalendar cal = new GregorianCalendar();
		SimpleDateFormat simple = new SimpleDateFormat("yyyyMMdd");
		try {
			cal.setTime(simple.parse(inputDate));
		} catch (ParseException ex) {
		}
		cal.add(GregorianCalendar.DATE, inputDay);
		String result = simple.format(cal.getTime()).toString();

		result = result + "000000";
		
		return result;
	}
	
	/**
	 * yyyyMMddHHmmss 형태의 입력된 날짜를 yyyyMMdd 형식으로 변환하여 리턴
	 * @param date input date으로 받은 날짜 형식
	 * @return yyyyMMdd 형식으로 변환된 날짜값
	 */
	public static String changeYMD(String date){
		String year = "";
		String month = "";
		String day = "";

		if (date == null || date.equals("")) {
			return null;
		} else {
		year = date.substring(0, 4);
		month = date.substring(4, 6);
		day = date.substring(6, 8);
		date = year + month + day;
		}
		return date;
	}
	
	/**
	 * yyyyMMddHHmmss 형태의 입력된 날짜를 HHmmss 형식으로 변환하여 리턴
	 * @param date input date으로 받은 날짜 형식
	 * @return HHmmss 형식으로 변환된 날짜값
	 */
	public static String changeHMS(String date){
		String hour = "";
		String minute = "";
		String sec = "";

		if (date == null || date.equals("")) {
			return null;
		} 
		else {
			hour = date.substring(8, 10);
			minute = date.substring(10, 12);
			sec = date.substring(12, 14);
			date = hour + minute + sec;
		}
		return date;
	}
	
    /**
     * yyyyMMddHHmmss 형식으로 된 날짜형태의 데이터를 주어진 format 형태로 변환해준다.
     * @param src yyyyMMddHHmmss 형식의 날짜데이터
     * @param format 변경하고자 하는 형식
     * @return
     */
    public static String convertFormat(String src, String format) {
    	
    	String rssFormat = null;
    	
    	try {
			Date time = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA).parse(src);
			rssFormat = new SimpleDateFormat(format, Locale.KOREA).format(time);
		} catch (ParseException e) {
			return src;
		}
    	
    	return rssFormat;
    }
    

    /**
     * 주어진 날짜를 Format 과 Timezone 에 맞는 형식으로 변환해서 리턴한다.
     * @param src 날짜 데이터 (yyyyMMddHHmmss, 최소한 시간까지는 넣어야 계산이 가능하다.)
     * @param format 날짜 형식
     * @param timezoneId 
     * @return
     */
    public static String changeFormatTimezone(String src, String format, String timezoneId) {
    	
    	String result = "";
        
		try {
			
			SimpleDateFormat simple = new SimpleDateFormat(format);
			Date date = simple.parse(src);
			
			TimeZone zone = TimeZone.getTimeZone(timezoneId);
			simple.setTimeZone(zone);
			
			result = simple.format(date).toString();
			
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
        return result;
    	
    }
    

    /**
     * 주어진 날짜에 대한 요일을 숫자로 리턴한다. 날자 형식은 yyyyMMdd 이다.
     * @param strDate
     * @return 1 - 7(일-토)
     * @throws Exception
     */
    public static int getDayOfWeek(String strDate) {
         
        int dayNum = 0;
        
		try {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd") ;
			Date nDate = dateFormat.parse(strDate) ;
			 
			Calendar cal = Calendar.getInstance() ;
			cal.setTime(nDate);
			 
			dayNum = cal.get(Calendar.DAY_OF_WEEK);
		} catch (ParseException e) {
			dayNum = -1;
		}
         
        return dayNum ;
        
    }
    

    /**
     * 현재시간을  format 형식의 형태로 반환한다.
     * @param format format형식
     * @return result 포멧형식으로 변환된 현재시간
     */
    public static String getCurrentTime(String format, String timezone) {
        SimpleDateFormat simple = new SimpleDateFormat(format);
        
        TimeZone zone = TimeZone.getTimeZone(timezone);
        simple.setTimeZone(zone);
        
        Date date = new Date(System.currentTimeMillis());
        String result = simple.format(date).toString();
        return result;
    }
    
    /**
     * 해당 날짜에서 주중 요일을 리턴한다.
     * @param src yyyyMMdd 형식의 날짜 데이터
     * @return 숫자로 요일 값을 리턴한다. 일요일부터 1, 토요일은 7 값을 리턴, 0 값은 에러
     */
    public static int getWeekDay(String src) {
    	
    	int dayNum = 0;
    	
    	try {
    		
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			 
			 Date date = formatter.parse(src);  
			 date = new Date(date.getTime()); 
			 
			 Calendar cal = Calendar.getInstance() ;
			 cal.setTime(date);
			 
			 dayNum = cal.get(Calendar.DAY_OF_WEEK);   // 요일을 구해온다. 
			 
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	return dayNum;
    }
    
    /**
     * 다른 Timezone 와의 시간 차이를 구한다.
     * @param timezone 차이를 구할 다른 Timezone : 예) America/Chicago
     * @return 시간차이 값, 예) -14
     */
    public static long getTimeGapFromTimezone(String timezone) {
    	
		try {
			
			TimeZone tz1 = TimeZone.getTimeZone("Asia/Seoul");
			TimeZone tz2 = TimeZone.getTimeZone(timezone);
			long timeDifference = tz2.getRawOffset() - tz1.getRawOffset() + tz2.getDSTSavings() - tz1.getDSTSavings();
			
			return (timeDifference / 1000 / 60 / 60);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
    }
    

	/**
	 * 날짜에 요일을 붙여서 리턴한다.예) 2018.09.26(수)
	 * @param date : 날짜(yyyyMMdd)
	 * @param format : 리턴할 날짜 형식
	 * @return
	 */
	public static String weekDateString(String date, String format) {

		String text = DateUtils.getDateStringFormat(date, format) + weekString(date);

		return text;

	}
	
	/**
	 * 요일 문자열을 리턴한다.
	 * @param date : yyyyMMdd 형식의 날짜
	 * @return
	 */
	public static String weekString(String date) {
		
		String text = "";
		
		int weekDay = DateUtils.getDayOfWeek(date);

		if (weekDay == 1) {
			text ="(일)";
		}
		else if (weekDay == 2) {
			text ="(월)";
		}
		else if (weekDay == 3) {
			text ="(화)";
		}
		else if (weekDay == 4) {
			text ="(수)";
		}
		else if (weekDay == 5) {
			text ="(목)";
		}
		else if (weekDay == 6) {
			text ="(금)";
		}
		else if (weekDay == 7) {
			text ="(토)";
		}

		return text;
	}

}
