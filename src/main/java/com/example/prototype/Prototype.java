package com.example.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James on 2018/7/13.
 */
public class Prototype implements Cloneable{

    private String name ;
    private List<String> list =new ArrayList<>();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return list;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
