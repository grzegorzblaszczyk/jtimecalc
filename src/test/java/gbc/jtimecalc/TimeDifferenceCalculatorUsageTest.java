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

package gbc.jtimecalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import junit.framework.Assert;
import gbc.jtimecalc.TimeDifferenceCalculator;

import org.junit.Test;

/**
 * Test of usage for {@link TimeDifferenceCalculator}.
 *
 * @author grzegorz@blaszczyk-consulting.com
 */
public class TimeDifferenceCalculatorUsageTest {
 
  private static final String UNKNOWN_CODE = "unknown";

@Test
  public void shouldThrowExceptionWithLanguageCodeInMessageWhenUnknownLanguageGiven() {
	  try {
		  TimeDifferenceCalculator.getInstance(UNKNOWN_CODE);
		  fail("Should have failed with unknown code...");
	  } catch (IllegalArgumentException e) {
		  String message = e.getMessage();
		  assertEquals("Language with code '" + UNKNOWN_CODE + "' is not yet supported.", message);
	  }
  }

}