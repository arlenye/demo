package com.example.designpartten.decorator;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

/**
 * Created by James on 2018/7/18.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {

        //为了某个实现类在不修改原始类的基础上进行动态
        //的覆盖或者增加方法，采用装饰模式
        //该实现保持更原有类的层级关系
        //装饰器模式实际上是适配器模式的一种特殊

        //DataInputStream 功能更强大，DataInputStream同样要实现InputStream
        InputStream in =null;
        FilterInputStream fis = new DataInputStream(in);
    }
}
