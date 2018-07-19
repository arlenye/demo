package com.example.designpartten.observer;

import java.lang.reflect.Method;

/**
 * Created by James on 2018/7/19.
 */
public class Event {
    //事件源头
    private  Object source;
    //通知目标
    private Object target;
    //回调
    private Method callback;
    //触发
    private String trigger;
    //时间
    private  Long time;

    public Event(Object source, Object target, Method callback, String trigger) {
        this.source = source;
        this.target = target;
        this.callback = callback;
        this.trigger = trigger;
    }

    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\n source=" + source +
                "\n  target=" + target +
                "\n  callback=" + callback +
                "\n  trigger='" + trigger + '\'' +
                '}';
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void  setCallback(Method callback) {
        this.callback = callback;

    }

    public String getTrigger() {
        return trigger;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }
}
