/*
 * Project jtimecalc
 * http://grzegorzblaszczyk.github.com/jtimecalc
 * 
 * Copyright Grzegorz Blaszczyk Consulting 2008-2023
 * 
 */

/*
MIT LICENSE
Copyright (C) 2023 by Grzegorz Blaszczyk

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

package gbc.jtimecalc.strategy.impl;

import gbc.jtimecalc.Constants;
import gbc.jtimecalc.strategy.TimeDifferenceCalculationStrategy;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BusinessDaysOnlyTimeDifferenceCalculationStrategy implements
		TimeDifferenceCalculationStrategy {
	
	public static final Logger log = LogManager.getLogger(BusinessDaysOnlyTimeDifferenceCalculationStrategy.class);

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
