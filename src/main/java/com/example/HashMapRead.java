package com.example;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by James on 2018/7/21.
 */
public class HashMapRead
{
    public static void main(String[] args) {

        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"a");
        map.put(3,"a3");
        System.out.println(map.get(1));
    }
}
