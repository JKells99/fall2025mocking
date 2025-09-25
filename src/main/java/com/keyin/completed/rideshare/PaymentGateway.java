package com.keyin.completed.rideshare;

public interface PaymentGateway {
    boolean processPayment(String rider, double amount);
}
