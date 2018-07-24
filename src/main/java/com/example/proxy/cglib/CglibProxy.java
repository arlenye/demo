package com.example.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by James on 2018/7/14.
 * 通过生成一个被代理对象的子类，然后重写父类的方法
 * 生成以后的对象可以强制转换为被代理对象（自己写的类）
 * 子类引用赋值给父类
 *
 *
 */
public class CglibProxy implements MethodInterceptor{
    public Object getInstance(Class<?> clazz) throws Exception{
        Enhancer enhancer = new Enhancer();
        //要把那个类（被代理类）设置为即将生成的新类的父类
        enhancer.setSuperclass(clazz);
        //设置回调
        enhancer.setCallback(this);
        /**
         * 1.生成源代码
         * 2. 编译成class文件
         * 3. 加载到jvm中，并返回被代理对象
         */
        return enhancer.create();
    }

    /**
     * obj的引用是cglibnew出来的
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //业务的增强
        System.out.println("cglib 代理，已经收到需求");
        System.out.println("开始匹配");
        methodProxy.invokeSuper(o,objects);//调 invoke会死循环
        System.out.println("匹配结果");
        return o;
    }
}
