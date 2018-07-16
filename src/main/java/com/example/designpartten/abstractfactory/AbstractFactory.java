package com.example.designpartten.abstractfactory;


import com.example.designpartten.simplefactory.Water;

/**
 * Created by wb-yejian on 2018/7/12.
 */
public abstract class AbstractFactory {

    abstract public Water getWater();

    abstract public Beer getBeer();
}
