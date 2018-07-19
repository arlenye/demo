package com.example.designpartten.abstractfactory;


import com.example.designpartten.simplefactory.Nongfu;
import com.example.designpartten.simplefactory.Water;

/**
 * Created by wb-yejian on 2018/7/12.
 */
public class ConcreteFactory2 extends AbstractFactory {

    @Override
    public Water getWater() {
        return new Nongfu();
    }

    @Override
    public Beer getBeer() {
        return new XuehuaBeer();
    }
}

