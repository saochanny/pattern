package com.channy.pattern.core.mediator.handler;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class MessageBus {
  private final Map<Class<?>, MessageHandler<?>> handlers = new HashMap<>();

  public <T> void registerHandler(Class<T> messageType, MessageHandler<T> handler) {
    handlers.put(messageType, handler);
  }

  @SuppressWarnings("unchecked")
  public <T> void send(T message) {
    MessageHandler<T> handler = (MessageHandler<T>) handlers.get(message.getClass());
    if (handler != null) {
      handler.handle(message);
    } else {
      throw new IllegalArgumentException(
          "No handler found for message type: " + message.getClass());
    }
  }
}
