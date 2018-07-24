package com.example.proxy.jdk;

import com.example.proxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by James on 2018/7/14.
 *
 */
public class JdkProxy implements InvocationHandler{
    private Person target;

    public Object getInstantce(Person target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
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
