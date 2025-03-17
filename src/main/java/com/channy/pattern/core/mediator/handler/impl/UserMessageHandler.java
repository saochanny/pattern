package com.channy.pattern.core.mediator.handler.impl;

import com.channy.pattern.core.mediator.handler.MessageHandler;
import com.channy.pattern.model.UserMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserMessageHandler implements MessageHandler<UserMessage> {
  @Override
  public void handle(UserMessage message) {
    log.info("Processing User Message: {}, {}", message.getUsername(), message.getEmail());
  }
}
