package gbc.jtimecalc.strategy.impl;

import gbc.jtimecalc.Constants;
import gbc.jtimecalc.strategy.TimeDifferenceCalculationStrategy;

public class BusinessDaysOnlyTimeDifferenceCalculationStrategy implements
		TimeDifferenceCalculationStrategy {

	@Override
	public long calculateTimeDifference(long startTime, long endTime) {
		if (endTime - startTime < Constants.ONE_DAY_IN_MILLISECONDS) {
			return endTime - startTime;
		} else {
			//TODO: implement me
			return endTime - startTime;
		}
	}

}
