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

import gbc.jtimecalc.strategy.TimeDifferenceCalculationStrategy;
import gbc.jtimecalc.strategy.impl.BusinessDaysOnlyTimeDifferenceCalculationStrategy;
import gbc.jtimecalc.strategy.impl.DefaultTimeDifferenceCalculationStrategy;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * TimeDifferenceCalculator for displaying human readable time difference
 * between two time stamps.
 * 
 * @author grzegorz@blaszczyk-consulting.com
 */
public enum TimeDifferenceCalculator {

	CZECH("cs", Type.VERY_IRREGULAR_PLURAL, "", "", false, false, "", "ms", "sekunda", "sekundy", "sekund", "minuta", "minuty", "minut", "hodina",
			"hodiny", "hodin", "den", "dn\u00ed", "dn\u00ed", "m\u011bs\u00edc", "m\u011bs\u00edce", "m\u011bs\u00edc\u016f", "pracovn\u00ed den",
			"pracovn\u00ed dny", "pracovn\u00edch dn\u016f", "pracovn\u00edch dn\u00ed", "pracovn\u00ed m\u011bs\u00edc",
			"pracovn\u00ed m\u011bs\u00edce", "pracovn\u00edch m\u011bs\u00edc\u016f"),

	DUTCH("nl", Type.IRREGULAR_PLURAL, "", "", false, false, "", "ms", "seconde", "seconden", "minuut", "minuten", "uur", "uren", "dag", "dagen",
			"maand", "maanden", "werkdag", "werkdagen", "werkmaand", "werkmaanden"),

	ENGLISH("en", Type.PLURAL_MORPHEME, "s", "e", false, false, "", "ms", "second", "minute", "hour", "day", "month", "business day",
			"business days", "business month", "business months"),

	FINNISH("fi", Type.IRREGULAR_PLURAL, "", "", false, false, "", "ms", "sekunti", "sekuntia", "minuutti", "minuuttia", "tunti", "tuntia",
			"vuorokausi", "vuorokautta", "kuukausi", "kuukautta", "työpäivä", "työpäivää", "liiketoiminnan kuukausi", "liiketoimintaa kuukautta"),

	FRENCH("fr", Type.PLURAL_MORPHEME, "s", "e", true, false, "", "ms", "seconde", "minute", "heure", "jour", "mois", "jour ouvrable",
			"jours ouvrables", "moi ouvrable", "mois ouvrables"),

	GERMAN("de", Type.IRREGULAR_PLURAL, "", "", false, false, "", "ms", "Sekunde", "Sekunden", "Minute", "Minuten", "Stunde", "Stunden", "Tag",
			"Tage", "Monat", "Monate", "Werktag", "Werktage", "Werkmonat", "Werkmonate"),

	ITALIAN("it", Type.IRREGULAR_PLURAL, "", "", false, false, "", "ms", "secondo", "seconda", "minuto", "minuti", "ora", "ore", "giorno", "giorni",
			"mese", "mesi", "giorno lavorativo", "giorni lavorativi", "mese lavorativo", "mesi lavorativi"),

	NORWEGIAN("no", Type.IRREGULAR_PLURAL, "", "", false, false, "", "ms", "sekund", "sekunder", "minutt", "minutter", "time", "timer", "dag",
			"dagen", "m\u00e5ned", "m\u00e5neden", "virkedag", "virkedager", "virkem\u00e5ned", "virkem\u00e5neder"),

	POLISH("pl", Type.VERY_IRREGULAR_PLURAL, "", "", false, false, "", "ms", "sekunda", "sekundy", "sekund", "minuta", "minuty", "minut", "godzina",
			"godziny", "godzin", "dzie\u0144", "dni", "dni", "miesi\u0105c", "miesi\u0105ce", "miesi\u0119cy", "dzie\u0144 roboczy", "dni robocze",
			"dni roboczych", "dni roboczych", "miesi\u0105c roboczy", "miesi\u0105ce robocze", "miesi\u0119cy roboczych"),

	PORTUGESE("pt", Type.IRREGULAR_PLURAL, "s", "e", false, true, "e", "ms", "segundo", "segundos", "minuto", "minutos", "hora", "horas", "dia",
			"dias", "m\u00ea", "meses", "dia \u00fatil", "dias \u00fateis", "m\u00ea \u00fatil", "meses \u00fateis"),

	RUSSIAN("ru", Type.VERY_IRREGULAR_PLURAL, "", "", false, false, "", "мс", "секунда", "секунды", "секунд", "минута", "минуты", "минут", "час",
			"часа", "часов", "день", "дня", "дней", "месяц", "месяца", "месяцев", "рабочий день", "рабочих дней", "рабочих дня", "рабочих дней",
			"рабочий месяц", "рабочих месяца", "рабочих месяцев"),

	SPANISH("es", Type.PLURAL_MORPHEME, "s", "e", false, false, "", "ms", "segundo", "minuto", "hora", "d\u00eda", "mes", "d\u00eda h\u00e1bil",
			"d\u00edas h\u00e1biles", "mes h\u00e1bil", "meses h\u00e1biles"),
	
	TURKISH("tr", Type.PLURAL_MORPHEME, "", "", false, false, "", "ms", "saniye", "dakika", "saat", "gün", "ay", "is günü",
			"is günü", "is ayi", "is ayi");

	/**
	 * Language code.
	 */
	private String code;

	/**
	 * Type described in {@link Type}.
	 */
	private Type type;

	/**
	 * String representation for a base form of word "millisecond" and
	 * "milliseconds".
	 */
	private String ms;

	/**
	 * String representation for a base form of word "second".
	 */
	private String second;

	/**
	 * String representation for a plural form of word "second".
	 */
	private String seconds;

	/**
	 * String representation for an additional plural form of word "second".
	 */
	private String seconds5AndMore;

	/**
	 * String representation for a base form of word "minute".
	 */
	private String minute;

	/**
	 * String representation for a plural form of word "minute".
	 */
	private String minutes;

	/**
	 * String representation for an additional plural form of word "minute".
	 */
	private String minutes5AndMore;

	/**
	 * String representation for a base form of word "hour".
	 */
	private String hour;

	/**
	 * String representation for a plural form of word "hour".
	 */
	private String hours;

	/**
	 * String representation for an additional plural form of word "hour".
	 */
	private String hours5AndMore;

	/**
	 * String representation for a base form of word "day".
	 */
	private String day;

	/**
	 * String representation for a base form of word "business day".
	 */
	private String businessDay;

	/**
	 * String representation for a plural form of word "day".
	 */
	private String days;

	/**
	 * String representation for an additional plural form of word "day".
	 */
	private String days5AndMore;

	/**
	 * String representation for a plural form of word "business days".
	 */
	private String businessDays1stForm;

	/**
	 * String representation for a plural form of word "business days".
	 */
	private String businessDays2ndForm;

	/**
	 * String representation for a plural form of word "business days".
	 */
	private String businessDays3rdForm;

	/**
	 * String representation for a base form of word "month".
	 */
	private String month;

	/**
	 * String representation for a base form of word "business month".
	 */
	private String businessMonth;

	/**
	 * String representation for a plural form of word "month".
	 */
	private String months;

	/**
	 * String representation for a base form of word "business months".
	 */
	private String businessMonths;

	/**
	 * String representation for an additional plural form of word
	 * "months (5 and more)".
	 */
	private String months5AndMore;

	/**
	 * String representation for an additional plural form of word
	 * "business months (5 and more)".
	 */
	private String businessMonths5AndMore;

	/**
	 * Flag for not appending plural suffix to months
	 */
	private boolean doNotAppendPluralSuffixToMonths;

	/**
	 * Suffix used in plural morpheme languages.
	 */
	private String pluralMorphemeSuffix;

	/**
	 * Interfix user in plural morpheme languages.
	 */
	private String pluralMorphemeInterfix;

	/**
	 * Flag for using commas between time frames.
	 */
	boolean useCommasBetween;

	/**
	 * Word meaning 'and'.
	 */
	String andWord;

	// Constructors

	/**
	 * Constructs a TimeDifferenceCalculator.
	 * 
	 * @param type
	 *            one of {@link Type}
	 * @param pluralMorphemeSuffix
	 *            plural morpheme suffix
	 * @param pluralMorphemeInterfix
	 *            plural morpheme interfix
	 * @param doNotAppendPluralSuffixToMonths
	 *            if true it does not append plural form to months
	 * @param useCommasBetween
	 *            use commas between time frames without the last one
	 * @param andWord
	 *            word that stands for "and" before the last timeframe
	 * @param timeFrameNames
	 *            names of time frames in a specific language
	 * @throws IllegalArgumentException
	 *             if input parameters are not correct
	 */
	TimeDifferenceCalculator(String code, Type type, String pluralMorphemeSuffix, String pluralMorphemeInterfix,
			boolean doNotAppendPluralSuffixToMonths, boolean useCommasBetween, String andWord, String... timeFrameNames)
			throws IllegalArgumentException {

		if (code != null && code.length() == 2) {
			this.code = code;
		}

		if (pluralMorphemeInterfix == null) {
			throw new IllegalArgumentException("pluralMorphemeInterfix is null");
		}

		if (pluralMorphemeSuffix == null) {
			throw new IllegalArgumentException("pluralMorphemeSuffix is null");
		}

		this.type = type;
		this.doNotAppendPluralSuffixToMonths = doNotAppendPluralSuffixToMonths;
		this.pluralMorphemeSuffix = pluralMorphemeSuffix;
		this.pluralMorphemeInterfix = pluralMorphemeInterfix;
		this.useCommasBetween = useCommasBetween;
		this.andWord = andWord;

		if (timeFrameNames == null || timeFrameNames.length == 0) {
			throw new IllegalArgumentException("timeFrameNames is empty");
		}

		switch (type) {
		case PLURAL_MORPHEME:
			prepareFormsForPluralMorpheme(timeFrameNames);
			break;
		case IRREGULAR_PLURAL:
			prepareFormsForIrregularPlural(timeFrameNames);
			break;
		case VERY_IRREGULAR_PLURAL:
			prepareFormsForVeryIrregularPlural(timeFrameNames);
			break;
		}
	}

	private void prepareFormsForVeryIrregularPlural(String... timeFrameNames) {
		if (timeFrameNames.length != this.type.getNumberOfTimeFrameNames()) {
			throw new IllegalArgumentException("Length of timeFrameNames for " + Type.VERY_IRREGULAR_PLURAL + " must be "
					+ this.type.getNumberOfTimeFrameNames() + " but is " + timeFrameNames.length);
		} else {
			assignVeryIrregularPluralForms(timeFrameNames);
		}
	}

	private void assignVeryIrregularPluralForms(String... timeFrameNames) {
		for (int i = 0; i < timeFrameNames.length; i++) {
			final String frameName = timeFrameNames[i];
			if (frameName == null || frameName.length() == 0) {
				throw new IllegalArgumentException("timeFrameNames[" + i + "] is empty");
			} else {
				assignVeryIrregularPluralForm(i, frameName);
			}
		}
	}

	private void assignVeryIrregularPluralForm(int i, String frameName) {
		switch (i) {
		case 0:
			ms = frameName;
			break;
		case 1:
			second = frameName;
			break;
		case 2:
			seconds = frameName;
			break;
		case 3:
			seconds5AndMore = frameName;
			break;
		case 4:
			minute = frameName;
			break;
		case 5:
			minutes = frameName;
			break;
		case 6:
			minutes5AndMore = frameName;
			break;
		case 7:
			hour = frameName;
			break;
		case 8:
			hours = frameName;
			break;
		case 9:
			hours5AndMore = frameName;
			break;
		case 10:
			day = frameName;
			break;
		case 11:
			days = frameName;
			break;
		case 12:
			days5AndMore = frameName;
			break;
		case 13:
			month = frameName;
			break;
		case 14:
			months = frameName;
			break;
		case 15:
			months5AndMore = frameName;
			break;
		case 16:
			businessDay = frameName;
			break;
		case 17:
			businessDays1stForm = frameName;
			break;
		case 18:
			businessDays2ndForm = frameName;
			break;
		case 19:
			businessDays3rdForm = frameName;
			break;
		case 20:
			businessMonth = frameName;
			break;
		case 21:
			businessMonths = frameName;
			break;
		case 22:
			businessMonths5AndMore = frameName;
			break;
		default:
			break;
		}
	}

	private void prepareFormsForIrregularPlural(String... timeFrameNames) {
		if (timeFrameNames.length != this.type.getNumberOfTimeFrameNames()) {
			throw new IllegalArgumentException("Length of timeFrameNames for " + Type.IRREGULAR_PLURAL + " must be "
					+ this.type.getNumberOfTimeFrameNames() + " but is " + timeFrameNames.length);
		} else {
			assignIrregularPluralForms(timeFrameNames);
		}
	}

	private void assignIrregularPluralForms(String... timeFrameNames) throws IllegalArgumentException {
		for (int i = 0; i < timeFrameNames.length; i++) {
			final String frameName = timeFrameNames[i];

			if (frameName == null || frameName.isEmpty()) {
				throw new IllegalArgumentException("timeFrameNames[" + i + "] is empty");
			} else {
				assignIrregularPluralForm(i, frameName);
			}
		}
	}

	private void assignIrregularPluralForm(int i, String timeFrameName) {
		switch (i) {
		case 0:
			ms = timeFrameName;
			break;
		case 1:
			second = timeFrameName;
			break;
		case 2:
			seconds = timeFrameName;
			break;
		case 3:
			minute = timeFrameName;
			break;
		case 4:
			minutes = timeFrameName;
			break;
		case 5:
			hour = timeFrameName;
			break;
		case 6:
			hours = timeFrameName;
			break;
		case 7:
			day = timeFrameName;
			break;
		case 8:
			days = timeFrameName;
			break;
		case 9:
			month = timeFrameName;
			break;
		case 10:
			months = timeFrameName;
			break;
		case 11:
			businessDay = timeFrameName;
			break;
		case 12:
			businessDays1stForm = timeFrameName;
			break;
		case 13:
			businessMonth = timeFrameName;
			break;
		case 14:
			businessMonths = timeFrameName;
			break;
		default:
			break;
		}
	}

	private void prepareFormsForPluralMorpheme(String... timeFrameNames) {
		if (timeFrameNames.length != this.type.getNumberOfTimeFrameNames()) {
			throw new IllegalArgumentException("Length of timeFrameNames for " + Type.PLURAL_MORPHEME + " must be "
					+ this.type.getNumberOfTimeFrameNames() + " but is " + timeFrameNames.length);
		} else {
			assignPluralMorphemeForms(timeFrameNames);
		}
	}

	private void assignPluralMorphemeForms(String... timeFrameNames) {
		for (int i = 0; i < timeFrameNames.length; i++) {
			if (timeFrameNames[i] == null || timeFrameNames[i].length() == 0) {
				throw new IllegalArgumentException("timeFrameNames[" + i + "] is empty");
			} else {
				assignPluralMorphemeForm(i, timeFrameNames[i]);
			}
		}
	}

	private void assignPluralMorphemeForm(int i, String timeFrameName) {
		switch (i) {
		case 0:
			ms = timeFrameName;
			break;
		case 1:
			second = timeFrameName;
			break;
		case 2:
			minute = timeFrameName;
			break;
		case 3:
			hour = timeFrameName;
			break;
		case 4:
			day = timeFrameName;
			break;
		case 5:
			month = timeFrameName;
			break;
		case 6:
			businessDay = timeFrameName;
			break;
		case 7:
			businessDays1stForm = timeFrameName;
			break;
		case 8:
			businessMonth = timeFrameName;
			break;
		case 9:
			businessMonths = timeFrameName;
			break;
		default:
			break;
		}
	}

	/**
	 * Returns a human readable time difference between two time stamps. If the
	 * difference can be divided by 1000, it does not contain part with
	 * milliseconds.
	 * 
	 * @param timeDifferenceContext
	 *            contain required parameters
	 * 
	 * @return String representation of a difference in time between endTime and
	 *         startTime
	 */
	public String getTimeDifferenceAsString(TimeDifferenceContext timeDifferenceContext) {
		Map<String, String> customValues = timeDifferenceContext.getCustomValues();
		StringBuffer buffer = new StringBuffer("");

		TimeDifferenceCalculationStrategy calculationStrategy;
		if (timeDifferenceContext.isOnlyBusinessDays()) {
			calculationStrategy = new BusinessDaysOnlyTimeDifferenceCalculationStrategy();
		} else {
			calculationStrategy = new DefaultTimeDifferenceCalculationStrategy();
		}

		long diff = calculationStrategy.calculateTimeDifference(timeDifferenceContext.getStartTime(), timeDifferenceContext.getEndTime());

		if (diff % Constants.ONE_SECOND_IN_MILLISECONDS != 0) {
			if (diff > Constants.ONE_SECOND_IN_MILLISECONDS) {
				buffer.append(" ");
			}
			buffer.append((diff % Constants.ONE_SECOND_IN_MILLISECONDS));
			buffer.append(" " + ms);
		}
		if (diff < Constants.ONE_SECOND_IN_MILLISECONDS) {
			return buffer.toString().trim();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(diff);

		if (customValues == null && timeDifferenceContext.isBusinessDaysInString()) {
			customValues = new HashMap<String, String>();
			customValues.put("day", businessDay);
			customValues.put("days", businessDays1stForm);
			customValues.put("businessDays2ndForm", businessDays2ndForm);
			customValues.put("businessDays3rdForm", businessDays3rdForm);
			customValues.put("month", businessMonth);
			customValues.put("months", businessMonths);
			customValues.put("businessMonths5AndMore", businessMonths5AndMore);
		}

		prependInBuffer(buffer, getStringRepresentationOfValue(cal, Calendar.SECOND, customValues), timeDifferenceContext.isOmitTailingZeroes());

		if (diff < Constants.ONE_MINUTE_IN_MILLISECONDS) {
			return buffer.toString().trim();
		}

		prependInBuffer(buffer, getStringRepresentationOfValue(cal, Calendar.MINUTE, customValues), timeDifferenceContext.isOmitTailingZeroes());

		if (diff < Constants.ONE_HOUR_IN_MILLISECONDS) {
			return applyCommasAndAndWord(buffer).toString().trim();
		}
		cal.add(Calendar.HOUR_OF_DAY, -1);

		prependInBuffer(buffer, getStringRepresentationOfValue(cal, Calendar.HOUR_OF_DAY, customValues), timeDifferenceContext.isOmitTailingZeroes());

		if (diff < Constants.ONE_DAY_IN_MILLISECONDS) {
			return applyCommasAndAndWord(buffer).toString().trim();
		}
		cal.add(Calendar.DATE, -1);
		prependInBuffer(buffer, getStringRepresentationOfValue(cal, Calendar.DATE, customValues), timeDifferenceContext.isOmitTailingZeroes());

		long currentMonthInMillis = Constants.getActualMonthInMillis(cal);

		if (diff < currentMonthInMillis) {
			return applyCommasAndAndWord(buffer).toString().trim();
		}
		prependInBuffer(buffer, getStringRepresentationOfValue(cal, Calendar.MONTH, customValues), timeDifferenceContext.isOmitTailingZeroes());

		return applyCommasAndAndWord(buffer).toString().trim();
	}

	private StringBuffer applyCommasAndAndWord(final StringBuffer buffer) {
		if (!this.useCommasBetween) {
			return buffer;
		}
		StringBuffer output = new StringBuffer();

		String helpString = buffer.toString().replaceAll("([0-9]+) ([A-z\u00ea\u00fa ]+)", "$1-$2");
		helpString = helpString.replaceAll("([A-z\u00ea\u00fa ]+) ([0-9]+)", "$1-$2");

		String[] timeFrames = helpString.split("-");
		for (int i = 0; i < timeFrames.length; i = i + 2) {
			String timeFrame = timeFrames[i] + " " + timeFrames[i + 1];
			if (i == timeFrames.length - 2 && timeFrames.length > 2) {
				output.append(" " + andWord + " ");
			}
			output.append(timeFrame);
			if (i < timeFrames.length - 4) {
				output.append(", ");
			}
		}
		return output;
	}

	private void prependInBuffer(StringBuffer buffer, String part, boolean omitTailingZeroes) {
		if (!omitTailingZeroes || !part.startsWith("0 ")) {
			buffer.insert(0, part);
		}
	}

	/**
	 * Returns a human readable representation of an atom value (ie. hour,
	 * minute, etc.).
	 * 
	 * @param cal
	 *            instance of {@link java.util.Calendar}
	 * @param timeFrame
	 *            int value - it can be one of the {@link java.util.Calendar}
	 *            constants:<br/>
	 *            <ul>
	 *            <li>Calendar.MONTH</li>
	 *            <li>Calendar.DATE</li>
	 *            <li>Calendar.HOUR_OF_DAY</li>
	 *            <li>Calendar.MINUTE</li>
	 *            <li>Calendar.SECOND</li>
	 *            </ul>
	 * @return String representation of a given calendar and time frame.
	 * @throws NumberFormatException
	 *             exception when timeFrame is not able to parse
	 */
	private String getStringRepresentationOfValue(Calendar cal, int timeFrame, Map<String, String> customValues) throws NumberFormatException {
		String buff = "" + cal.get(timeFrame);
		int intValue = Integer.parseInt(buff);

		switch (type) {
		case PLURAL_MORPHEME:
			return getStringRepresentationForPluralMorpheme(timeFrame, intValue, customValues);
		case IRREGULAR_PLURAL:
			return getStringRepresentationForIrregularPlural(timeFrame, intValue, customValues);
		case VERY_IRREGULAR_PLURAL:
			return getStringRepresentationForVeryIrregularPlural(timeFrame, intValue, customValues);
		default:
		}
		return "";
	}

	private String getStringRepresentationForVeryIrregularPlural(int timeFrame, int intValue, Map<String, String> customValues) {
		if (timeFrame == Calendar.DATE && intValue > 1) {

			if (customValues == null) {
				if ("RUSSIAN".equals(this.name())) {

					if (intValue > 1 && intValue <= 4) {
						return intValue + " " + getCustomOrDefaultValue(customValues, "days", days) + " ";
					} else if (intValue > 4 && intValue < 22) {
						return intValue + " " + getCustomOrDefaultValue(customValues, "days", days5AndMore) + " ";
					}

					int lastDigit = intValue % 10;

					if (lastDigit > 1 && lastDigit <= 4) {
						return intValue + " " + getCustomOrDefaultValue(customValues, "days", days) + " ";
					} else {
						return intValue + " " + getCustomOrDefaultValue(customValues, "days", days5AndMore) + " ";
					}
				}
				return intValue + " " + getCustomOrDefaultValue(customValues, "days", days) + " ";
			}

			if ("CZECH".equals(this.name())) {
				if (intValue > 1 && intValue < 5) {
					return intValue + " " + getCustomOrDefaultValue(customValues, "days", days) + " ";
				}
				if (intValue > 4 && intValue < 9) {
					return intValue + " " + getCustomOrDefaultValue(customValues, "businessDays2ndForm", days) + " ";
				}
				if (intValue == 9) {
					return intValue + " " + getCustomOrDefaultValue(customValues, "businessDays3rdForm", days) + " ";
				}
				return intValue + " " + getCustomOrDefaultValue(customValues, "businessDays2ndForm", days) + " ";
			} else if ("POLISH".equals(this.name())) {
				if (intValue > 1 && intValue < 5) {
					return intValue + " " + getCustomOrDefaultValue(customValues, "days", days) + " ";
				}
				if (intValue > 4) {
					return intValue + " " + getCustomOrDefaultValue(customValues, "businessDays2ndForm", days) + " ";
				}
			} else if ("RUSSIAN".equals(this.name())) {

				if (intValue > 1 && intValue <= 4) {
					return intValue + " " + getCustomOrDefaultValue(customValues, "businessDays2ndForm", days) + " ";
				} else if (intValue > 4 && intValue < 22) {
					return intValue + " " + getCustomOrDefaultValue(customValues, "businessDays3rdForm", days) + " ";
				}

				int lastDigit = intValue % 10;

				if (lastDigit > 1 && lastDigit <= 4) {
					return intValue + " " + getCustomOrDefaultValue(customValues, "businessDays2ndForm", days) + " ";
				} else {
					return intValue + " " + getCustomOrDefaultValue(customValues, "businessDays3rdForm", days) + " ";
				}

			}
		}

		int suffixIntValue = countSuffixValue(intValue);

		if (suffixIntValue == 1) {
			switch (timeFrame) {
			case Calendar.SECOND:
				return intValue + " " + getCustomOrDefaultValue(customValues, "second", second);
			case Calendar.MINUTE:
				return intValue + " " + getCustomOrDefaultValue(customValues, "minute", minute) + " ";
			case Calendar.HOUR_OF_DAY:
				return intValue + " " + getCustomOrDefaultValue(customValues, "hour", hour) + " ";
			case Calendar.DATE:
				return intValue + " " + getCustomOrDefaultValue(customValues, "day", day) + " ";
			case Calendar.MONTH:
				return intValue + " " + getCustomOrDefaultValue(customValues, "month", month) + " ";
			}

		} else if (1 < suffixIntValue && suffixIntValue < 5) {
			switch (timeFrame) {
			case Calendar.SECOND:
				return intValue + " " + getCustomOrDefaultValue(customValues, "seconds", seconds);
			case Calendar.MINUTE:
				return intValue + " " + getCustomOrDefaultValue(customValues, "minutes", minutes) + " ";
			case Calendar.HOUR_OF_DAY:
				return intValue + " " + getCustomOrDefaultValue(customValues, "hours", hours) + " ";
			case Calendar.MONTH:
				return intValue + " " + getCustomOrDefaultValue(customValues, "months", months) + " ";
			}
		} else {
			switch (timeFrame) {
			case Calendar.SECOND:
				return intValue + " " + getCustomOrDefaultValue(customValues, "seconds5AndMore", seconds5AndMore);
			case Calendar.MINUTE:
				return intValue + " " + getCustomOrDefaultValue(customValues, "minutes5AndMore", minutes5AndMore) + " ";
			case Calendar.HOUR_OF_DAY:
				return intValue + " " + getCustomOrDefaultValue(customValues, "hours5AndMore", hours5AndMore) + " ";
			case Calendar.MONTH:
				return intValue + " " + getCustomOrDefaultValue(customValues, "months5AndMore", months5AndMore) + " ";
			}
		}
		return "";
	}

	private int countSuffixValue(int intValue) {
		int suffixIntValue;
		if (10 < intValue && intValue < 20) {
			suffixIntValue = 5;
		} else {
			suffixIntValue = Integer.parseInt(("" + intValue).substring(("" + intValue).length() - 1));
			if (intValue > 20 && "1".equals("" + suffixIntValue)) {
				suffixIntValue = 5;
			}
		}
		return suffixIntValue;
	}

	private String getStringRepresentationForIrregularPlural(int timeFrame, int intValue, Map<String, String> customValues) {
		if (intValue > 1 || intValue == 0) {
			switch (timeFrame) {
			case Calendar.SECOND:
				return intValue + " " + getCustomOrDefaultValue(customValues, "seconds", seconds);
			case Calendar.MINUTE:
				return intValue + " " + getCustomOrDefaultValue(customValues, "minutes", minutes) + " ";
			case Calendar.HOUR_OF_DAY:
				return intValue + " " + getCustomOrDefaultValue(customValues, "hours", hours) + " ";
			case Calendar.DATE:
				return intValue + " " + getCustomOrDefaultValue(customValues, "days", days) + " ";
			case Calendar.MONTH:
				return intValue + " " + getCustomOrDefaultValue(customValues, "months", months) + " ";
			}
		} else {
			switch (timeFrame) {
			case Calendar.SECOND:
				return intValue + " " + getCustomOrDefaultValue(customValues, "second", second);
			case Calendar.MINUTE:
				return intValue + " " + getCustomOrDefaultValue(customValues, "minute", minute) + " ";
			case Calendar.HOUR_OF_DAY:
				return intValue + " " + getCustomOrDefaultValue(customValues, "hour", hour) + " ";
			case Calendar.DATE:
				return intValue + " " + getCustomOrDefaultValue(customValues, "day", day) + " ";
			case Calendar.MONTH:
				return intValue + " " + getCustomOrDefaultValue(customValues, "month", month) + " ";
			}
		}
		return "";
	}

	private String getStringRepresentationForPluralMorpheme(int timeFrame, int intValue, Map<String, String> customValues) {
		switch (timeFrame) {
		case Calendar.SECOND:
			return applyProperPluralMorphemeSuffix(intValue, getCustomOrDefaultValue(customValues, "second", second));
		case Calendar.MINUTE:
			return applyProperPluralMorphemeSuffix(intValue, getCustomOrDefaultValue(customValues, "minute", minute)) + " ";
		case Calendar.HOUR_OF_DAY:
			return applyProperPluralMorphemeSuffix(intValue, getCustomOrDefaultValue(customValues, "hour", hour)) + " ";
		case Calendar.DATE:
			if (intValue > 1) {
				String value = getCustomOrDefaultValue(customValues, "days", days);
				value = (isBlank(value)) ? getCustomOrDefaultValue(customValues, "day", day) : value;
				return applyProperPluralMorphemeSuffix(intValue, value) + " ";
			} else {
				return applyProperPluralMorphemeSuffix(intValue, getCustomOrDefaultValue(customValues, "day", day)) + " ";
			}
		case Calendar.MONTH:
			if (intValue > 1) {
				String value = getCustomOrDefaultValue(customValues, "months", months);
				value = (isBlank(value)) ? getCustomOrDefaultValue(customValues, "month", month) : value;
				return applyProperPluralMorphemeSuffix(intValue, value) + " ";
			} else {
				return applyProperPluralMorphemeSuffix(intValue, getCustomOrDefaultValue(customValues, "month", month)) + " ";
			}
		}
		return "";
	}

	private boolean isBlank(String value) {
		return (value == null || value == "");
	}

	private String getCustomOrDefaultValue(Map<String, String> customValues, String key, String defaultValue) {
		if (customValues != null && customValues.get(key) != null) {
			return customValues.get(key);
		}
		return defaultValue;
	}

	/**
	 * Returns a proper plural morpheme suffix. If {@link
	 * this.doNotAppendPluralSuffixToMonths} is set and time frame is equal to
	 * "month", it passes the default output.
	 * 
	 * @param value
	 *            value of time frame
	 * @param baseForm
	 *            base form of time frame
	 * @return plural morpheme suffix
	 */
	private String applyProperPluralMorphemeSuffix(int value, String baseForm) {
		if (baseForm != null) {
			if (baseForm.contains(" ")) {
				// business days / business months
				return value + " " + baseForm;
			}
			if (value > 1 || value == 0) {

				if (doNotAppendPluralSuffixToMonths && month.equals(baseForm)) {
					return value + " " + baseForm;
				} else {
					if (baseForm.endsWith(pluralMorphemeSuffix)) {
						return value + " " + baseForm + pluralMorphemeInterfix + pluralMorphemeSuffix;
					} else {
						return value + " " + baseForm + pluralMorphemeSuffix;
					}
				}
			} else {
				return value + " " + baseForm;
			}
		}
		return "";
	}

	// Getters and setters
	/**
	 * Returns a type of a calculator.
	 * 
	 * @return type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Returns a language code of a calculator.
	 * 
	 * @return type
	 */
	public String code() {
		return code;
	}

}
