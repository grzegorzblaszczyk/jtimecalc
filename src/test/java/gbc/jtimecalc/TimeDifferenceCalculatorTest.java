package gbc.jtimecalc;

import gbc.jtimecalc.TimeDifferenceCalculator;

import org.junit.Test;

/**
 * Test interface for {@link TimeDifferenceCalculator}.
 *
 * @author grzegorz@blaszczyk-consulting.com
 */
public interface TimeDifferenceCalculatorTest {
  @Test
  void shouldReturnOneMillisecond();

  @Test
  void shouldReturnOneSecond();

  @Test
  void shouldReturnOneSecondFromStaticTime();

  @Test
  void shouldReturnTenSeconds();

  @Test
  void shouldReturn53Seconds();

  @Test
  void shouldReturnOneMinuteAndTwentySeconds();

  @Test
  void shouldReturnOneHour();

  @Test
  void shouldReturnOneHourTenMinutesAndTwentyThreeSeconds();

  @Test
  void shouldReturn11HoursTenMinutesAndTwentyThreeSeconds();

  @Test
  void shouldReturn1Day();

  @Test
  void shouldReturn1DayOneMinute();

  @Test
  void shouldReturn2Days11HoursTenMinutesAndTwentyThreeSeconds();

  @Test
  void shouldReturn2Days11HoursTenMinutesTwentySecondsAndThreeMilliseconds();

  @Test
  void shouldReturn1Month5Days11HoursTenMinutesTwentySecondsAndThreeMilliseconds();

  @Test
  void shouldReturn30Days1Hour0Minutes0seconds();

  @Test
  void shouldReturn2Months3Days0Hours0Minutes0seconds();

  @Test
  void shouldReturn9Months0Days0Hours0Minutes0seconds();
  
  @Test
  void shouldReturnTwoSeconds();

  @Test
  void shouldReturnThreeSeconds();

  @Test
  void shouldReturnFourSeconds();

  @Test
  void shouldReturnFiveSeconds();

  @Test
  void shouldReturnSixSeconds();

  @Test
  void shouldReturnSevenSeconds();

  @Test
  void shouldReturnEightSeconds();

  @Test
  void shouldReturnNineSeconds();

  @Test
  void shouldReturn21Seconds();

  @Test
  void shouldReturn51Seconds();

  @Test
  void shouldReturn59Minutes59Seconds();

  @Test
  void shouldReturn6Days();

  @Test
  void shouldReturn12Days();

  @Test
  void shouldReturn24Days();

  @Test
  void shouldReturn25Days();

  @Test
  void shouldReturn24Minutes();

  @Test
  void shouldReturn22Hours();
  
  @Test
  void shouldReturn30DaysWithoutTailingZeroes();

  @Test
  void shouldReturn1BusinessDayWithoutTailingZeroes();
  
  @Test
  void shouldReturn2BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn3BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn4BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn5BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn6BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn7BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn8BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn9BusinessDaysWithoutTailingZeroes();
  
  @Test
  void shouldReturn10BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn11BusinessDaysWithoutTailingZeroes();
  
  @Test
  void shouldReturn12BusinessDaysWithoutTailingZeroes();
  
  @Test
  void shouldReturn13BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn14BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn15BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn16BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn17BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn18BusinessDaysWithoutTailingZeroes();
  
  @Test
  void shouldReturn19BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn20BusinessDaysWithoutTailingZeroes();
  
  @Test
  void shouldReturn21BusinessDaysWithoutTailingZeroes();
  
  @Test
  void shouldReturn22BusinessDaysWithoutTailingZeroes();
  
  @Test
  void shouldReturn23BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn24BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn25BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn26BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn27BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn28BusinessDaysWithoutTailingZeroes();
  
  @Test
  void shouldReturn29BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn30BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn31BusinessDaysWithoutTailingZeroes();

  @Test
  void shouldReturn1BusinessMonth20BusinessDaysWithoutTailingZeroes();
}
