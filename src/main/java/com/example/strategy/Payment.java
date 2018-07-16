package com.example.strategy;

/**
 * Created by James on 2018/7/15.
 */
public interface Payment {

    public PayState pay(String uid, double amount);

}
