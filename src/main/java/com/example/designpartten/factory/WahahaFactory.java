package com.example.designpartten.factory;


import com.example.designpartten.simplefactory.Wahaha;
import com.example.designpartten.simplefactory.Water;

/**
 * Created by wb-yejian on 2018/7/12.
 */
public class WahahaFactory implements WaterFactory {
    public Water getWater(){
        return new Wahaha();
    }
}
