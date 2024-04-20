package com.javapulse;

import java.math.BigDecimal;

public class PaypalPayment implements PaymentMethod {
	@Override
	public void processPayment(BigDecimal amount) {
		System.out.println("Processing paypal payment for amount: " + amount);
	}
}
