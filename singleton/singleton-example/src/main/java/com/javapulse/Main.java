package com.javapulse;

import java.awt.*;
import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) {

		/*
		Singleton design pattern is used in core Java classes also
		(for example, java.lang.Runtime, java.awt.Desktop)
		 */
		Desktop desktop = Desktop.getDesktop();

		BigDecimal principal = new BigDecimal("1000");
		BigDecimal rate = new BigDecimal("5");
		BigDecimal time = new BigDecimal("2");

		LazyInterestCalculator interestCalculator = LazyInterestCalculator.getInstance();

		BigDecimal simpleInterest = interestCalculator.calculateSimpleInterest(principal, rate, time);
		System.out.println("Simple Interest: " + simpleInterest);


		BigDecimal simpleInterestWithEnum = EnumInterestCalculator.INSTANCE.calculateSimpleInterest(new BigDecimal(1000), new BigDecimal(5), new BigDecimal(2));
		System.out.println("Simple Interest: " + simpleInterestWithEnum);

	}
}