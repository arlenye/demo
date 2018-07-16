package com.example.designpartten.singleton;

/**
 * Created by wb-yejian on 2018/7/12.
 */
public class LazyTwo {
    private static LazyTwo instance = null;
    private LazyTwo(){}
    public static synchronized LazyTwo getInstance(){
        if(instance == null){
            instance =new LazyTwo();
        }
        return instance;
    }
}
