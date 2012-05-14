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

import gbc.jtimecalc.TimeDifferenceCalculator;

public class SimpleExample {

	public static void main(String[] args) {
	  
	  // START SNIPPET: usage

		System.out.println("1. Starting operation");
		long startTime = System.currentTimeMillis();

		System.out.println("2. Invoking some time consuming method");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("3. Finishing operation");
		long endTime = System.currentTimeMillis();

		System.out.println("Result:");

		for (TimeDifferenceCalculator calc : TimeDifferenceCalculator.values()) {
			System.out.println(calc + ": \""
					+ calc.getTimeDifferenceAsString(new TimeDifferenceContext(endTime, startTime, false, false,
							null, false))
					+ "\" , type: " + calc.getType());
		}
		
		// END SNIPPET: usage
	}
}
