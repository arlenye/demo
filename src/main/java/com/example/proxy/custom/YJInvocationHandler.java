package com.example.proxy.custom;

import java.lang.reflect.Method;

/**
 * Created by James on 2018/7/14.
 */
public interface YJInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
