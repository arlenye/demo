package com.example.proxy;

import com.example.proxy.cglib.CglibProxy;
import com.example.proxy.cglib.Zhangsan;
import com.example.proxy.custom.CustomMeiPo;
import com.example.proxy.jdk.JdkProxy;
import com.example.proxy.jdk.XieMu;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by James on 2018/7/14.
 */
public class ProxyTest {


    public static void main(String[] args) {
//        testStaticProxy();
//        testJDKProxy();
//        testCglibProxy();
//        testCglibProxyImpl();
        testCustomYJProxy();
    }

    private static void testCustomYJProxy() {
        try {
            Person obj =  (Person)new CustomMeiPo().getInstantce(new XieMu());
            //obj.findLove();
           // System.out.println(obj.getClass());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 原理：
     * 1.拿到被代理对象的引用，并且获取到它的所有接口，反射获取
     * 2.JDK Proxy类重新生成一个新的类、同时新的类要实现被代理类的所有实现的接口
     * 3. 动态生成java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
     * 4. 编译新生成的java文件为.class文件
     * 5. 重新加载到JVM运行
     * 以上过程为字节码重组
     *
     * JDK规范：只要是$符号开头的，一般都是自动生成的
     *
     * 反编译工具查看源代码
     * 字节码保存为class文件
     */
    private static void testCglibProxyImpl() {

    }

    private static void testCglibProxy() {
        try {
            Zhangsan obj = (Zhangsan)new CglibProxy().getInstance(Zhangsan.class);
            obj.findLove();
            System.out.println(obj.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void testJDKProxy() {
        Person obj =  (Person)new JdkProxy().getInstantce(new XieMu());
        obj.findLove();
        System.out.println(obj.getClass());
        byte[] bytes= ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
        try {
            FileOutputStream fos = new FileOutputStream("E://gupao//temp//$Proxy0.class");
            fos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void testStaticProxy() {
        Father f = new Father(new Son());
        f.findLove();
    }
}
