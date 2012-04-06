package gbc.jtimecalc.strategy.impl;

import gbc.jtimecalc.Constants;
import gbc.jtimecalc.strategy.TimeDifferenceCalculationStrategy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

public class BusinessDaysOnlyTimeDifferenceCalculationStrategy implements
		TimeDifferenceCalculationStrategy {
	
	public static final Logger log = Logger.getLogger(BusinessDaysOnlyTimeDifferenceCalculationStrategy.class);

	@Override
	public long calculateTimeDifference(long startTime, long endTime) {
		if (endTime - startTime < Constants.ONE_DAY_IN_MILLISECONDS) {
			return endTime - startTime;
		} else {
			
			int numberOfEntireDays = 0;
			
			Calendar start = getMidnight(startTime);
			Calendar end = getMidnight(endTime);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			log.debug("Start date: " + sdf.format(start.getTime()));
			log.debug("End date: " + sdf.format(end.getTime()));
			
			
			Calendar day = Calendar.getInstance();
			day.setTime(start.getTime());
			
			while (day.getTimeInMillis() <= end.getTimeInMillis()) {
				if (isWeekDay(day)) {
					numberOfEntireDays++;
				}
				day.add(Calendar.DATE, 1);
			}
			
			long timeDiff = 0;
			
			timeDiff += startTime - start.getTimeInMillis();
			timeDiff += numberOfEntireDays * Constants.ONE_DAY_IN_MILLISECONDS;
			timeDiff += endTime - end.getTimeInMillis();

			return timeDiff;
		}
	}

	private boolean isWeekDay(final Calendar cal) {
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		log.debug("Day of week: " + cal.get(Calendar.DAY_OF_WEEK) + " [" + ((dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) ? "week" : "weekend") + "]");
		return cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY;
	}

	private Calendar getMidnight(long startTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(startTime);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

}
