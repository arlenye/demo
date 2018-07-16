package com.example.designpartten;


import com.example.designpartten.abstractfactory.AbstractFactory;
import com.example.designpartten.abstractfactory.ConcreteFactory1;
import com.example.designpartten.abstractfactory.ConcreteFactory2;
import com.example.designpartten.factory.NongfuFactory;
import com.example.designpartten.factory.WaterFactory;
import com.example.designpartten.simplefactory.SimpleFactory;
import com.example.designpartten.simplefactory.Water;

/**
 * Created by wb-yejian on 2018/7/12.
 */
public class FactoryTest {


    public static void main(String[] args) {
        testSimpleFactory();
        testFactory();
        testAbstractFactory();

    }


    /**
     * 提供一个创建一系列相关或者相互依赖对象的接口，而无需指定它们具体的类。
     */
    private static void testAbstractFactory() {

        AbstractFactory f1 = new ConcreteFactory1();
        System.out.println(f1.getBeer());
        System.out.println(f1.getWater());

        AbstractFactory f2 = new ConcreteFactory2();
        System.out.println(f2.getBeer());
        System.out.println(f2.getWater());
    }

    /**
     * 工厂方法将类的实例化推迟到了其子类。所以使用工厂方法模式时，需要客户端决定实例化哪一个工厂类。
     * 选择判断问题还是存在的。也就是说，工厂方法把简单的工厂内部逻辑判断转移到了客户端来运行。
     * 你想要加的功能，本来是要改工厂类的，而现在是修改客户端。
     * 不过，我们在某些情况下通过工厂方法，只需要修改一行实例化的代码就可以实现系统元素的切换(比如切换数据源)。这也是很方便的。
     */
    private static void testFactory() {
        WaterFactory factory = new NongfuFactory();
        System.out.println(factory.getWater());
    }

    /**
     * 简单工厂将对象的创建过程进行了封装，用户不需要知道具体的创建过程，只需要调用工厂类获取对象即可。
     */
    private static void testSimpleFactory() {
        SimpleFactory factory = new SimpleFactory();
        Water water = factory.getWater("娃哈哈");
        System.out.println(water);
    }
}
