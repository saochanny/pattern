package com.channy.pattern.core.mediator;

import com.channy.pattern.core.mediator.handler.MessageHandler;

public interface Mediator<T> {
  void registerHandler(Class<T> messageType, MessageHandler<T> handler);
  void send(T message);
}

