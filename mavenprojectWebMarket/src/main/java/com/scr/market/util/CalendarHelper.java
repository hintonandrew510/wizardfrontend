package com.scr.market.util;
import java.sql.Timestamp;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.text.*;

public class CalendarHelper {
	private static final Logger mLog = LoggerFactory.getLogger(CalendarHelper.class);

	public static String formatTimestamp(Timestamp timeStamp) {
		String s = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(timeStamp);
		return s;
	}
	
	public static boolean hasExpired(Timestamp startTime, Timestamp endTime) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		

		Calendar start = Calendar.getInstance();
		start.setTimeInMillis(startTime.getTime());
		// int startTimeInt = startTime.getDay();

		Calendar currentTimeCal = Calendar.getInstance();
		

		mLog.info(" cal start " + dateFormat.format(start.getTime()));

		Calendar end = Calendar.getInstance();
		end.setTimeInMillis(endTime.getTime());
		int endYearInt = end.get(Calendar.YEAR);
		int endMonth = end.get(Calendar.MONTH);
		int endDayOfTheYear = end.get(Calendar.DAY_OF_YEAR);

		int totalEnd = endYearInt + endMonth ;
		int currentYearInt = currentTimeCal.get(Calendar.YEAR);
		int currentMonth = currentTimeCal.get(Calendar.MONTH);
		int currentDayOfTheYear = currentTimeCal.get(Calendar.DAY_OF_YEAR);
		int totalCurrent = currentYearInt + currentMonth ;
		mLog.info(" endYearInt " + endYearInt);
		mLog.info(" endMonth " + endMonth);
		mLog.info(" endDayOfTheYear " + endDayOfTheYear);
		mLog.info(" totalEnd " + totalEnd);

		mLog.info(" startYearInt " + currentYearInt);
		mLog.info(" startMonth " + currentMonth);
		mLog.info(" startDayOfTheYear " + currentDayOfTheYear);
		mLog.info(" totalCurrent " + totalCurrent);

		// totalStart
		mLog.info(" cal start " + dateFormat.format(start.getTime()));
		mLog.info(" cal end " + dateFormat.format(end.getTime()));

		Calendar currentTime = Calendar.getInstance();

		boolean isCurrentTimeAfterStartTime = currentTime.after(start);
		boolean isCurrentTimeBeforEndTime = currentTime.before(end);

		mLog.info("currentTime.after(start) " + isCurrentTimeAfterStartTime);
		mLog.info("currentTime.before(end) " + isCurrentTimeBeforEndTime);

		boolean expired = true;
		//if (isCurrentTimeAfterStartTime && isCurrentTimeBeforEndTime) {
		//	return false;
		//}
		if (currentYearInt < endYearInt) {
			return false;
		}
		if (currentYearInt == endYearInt &&  currentMonth <= endMonth ) {
			return false;
		}

		return expired;

	}

}
