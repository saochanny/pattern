package com.channy.pattern.controller;

import com.channy.pattern.model.PaymentRequest;
import com.channy.pattern.model.PaymentResponse;
import com.channy.pattern.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

  private final PaymentService paymentService;

  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @PostMapping("/process")
  public PaymentResponse processPayment(@RequestBody PaymentRequest request) {
    return paymentService.processPayment(request);
  }
}
