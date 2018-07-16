package com.example.strategy;

/**
 * Created by James on 2018/7/15.
 * spring 中 BeanFactory  ListableFactory.. ,根据用户的配置选择使用哪个工厂模式
 */
public class StrategyTest {

    public static void main(String[] args) {

        //下订单
        Order order = new Order("1","2018031103",1000.55);

        //开始支付
        PayState payState = order.pay(PayType.WEICHAT_PAY);
        System.out.println(payState);
    }
}
