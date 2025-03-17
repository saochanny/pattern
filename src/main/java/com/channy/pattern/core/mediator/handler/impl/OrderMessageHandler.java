package com.channy.pattern.core.mediator.handler.impl;

import com.channy.pattern.core.mediator.handler.MessageHandler;
import com.channy.pattern.model.OrderMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderMessageHandler implements MessageHandler<OrderMessage> {
  @Override
  public void handle(OrderMessage message) {
    log.info(
        "Processing Order Message: {} - Amount: {}", message.getOrderId(), message.getAmount());
  }
}
