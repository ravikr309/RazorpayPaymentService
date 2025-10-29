package com.UpStrives.upstrivesPayment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UpStrives.upstrivesPayment.Service.PaymentRazorPayService;

@RestController
@RequestMapping("/api/payments")
public class PaymentRequestController {

  @Autowired
  private PaymentRazorPayService razorpayService;

  @PostMapping("/create-order")
  public String createOrder(@RequestParam int amount) {
    try {
      return razorpayService.createOrder(amount, "INR", "receipt_" + System.currentTimeMillis());
    } catch (Exception e) {
      return "{\"error\":\"" + e.getMessage() + "\"}";
    }
  }
}
