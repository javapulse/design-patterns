package com.javapulse;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LazyInterestCalculator {

	private static LazyInterestCalculator instance;

	private LazyInterestCalculator() {
	}

	public static LazyInterestCalculator getInstance() {
		if (instance == null) {
			instance = new LazyInterestCalculator();
		}
		return instance;
	}

	public BigDecimal calculateSimpleInterest(BigDecimal principal, BigDecimal rate, BigDecimal time) {
		return principal.multiply(rate).multiply(time).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
	}

}
