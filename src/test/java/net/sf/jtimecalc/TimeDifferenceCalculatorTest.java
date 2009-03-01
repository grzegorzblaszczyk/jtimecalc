package net.sf.jtimecalc;

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

}
