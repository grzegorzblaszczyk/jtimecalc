package gbc.jtimecalc.strategy.impl;

import gbc.jtimecalc.strategy.TimeDifferenceCalculationStrategy;

public class DefaultTimeDifferenceCalculationStrategy implements
		TimeDifferenceCalculationStrategy {

	@Override
	public long calculateTimeDifference(long startTime, long endTime) {
		return endTime - startTime;
	}

}
