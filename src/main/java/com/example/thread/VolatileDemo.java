package com.example.thread;

/**
 * Created by James on 2018/7/22.
 */
public class VolatileDemo {
    //保证线程的可见性
    private static volatile VolatileDemo instance;

    private VolatileDemo(){}

    public static VolatileDemo getInstance(){
        if(instance ==null){
            instance =  new VolatileDemo();
        }
        return instance;
    }
}
