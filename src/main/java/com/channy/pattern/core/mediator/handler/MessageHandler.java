package com.channy.pattern.core.mediator.handler;

public interface MessageHandler<T> {
  void handle(T message);
}
