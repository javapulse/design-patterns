package com.javapulse;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum EnumInterestCalculator {
	INSTANCE;

	public BigDecimal calculateSimpleInterest(BigDecimal principal, BigDecimal rate, BigDecimal time) {
		return principal.multiply(rate).multiply(time).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
	}
}
