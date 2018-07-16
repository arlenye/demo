package com.example.strategy;

/**
 * Created by James on 2018/7/15.
 */
public class WeichatPay implements Payment{
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("使用微信支付");
        System.out.println("查询账户余额，开始扣款");

        return new PayState(1001,"支付成功",amount+"");
    }
}
