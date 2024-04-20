package com.javapulse;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ThreadSafeInterestCalculator {

	private static volatile ThreadSafeInterestCalculator instance;

	private ThreadSafeInterestCalculator() {
	}

	// Double-checked locking for thread safety
	public static ThreadSafeInterestCalculator getInstance() {
		if (instance == null) {
			synchronized (ThreadSafeInterestCalculator.class) {
				if (instance == null) {
					instance = new ThreadSafeInterestCalculator();
				}
			}
		}
		return instance;
	}

	public synchronized BigDecimal calculateSimpleInterest(BigDecimal principal, BigDecimal rate, BigDecimal time) {
		return principal.multiply(rate).multiply(time).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
	}

}
