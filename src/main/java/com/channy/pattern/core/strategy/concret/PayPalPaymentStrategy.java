package com.channy.pattern.core.strategy.concret;

import com.channy.pattern.constant.enums.PaymentType;
import com.channy.pattern.model.PaymentRequest;
import com.channy.pattern.model.PaymentResponse;
import com.channy.pattern.core.strategy.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PayPalPaymentStrategy implements PaymentStrategy<PaymentRequest, PaymentResponse> {

  @Override
  public boolean supports(PaymentRequest request) {
    return PaymentType.PAYPAL.name().equalsIgnoreCase(request.getPaymentType());
  }

  @Override
  public PaymentResponse pay(PaymentRequest request) {
    log.info("Processing PayPal payment for {}", request.getAmount());
    return new PaymentResponse("PayPal Payment Successful", true);
  }
}
