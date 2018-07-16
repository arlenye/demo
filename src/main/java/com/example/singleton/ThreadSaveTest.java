package com.example.singleton;

import java.io.*;

/**
 * Created by James on 2018/7/12.
 */
public class ThreadSaveTest {
    public static void main(String[] args) {
        int count = 10000;
        long start = System.currentTimeMillis();
        for (int i = 0; i <count ; i++) {
            Object obj = LazyThree.getInstance();
        }
        long end = System.currentTimeMillis();
        System.out.println("时间："+(end-start));

        RegisterEnum.INSTANCE.getInstance();

        Seriable s1 = null;
        Seriable s2 = Seriable.getInstance();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("Seriable.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            FileInputStream fis = new FileInputStream("Seriable.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (Seriable) ois.readObject();

            System.out.println(s1);
            System.out.println(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
