package com.channy.pattern.core.strategy.concret;

import com.channy.pattern.constant.enums.PaymentType;
import com.channy.pattern.model.PaymentRequest;
import com.channy.pattern.model.PaymentResponse;
import com.channy.pattern.core.strategy.PaymentStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CashPaymentStrategy implements PaymentStrategy<PaymentRequest, PaymentResponse> {

  @Override
  public boolean supports(PaymentRequest request) {
    return PaymentType.CASH.name().equalsIgnoreCase(request.getPaymentType());
  }

  @Override
  public PaymentResponse pay(PaymentRequest request) {
    log.info("Processing cash payment for {}", request.getAmount());
    return new PaymentResponse("Cash Payment Successful", true);
  }
}
