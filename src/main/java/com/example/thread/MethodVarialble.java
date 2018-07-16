package com.example.thread;

import java.lang.reflect.Field;

/**
 * Created by yejian on 2018/7/9.
 */
public class MethodVarialble {
    public static void main(String[] args) {
        Integer i1=10;
        Integer i2=20;
        swap(i1,i2);
        System.out.println("i1="+i1+" i2="+i2);
    }

    public static void swap(Integer i1, Integer i2)  {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            //int temp = i1.intvalue();  //指向同一份内存地址
            Integer temp = new Integer(i1.intValue());
            field.set(i1,i2.intValue());
            field.set(i2,temp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
