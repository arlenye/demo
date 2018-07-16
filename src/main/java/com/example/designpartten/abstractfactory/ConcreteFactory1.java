package com.example.designpartten.abstractfactory;

import com.java.yj.designpartten.simplefactory.Wahaha;
import com.java.yj.designpartten.simplefactory.Water;

/**
 * Created by wb-yejian on 2018/7/12.
 */
public class ConcreteFactory1 extends AbstractFactory {

    @Override
    public Water getWater() {
        return new Wahaha();
    }

    @Override
    public Beer getBeer() {
        return new QingdaoBeer();
    }
}

