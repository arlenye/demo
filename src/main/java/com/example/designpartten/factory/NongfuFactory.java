package com.example.designpartten.factory;


import com.example.designpartten.simplefactory.Nongfu;
import com.example.designpartten.simplefactory.Water;

/**
 * Created by wb-yejian on 2018/7/12.
 */
public class NongfuFactory implements WaterFactory{
    public Water getWater(){
        return new Nongfu();
    }
}
