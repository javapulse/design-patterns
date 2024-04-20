package com.javapulse;

import java.math.BigDecimal;

public interface PaymentMethod {

	void processPayment(BigDecimal amount);

}
