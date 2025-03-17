package com.channy.pattern.service;

import com.channy.pattern.core.mediator.handler.MessageBus;
import com.channy.pattern.core.mediator.handler.impl.OrderMessageHandler;
import com.channy.pattern.core.mediator.handler.impl.UserMessageHandler;
import com.channy.pattern.model.OrderMessage;
import com.channy.pattern.model.UserMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  private final MessageBus messageBus;

  public MessageService(
      MessageBus messageBus, UserMessageHandler userHandler, OrderMessageHandler orderHandler) {
    this.messageBus = messageBus;

    // Register handlers
    this.messageBus.registerHandler(UserMessage.class, userHandler);
    this.messageBus.registerHandler(OrderMessage.class, orderHandler);
  }

  public void sendMessage(Object message) {
    messageBus.send(message);
  }
}
