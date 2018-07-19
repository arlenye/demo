package com.example.designpartten.observer;

/**
 * Created by James on 2018/7/19.
 */
public class Observer {
    public void advice(Event e){
        System.out.println("----触发事件--- \n"+e);
    }
}
