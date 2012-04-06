/*
 * Project jtimecalc
 * http://grzegorzblaszczyk.github.com/jtimecalc
 * 
 * Copyright Grzegorz Blaszczyk Consulting 2008-2012 
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

import java.util.Calendar;

/**
 * Constants
 * 
 * @author grzegorz@blaszczyk-consulting.com
 * 
 */
public class Constants {

	/**
	 * Precalculated one second in milliseconds.
	 */
	public static final long ONE_SECOND_IN_MILLISECONDS = 1000L;

	/**
	 * Precalculated one minute in milliseconds.
	 */
	public static final long ONE_MINUTE_IN_MILLISECONDS = 60000L;

	/**
	 * Precalculated one hour in milliseconds.
	 */
	public static final long ONE_HOUR_IN_MILLISECONDS = 3600000L;

	/**
	 * Precalculated one day in milliseconds.
	 */
	public static final long ONE_DAY_IN_MILLISECONDS = 86400000L;

	/**
	 * Returns a month in milliseconds.
	 * 
	 * @param cal
	 *            instance of {@link java.util.Calendar}
	 * @return number of milliseconds in a month set by cal
	 */
	public static long getActualMonthInMillis(Calendar cal) {
		return ((long) cal.getActualMaximum(Calendar.DAY_OF_MONTH))
				* ONE_DAY_IN_MILLISECONDS;
	}
}
