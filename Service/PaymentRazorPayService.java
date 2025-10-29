package com.UpStrives.upstrivesPayment.Service;

import org.json.JSONObject;
import com.razorpay.RazorpayClient;
import com.razorpay.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PaymentRazorPayService {

  @Value("${razorpay.key.id}")
  private String razorpayKeyId;

  @Value("${razorpay.key.secret}")
  private String razorpayKeySecret;

  public String createOrder(int amount, String currency, String receipt) throws Exception {
    RazorpayClient client = new RazorpayClient(razorpayKeyId, razorpayKeySecret);

    JSONObject orderRequest = new JSONObject();
    orderRequest.put("amount", amount * 100); // Always amount in paise
    orderRequest.put("currency", currency);
    orderRequest.put("receipt", receipt);

    Order order = client.orders.create(orderRequest);
    return order.toString();
  }

}
