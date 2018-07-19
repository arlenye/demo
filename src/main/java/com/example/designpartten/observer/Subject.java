package com.example.designpartten.observer;

/**
 * Created by James on 2018/7/19.
 */
public class Subject extends  EventListener{

    //通常使用动态代理实现监控，避免代码侵入
    public void add(){
        System.out.println("调用添加的方法");
        trigger(SubjectEventType.ON_ADD);
    }

    public void remove(){
        System.out.println("调用删除的方法");
        trigger(SubjectEventType.ON_REMOVE);
    }
}
