package com.example.singleton;

import java.io.Serializable;

/**
 * Created by James on 2018/7/12.
 */
public class Seriable implements Serializable{
    private final static Seriable INSTANCE = new Seriable();
    private Seriable(){}
    public static Seriable getInstance(){
        return INSTANCE;
    }

    /**
     * 序列化与反序列化的一个协议，保证一致性，由JVM调用
     * @return
     */
    private Object readResolve(){
        return INSTANCE;
    }
}
