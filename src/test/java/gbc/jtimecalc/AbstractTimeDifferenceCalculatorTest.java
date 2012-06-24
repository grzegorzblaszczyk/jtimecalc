/*
 * Project jtimecalc
 * http://grzegorzblaszczyk.github.com/jtimecalc
 *
 * Copyright Grzegorz Blaszczyk Consulting 2008-2009
 *
 */

/*
MIT LICENSE
Copyright (C) 2012 by Grzegorz Blaszczyk

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

package gbc.jtimecalc;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.junit.Ignore;

/**
 * AbstractTimeDifferenceCalculatorTest
 *
 * @author grzegorz@blaszczyk-consulting.com
 */
@Ignore
public class AbstractTimeDifferenceCalculatorTest {

  public static Logger logger = Logger.getLogger(AbstractTimeDifferenceCalculatorTest.class);

  public static final String TEST_METHOD_PREFIX = "should";

  private long endTime = System.currentTimeMillis();
  private long startTime = 0;
  private Map<String, String> messages = null;
  private String expectedValue = "";

  private TimeDifferenceCalculator timeDifferenceCalculator;

  protected static Calendar prepareCalendar(int year, int month, int day, int hour, int minute, int second, int millisecond) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.MILLISECOND, millisecond);
    calendar.set(Calendar.SECOND, second);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.DATE, day);
    calendar.set(Calendar.MONTH, month);
    calendar.set(Calendar.YEAR, year);
    return calendar;
  }

  protected static long substractFromDate(long endDate, int days, int hours, int minutes, int seconds, int milliseconds) {
    return endDate
            - days * Constants.ONE_DAY_IN_MILLISECONDS
            - hours * Constants.ONE_HOUR_IN_MILLISECONDS
            - minutes * Constants.ONE_MINUTE_IN_MILLISECONDS
            - seconds * Constants.ONE_SECOND_IN_MILLISECONDS
            - milliseconds;
  }

  protected static long addToDate(long startDate, int days, int hours, int minutes, int seconds, int milliseconds) {
    return startDate
            + days * Constants.ONE_DAY_IN_MILLISECONDS
            + hours * Constants.ONE_HOUR_IN_MILLISECONDS
            + minutes * Constants.ONE_MINUTE_IN_MILLISECONDS
            + seconds * Constants.ONE_SECOND_IN_MILLISECONDS
            + milliseconds;
  }

  public void resetEndTime() {
    this.endTime = System.currentTimeMillis();
  }

  @SuppressWarnings("unchecked")
  public void loadExpectedMessages(String language) {
    try {
      PropertiesConfiguration conf = new PropertiesConfiguration(AbstractTimeDifferenceCalculatorTest.class.getClassLoader().getResource(
              "resources_" + language + ".properties"));

      messages = new HashMap<String, String>();
      List<String> msgMap = conf.getList("messages");
      for (String line : msgMap) {
        String[] tmp = line.split("=");
        if (tmp.length == 2) {
          messages.put(tmp[0], tmp[1]);
        }
      }

    } catch (ConfigurationException e) {
      logger.error(e);
    }
  }

  public void shouldReturnOneMillisecond() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 0, 1));
    expectedValue = messages.get("oneMillisecond");
  }


  public void shouldReturnOneSecond() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 1, 0));
    expectedValue = messages.get("oneSecond");
  }


  public void shouldReturnOneSecondFromStaticTime() {
    setEndTime(1224844452433L);
    setStartTime(substractFromDate(endTime, 0, 0, 0, 1, 0));
    expectedValue = messages.get("oneSecond");
  }


  public void shouldReturnTwoSeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 2, 0));
    expectedValue = messages.get("twoSeconds");
  }


  public void shouldReturnThreeSeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 3, 0));
    expectedValue = messages.get("threeSeconds");
  }


  public void shouldReturnFourSeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 4, 0));
    expectedValue = messages.get("fourSeconds");
  }


  public void shouldReturnFiveSeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 5, 0));
    expectedValue = messages.get("fiveSeconds");
  }


  public void shouldReturnSixSeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 6, 0));
    expectedValue = messages.get("sixSeconds");
  }


  public void shouldReturnSevenSeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 7, 0));
    expectedValue = messages.get("sevenSeconds");
  }


  public void shouldReturnEightSeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 8, 0));
    expectedValue = messages.get("eightSeconds");
  }


  public void shouldReturnNineSeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 9, 0));
    expectedValue = messages.get("nineSeconds");
  }


  public void shouldReturnTenSeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 10, 0));
    expectedValue = messages.get("tenSeconds");
  }


  public void shouldReturn21Seconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 21, 0));
    expectedValue = messages.get("21Seconds");
  }


  public void shouldReturn51Seconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 51, 0));
    expectedValue = messages.get("51Seconds");
  }


  public void shouldReturn53Seconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 0, 53, 0));
    expectedValue = messages.get("53Seconds");
  }


  public void shouldReturnOneMinuteAndTwentySeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 1, 20, 0));
    expectedValue = messages.get("1Minute20Seconds");
  }


  public void shouldReturn24Minutes() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 24, 0, 0));
    expectedValue = messages.get("24Minutes");
  }


  public void shouldReturn59Minutes59Seconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 0, 59, 59, 0));
    expectedValue = messages.get("59Minutes59Seconds");
  }


  public void shouldReturnOneHour() {
    Calendar end = prepareCalendar(2006, Calendar.FEBRUARY, 1, 11, 0, 0, 0);
    Calendar start = (Calendar) end.clone();
    start.add(Calendar.HOUR_OF_DAY, -1);
    setEndTime(end.getTimeInMillis());
    setStartTime(start.getTimeInMillis());
    expectedValue = messages.get("1Hour");
  }


  public void shouldReturnOneHourTenMinutesAndTwentyThreeSeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 1, 10, 23, 0));
    expectedValue = messages.get("1Hour10Minutes23Seconds");
  }


  public void shouldReturn11HoursTenMinutesAndTwentyThreeSeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 11, 10, 23, 0));
    expectedValue = messages.get("11Hours10Minutes23Seconds");
  }


  public void shouldReturn22Hours() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 0, 22, 0, 0, 0));
    expectedValue = messages.get("22Hours");
  }


  public void shouldReturn1Day() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 1, 0, 0, 0, 0));
    expectedValue = messages.get("1Day");
  }


  public void shouldReturn1DayOneMinute() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 1, 0, 1, 0, 0));
    expectedValue = messages.get("1Day1Minute");
  }


  public void shouldReturn2Days11HoursTenMinutesAndTwentyThreeSeconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 2, 11, 10, 23, 0));
    expectedValue = messages.get("2Days11Hours10Minutes23Seconds");
  }


  public void shouldReturn2Days11HoursTenMinutesTwentySecondsAndThreeMilliseconds() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 2, 11, 10, 23, 3));
    expectedValue = messages.get("2Days11Hours10Minutes23Seconds3Milliseconds");
  }


  public void shouldReturn6Days() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 6, 0, 0, 0, 0));
    expectedValue = messages.get("6Days");
  }


  public void shouldReturn12Days() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 12, 0, 0, 0, 0));
    expectedValue = messages.get("12Days");
  }


  public void shouldReturn24Days() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 24, 0, 0, 0, 0));
    expectedValue = messages.get("24Days");
  }


  public void shouldReturn25Days() {
    resetEndTime();
    setStartTime(substractFromDate(endTime, 25, 0, 0, 0, 0));
    expectedValue = messages.get("25Days");
  }


  public void shouldReturn1Month5Days11HoursTenMinutesTwentySecondsAndThreeMilliseconds() {
    Calendar cal = prepareCalendar(2008, Calendar.OCTOBER, 1, 0, 0, 0, 0);
    setEndTime(cal.getTimeInMillis());
    long monthInMillis = Constants.getActualMonthInMillis(cal);
    setStartTime(substractFromDate(endTime - monthInMillis, 5, 11, 10, 23, 3));
    expectedValue = messages.get("1Month5Days11Hours10Minutes23Seconds3Milliseconds");
  }


  public void shouldReturn30Days1Hour0Minutes0seconds() {
    Calendar end = prepareCalendar(2006, Calendar.FEBRUARY, 1, 1, 0, 0, 0);
    // 1.02.2006 01:00:00.0
    setEndTime(end.getTimeInMillis());

    Calendar start = (Calendar) end.clone();
    start.add(Calendar.DATE, -30);
    start.add(Calendar.HOUR, -1);
    setStartTime(start.getTimeInMillis());
    // 2.01.2006 00:00:00.0
    expectedValue = messages.get("30Days1Hour");
  }
  
  public void shouldReturn30DaysWithoutTailingZeroes() {
    Calendar end = prepareCalendar(2006, Calendar.FEBRUARY, 1, 1, 0, 0, 0);
    // 1.02.2006 01:00:00.0
    setEndTime(end.getTimeInMillis());

    Calendar start = (Calendar) end.clone();
    start.add(Calendar.DATE, -30);
    setStartTime(start.getTimeInMillis());
    // 2.01.2006 00:00:00.0
    expectedValue = messages.get("30DaysWithoutTailingZeroes");
  }

  public void shouldReturn2Months3Days0Hours0Minutes0seconds() {
    Calendar end = prepareCalendar(2006, Calendar.FEBRUARY, 1, 0, 0, 0, 0);
    // 1.02.2006 00:00:00.0
    setEndTime(end.getTimeInMillis());

    Calendar start = (Calendar) end.clone();
    start.set(Calendar.MONTH, Calendar.DECEMBER);
    start.set(Calendar.YEAR, 2005);
    // 1.12.2005 00:00:00.0

    setStartTime(start.getTimeInMillis());
    expectedValue = messages.get("2Months3Days");
  }

  public void shouldReturn9Months0Days0Hours0Minutes0seconds() {
    Calendar end = prepareCalendar(1980, Calendar.JANUARY, 0, 0, 0, 0, 0);
    // 1.01.1980 00:00:00.0
    setEndTime(end.getTimeInMillis());

    Calendar start = (Calendar) end.clone();
    start.add(Calendar.MONTH, -9);
    setStartTime(start.getTimeInMillis());
    expectedValue = messages.get("9Months2Days");
  }
  
  public void shouldReturn1BusinessDayWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("1BusinessDay", 1);
  }
  
  public void shouldReturn2BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("2BusinessDays", 2);
  }

  public void shouldReturn3BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("3BusinessDays", 3);
  }

  public void shouldReturn4BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("4BusinessDays", 4);
  }
  
  public void shouldReturn5BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("5BusinessDays", 5);
  }
  
  public void shouldReturn6BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("6BusinessDays", 6);
  }
  
  public void shouldReturn7BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("7BusinessDays", 7);
  }
  
  public void shouldReturn8BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("8BusinessDays", 8);
  }
  
  public void shouldReturn9BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("9BusinessDays", 9);
  }
  
  public void shouldReturn10BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("10BusinessDays", 10);
  }
  
  public void shouldReturn11BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("11BusinessDays", 11);
  }
  
  public void shouldReturn12BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("12BusinessDays", 12);
  }
  
  public void shouldReturn13BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("13BusinessDays", 13);
  }
  
  public void shouldReturn14BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("14BusinessDays", 14);
  }
  
  public void shouldReturn15BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("15BusinessDays", 15);
  }
  
  public void shouldReturn16BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("16BusinessDays", 16);
  }
  
  public void shouldReturn17BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("17BusinessDays", 17);
  }
  
  public void shouldReturn18BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("18BusinessDays", 18);
  }
  
  public void shouldReturn19BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("19BusinessDays", 19);
  }
  
  public void shouldReturn20BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("20BusinessDays", 20);
  }
  
  public void shouldReturn21BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("21BusinessDays", 21);
  }
  
  public void shouldReturn22BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("22BusinessDays", 22);
  }
  
  public void shouldReturn23BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("23BusinessDays", 23);
  }
  
  public void shouldReturn24BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("24BusinessDays", 24);
  }
  
  public void shouldReturn25BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("25BusinessDays", 25);
  }
  
  public void shouldReturn26BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("26BusinessDays", 26);
  }
  
  public void shouldReturn27BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("27BusinessDays", 27);
  }
  
  public void shouldReturn28BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("28BusinessDays", 28);
  }
  
  public void shouldReturn29BusinessDaysWithoutTailingZeroes() {
    prepareStartEndAndExpectedValueForBusinessDays("29BusinessDays", 29);
  }
  
  public void shouldReturn30BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("30BusinessDays", 30);
  }
  
  public void shouldReturn31BusinessDaysWithoutTailingZeroes() {
	prepareStartEndAndExpectedValueForBusinessDays("31BusinessDays", 31);
  }
  
  public void shouldReturn1BusinessMonth20BusinessDaysWithoutTailingZeroes() {
	Calendar end = prepareCalendar(2011, Calendar.JULY, 31, 0, 0, 0, 0);
    // 31.07.2011 00:00:00.0
    setEndTime(end.getTimeInMillis());

    Calendar start = (Calendar) end.clone();
    start.set(Calendar.MONTH, Calendar.JUNE);
    start.set(Calendar.DAY_OF_MONTH, 10);
    setStartTime(start.getTimeInMillis());
    expectedValue = messages.get("1BusinessMonth20BusinessDays");
  }

  public long getEndTime() {
    return endTime;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }

  public long getStartTime() {
    return startTime;
  }

  public void setStartTime(long startTime) {
    this.startTime = startTime;
  }

  public Map<String, String> getMessages() {
    return messages;
  }

  public String getExpectedValue() {
    return expectedValue;
  }

  public void setTimeDifferenceCalculator(TimeDifferenceCalculator timeDifferenceCalculator) {
    this.timeDifferenceCalculator = timeDifferenceCalculator;
  }
  
  public TimeDifferenceCalculator getTimeDifferenceCalculator() {
    return timeDifferenceCalculator;
  }

  protected void assertCorrectMessage(String expectedValue, long endTime, long startTime, boolean omitTailingZeroes, boolean onlyBusinessDays, Map<String, String> customValues, boolean businessDaysInString) {
    String calculatedValue = getTimeDifferenceCalculator().getTimeDifferenceAsString(new TimeDifferenceContext(endTime, startTime, omitTailingZeroes, onlyBusinessDays, customValues, businessDaysInString));
    logger.debug("calculated value: '" + calculatedValue + "'");
    assertEquals("value returned is not '" + expectedValue + "' but '" + calculatedValue + "'", expectedValue, calculatedValue);
    logger.debug("expected value '" + expectedValue + "' is correct");
  }

  protected void assertCorrectMessages() {
    
    Method[] methods = this.getClass().getMethods();
    Object[] args = null;

    for (Method method : methods) {
      if (isTestMethod(method)) {
        logger.debug("Invoking " + method.getName() + "(): ");
        try {
          method.invoke(this, args);
        } catch (IllegalArgumentException e) {
          e.printStackTrace();
          throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
          e.printStackTrace();
          throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
          e.printStackTrace();
          throw new RuntimeException(e);
        }
        
        boolean omitTailingZeroes = false;
        if (method.getName().endsWith("WithoutTailingZeroes")) {
        	omitTailingZeroes = true;
        }

        boolean onlyBusinessDays = false;
        if (method.getName().contains("BusinessDay")) {
        	onlyBusinessDays = true;
        }
        
        boolean businessDaysInString = onlyBusinessDays;

		    assertCorrectMessage(getExpectedValue(), getEndTime(), getStartTime(), omitTailingZeroes, onlyBusinessDays, null, businessDaysInString);
      }
    }
  }
  
  private boolean isTestMethod(Method method) {
    if (method != null && method.getName() != null) {
      return method.getName().startsWith(TEST_METHOD_PREFIX);
    } else {
      return false;
    }
  }
  
  private void prepareStartEndAndExpectedValueForBusinessDays(String messageKey, int numOfDays) {
	Calendar end = prepareCalendar(2012, Calendar.APRIL, 30, 0, 0, 0, 0);
	// 30.04.2012 00:00:00.0 - Monday
	setEndTime(endTime = end.getTimeInMillis());
	setStartTime(substractFromDate(endTime, numOfDays, 0, 0, 0, 0));
	expectedValue = messages.get(messageKey);
  }
  
}
