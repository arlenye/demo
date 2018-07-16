package com.example.designpartten.singleton;

/**
 * Created by wb-yejian on 2018/7/12.
 */
public class LazyOne {
    private static LazyOne instance = null;
    private LazyOne(){}
    public static LazyOne getInstance(){
        if(instance == null){
            instance =new LazyOne();
        }
        return instance;
    }
}
