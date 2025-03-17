package com.channy.pattern.core.strategy.factory;

import com.channy.pattern.model.PaymentRequest;
import com.channy.pattern.model.PaymentResponse;
import com.channy.pattern.core.strategy.PaymentStrategy;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class PaymentStrategyFactory {

  private final Map<String, PaymentStrategy<PaymentRequest, PaymentResponse>> strategyMap;
  private final List<PaymentStrategy<PaymentRequest, PaymentResponse>> strategies;

  public PaymentStrategyFactory(
      Map<String, PaymentStrategy<PaymentRequest, PaymentResponse>> strategyMap,
      List<PaymentStrategy<PaymentRequest, PaymentResponse>> strategies) {
    this.strategyMap = strategyMap;
    this.strategies = strategies;
  }

  public PaymentStrategy<PaymentRequest, PaymentResponse> getStrategy(PaymentRequest request) {
    // 1. Try Map-based lookup (fast O(1))
    PaymentStrategy<PaymentRequest, PaymentResponse> strategy =
        strategyMap.get(request.getPaymentType());
    if (strategy != null) {
      return strategy;
    }
    // 2. Fall back to List-based matching (O(n))
    return strategies.stream()
        .filter(s -> s.supports(request))
        .findFirst()
        .orElseThrow(
            () ->
                new IllegalArgumentException("No strategy found for: " + request.getPaymentType()));
  }
}
