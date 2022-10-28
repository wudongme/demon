package com.demon.design.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @desc
 * @fileName OracleToTimestamp.java
 * @date 2022/10/27/0027 9:30
 * @author Dongmo.Wu
 */
public class OracleToTimestamp {
	private static final String WITH_AM = "[0-9]{2}-[A-Z]{3}-[0-9]{2}[ ][0-9]{2}\\.[0-9]{2}\\.[0-9]{2}[\\.]{0,1}[0-9]{0,7}[ ]{0,2}AM";
	private static final Pattern PATTERN_WITH_AM = Pattern.compile(WITH_AM);

	private static final String WITH_PM = "[0-9]{2}-[A-Z]{3}-[0-9]{2}[ ][0-9]{2}\\.[0-9]{2}\\.[0-9]{2}[\\.]{0,1}[0-9]{0,7}[ ]{0,2}PM";
	private static final Pattern PATTERN_WITH_PM = Pattern.compile(WITH_PM);

	private static final String HOUR_24 = "[0-9]{2}-[A-Z]{3}-[0-9]{2}[ ][0-9]{2}\\.[0-9]{2}\\.[0-9]{2}[\\.]{0,1}[0-9]{0,7}";
	private static final Pattern PATTERN_WITH_HOUR_24 = Pattern.compile(HOUR_24);

	private static final String CHN_TIME = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}[ ][0-9]{2}:[0-9]{2}:[0-9]{2}[\\.]{0,1}[0-9]{0,7}";
	private static final Pattern PATTERN_CHN_TIME = Pattern.compile(CHN_TIME);

	private static final String CHN_DATE = "[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}";
	private static final Pattern PATTERN_CHN_DATE = Pattern.compile(CHN_DATE);

	public static void main(String[] args) {
		// SELECT to_timestamp('11-JUN-22 07.01.12.03200', 'DD-MONTH-YY HH24.MI.SS.ff4', 'NLS_DATE_LANGUAGE = American') FROM dual;
		String date = "11-JUN-22 07.01.12";
		System.out.println(getOracleTimeFunction(date));

		// 带AM或PM，那么需要HH24
		String time = "11-JUN-22 07.01.12.03200 PM";
		System.out.println(getOracleTimeFunction(time));

		System.out.println(getOracleTimeFunction("2011-11-11 11:11:11.111"));

		// true
		System.out.println(PATTERN_CHN_TIME.matcher("2011-11-11 11:11:11.111").find());

		System.out.println(PATTERN_CHN_TIME.matcher("2011-11-11").find());

		System.out.println("sb".indexOf("sb"));

	}

	public static String getOracleTimeFunction(String time) {
		 if (PATTERN_WITH_AM.matcher(time).find()) {
			 return "to_timestamp('" + time +"', 'DD-MONTH-YY HH.MI.SS.ff6 AM', 'NLS_DATE_LANGUAGE = American')";
		 } else if (PATTERN_WITH_PM.matcher(time).find()) {
			 return "to_timestamp('" + time +"', 'DD-MONTH-YY HH.MI.SS.ff6 PM', 'NLS_DATE_LANGUAGE = American')";
		 } else if (PATTERN_WITH_HOUR_24.matcher(time).find()) {
			 return "to_timestamp('" + time +"', 'DD-MONTH-YY HH24.MI.SS.ff6', 'NLS_DATE_LANGUAGE = American')";
		 } else if (PATTERN_CHN_TIME.matcher(time).find()) {
			return "to_timestamp('" + time +"', 'YYYY-MM-DD HH24.MI.SS.ff6')";
		 } else {
			 return null;
		 }
	}
}
