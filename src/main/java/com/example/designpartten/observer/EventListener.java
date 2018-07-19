package com.example.designpartten.observer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by James on 2018/7/19.
 */
public class EventListener {

    protected Map<Enum ,Event> events = new HashMap<>();

public void addLisener(Enum eventType,Object target,Method callBack){
    //注册事件 用反射调用这个方法
    events.put(eventType,new Event(target,callBack));
}

private  void trigger(Event e){
    e.setSource(this);
    e.setTime(System.currentTimeMillis());
    try {
        e.getCallback().invoke(e.getTarget(),e);
    } catch (IllegalAccessException e1) {
        e1.printStackTrace();
    } catch (InvocationTargetException e1) {
        e1.printStackTrace();
    }
}

protected void trigger(Enum call){
    if(!this.events.containsKey(call)){return ;}
    trigger(this.events.get(call).setTrigger(call.toString()));
}


}
