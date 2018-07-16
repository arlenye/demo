package com.example.designpartten.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wb-yejian on 2018/7/12.
 */
public class Register {

    private static final Map<String, Register> map =new ConcurrentHashMap<>();
    private Register(){}
    static{
        Register instance = new Register();
        map.put(instance.getClass().getName(),instance);
    }
    public  Register getInstance(String name){
        if(name ==null){
            name = Register.class.getName();
        }
        if(map.get(name) ==null){
            try {
                map.put(name, (Register)Class.forName(name).newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }

}
