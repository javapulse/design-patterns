package com.javapulse;

import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) {
		PaymentMethodFactory paymentMethodFactory = new PaymentMethodFactory();

		PaymentMethod creditCard = paymentMethodFactory.createPaymentMethod("CREDIT_CARD");
		creditCard.processPayment(new BigDecimal("50.0"));

		PaymentMethod payPal = paymentMethodFactory.createPaymentMethod("PAYPAL");
		payPal.processPayment(new BigDecimal("100.0"));
	}
}