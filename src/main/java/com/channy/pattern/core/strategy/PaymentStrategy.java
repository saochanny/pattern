package com.channy.pattern.core.strategy;

public interface PaymentStrategy<T, R> {
  boolean supports(T request);

  R pay(T request);
}
