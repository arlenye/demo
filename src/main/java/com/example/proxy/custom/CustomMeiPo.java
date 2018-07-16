package com.example.proxy.custom;

import com.example.proxy.Person;

import java.lang.reflect.Method;

/**
 * Created by James on 2018/7/15.
 */
public class CustomMeiPo implements YJInvocationHandler{
    private Person target;

    public Object getInstantce(Person target )throws Exception{
        this.target=target;
        Class<?> clazz= target.getClass();
        return YJProxy.newProxyInstance(new YJClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是代理，给你找对象，已经拿到你的需求");
        System.out.println("开始匹配");
        method.invoke(this.target,args);
        System.out.println("结果");
        return null;
    }
}
