package com.example.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 2018/7/13.
 */
public class CloneTest {

    public static void main(String[] args) {
        Prototype p= new Prototype();
        p.setName("Tom");

        List list = new ArrayList<>();
        list.add("item1");
        p.setList(list);
        try {
            Prototype obj = (Prototype) p.clone();
            System.out.println(obj.getList().size());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
