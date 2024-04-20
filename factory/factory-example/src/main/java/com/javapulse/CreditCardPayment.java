package com.javapulse;

import java.math.BigDecimal;

public class CreditCardPayment implements PaymentMethod {
	@Override
	public void processPayment(BigDecimal amount) {
		System.out.println("Processing credit card payment for amount: " + amount);
	}
}
