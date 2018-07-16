package com.example.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by James on 2018/7/12.
 * 注册登记式： 每使用一次，都往一个固定的容器中添加一个实例，并且缓存起来，
 * 下次使用直接从内存中取，以保证每次取到的都是同一个实例
 */
public class RegisterMap {
private RegisterMap(){}
    private static Map<String,Object> register = new ConcurrentHashMap<>();
    public static RegisterMap getInstance(String name){
        if(name == null){
            name = RegisterMap.class.getName();
        }
        if(register.get(name) == null){
            try {
                register.put(name,new RegisterMap());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (RegisterMap) register.get(name);
    }
}
