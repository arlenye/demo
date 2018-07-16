package com.example.designpartten.simplefactory;

/**
 * Created by wb-yejian on 2018/7/11.
 */
public class SimpleFactory {

    public Water getWater(String name){
        if(name == null){return null;}
        if(name.equals("娃哈哈")){
            return new Wahaha();
        }else if(name.equals("农夫山泉")){
            return new Nongfu();
        }
        return  null;
    }
}
