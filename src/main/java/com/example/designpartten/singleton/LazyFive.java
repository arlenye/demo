package com.example.designpartten.singleton;

import java.io.Serializable;

/**
 * Created by wb-yejian on 2018/7/12.
 */
public class LazyFive implements Serializable{

    private static volatile LazyFive instance = null;
    private LazyFive(){}
    public static LazyFive getInstance(){
        if(instance == null){
            synchronized(LazyFive.class){
                if (instance == null) {
                    instance =new LazyFive();
                }
            }
        }
        return instance;
    }

    /**
     * 解决序列化出不同对象问题
     */
    private Object readResolve(){
        return instance;
    }
}
