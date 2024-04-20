package com.javapulse;

public class PaymentMethodFactory {
	public PaymentMethod createPaymentMethod(String method) {
		if (method.equalsIgnoreCase("CREDIT_CARD")) {
			return new CreditCardPayment();
		} else if (method.equalsIgnoreCase("PAYPAL")) {
			return new PaypalPayment();
		}
		return null; // Or throw an exception for unknown payment methods
	}
}
