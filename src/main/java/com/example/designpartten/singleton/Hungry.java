package com.example.designpartten.singleton;

/**
 * Created by wb-yejian on 2018/7/12.
 */
public class Hungry {
    private static Hungry instance= new Hungry();
    private Hungry(){}
    public static Hungry getInstance(){
        return instance;
    }
}
