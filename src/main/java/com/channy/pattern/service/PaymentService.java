package com.channy.pattern.service;

import com.channy.pattern.model.PaymentRequest;
import com.channy.pattern.model.PaymentResponse;
import com.channy.pattern.core.strategy.PaymentStrategy;
import com.channy.pattern.core.strategy.factory.PaymentStrategyFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  private final PaymentStrategyFactory strategyFactory;

  public PaymentService(PaymentStrategyFactory strategyFactory) {
    this.strategyFactory = strategyFactory;
  }

  public PaymentResponse processPayment(PaymentRequest request) {
    PaymentStrategy<PaymentRequest, PaymentResponse> strategy =
        strategyFactory.getStrategy(request);
    return strategy.pay(request);
  }
}
