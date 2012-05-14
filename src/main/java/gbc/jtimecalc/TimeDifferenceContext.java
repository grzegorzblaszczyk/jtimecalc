package gbc.jtimecalc;

import java.util.Map;

/**
 * 
 * TimeDifferenceContext class wraps parameters for TimeDifferenceCalculator.   
 * @author wzywno
 *
 */
public class TimeDifferenceContext {
	private long endTime;
	private long startTime;
	private boolean omitTailingZeroes;
	private boolean onlyBusinessDays;
	private Map<String, String> customValues;
	private boolean businessDaysInString;

	/**
	 * 
	 * * @param endTime end of time period
	 * 
	 * @param startTime
	 *            start of time period
	 * @param omitTailingZeroes
	 *            omit tailing zeroes
	 * @param onlyBusinessDays
	 *            count only business days
	 * @param customValues
	 * @param businessDaysInString return string contain translated "working" word 
	 */
	public TimeDifferenceContext(long endTime, long startTime,
			boolean omitTailingZeroes, boolean onlyBusinessDays,
			Map<String, String> customValues, boolean businessDaysInString) {
		this.endTime = endTime;
		this.startTime = startTime;
		this.omitTailingZeroes = omitTailingZeroes;
		this.onlyBusinessDays = onlyBusinessDays;
		this.customValues = customValues;
		this.businessDaysInString = businessDaysInString;
	}

	public long getEndTime() {
		return endTime;
	}

	public long getStartTime() {
		return startTime;
	}

	public boolean isOmitTailingZeroes() {
		return omitTailingZeroes;
	}

	public boolean isOnlyBusinessDays() {
		return onlyBusinessDays;
	}

	public Map<String, String> getCustomValues() {
		return customValues;
	}

	public boolean isBusinessDaysInString() {
		return businessDaysInString;
	}
}