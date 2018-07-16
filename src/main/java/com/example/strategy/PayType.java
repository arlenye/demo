package com.example.strategy;

/**
 * Created by James on 2018/7/15.
 */
public enum PayType {
    ALI_PAY(new AliPay()), WEICHAT_PAY(new WeichatPay());

    private Payment payment;

    PayType(Payment payment) {
        this.payment = payment;
    }

    public Payment get() {
        return this.payment;
    }
}
