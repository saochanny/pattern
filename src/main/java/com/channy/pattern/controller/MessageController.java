package com.channy.pattern.controller;

import com.channy.pattern.model.OrderMessage;
import com.channy.pattern.model.UserMessage;
import com.channy.pattern.service.MessageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

  private final MessageService messageService;

  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  @PostMapping("/user")
  public String sendUserMessage(@RequestBody UserMessage message) {
    messageService.sendMessage(message);
    return "User message sent!";
  }

  @PostMapping("/order")
  public String sendOrderMessage(@RequestBody OrderMessage message) {
    messageService.sendMessage(message);
    return "Order message sent!";
  }
}
