package com.example.designpartten.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wb-yejian on 2018/7/13.
 */
public class TestSingleton {
    public static void main(String[] args) {
        testMultiThreadAccessSingleton();

       // testSerializableSingleton();
    }

    private static void testMultiThreadAccessSingleton() {
        int count = 100;
        final CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            Thread1 thread1= new Thread1();
            thread1.start();
        }
    }

    private static  class Thread1 extends Thread{
        @Override
        public void run() {
            System.out.printf("%d,%s",System.currentTimeMillis(),LazyFive.getInstance());
            System.out.println();
        }
    }

    private static void testSerializableSingleton() {
        LazyFive instance = LazyFive.getInstance();
        System.out.println(instance);
        try {
            FileOutputStream fos = new FileOutputStream("lazyfive");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);

            FileInputStream fis = new FileInputStream("lazyfive");
            ObjectInputStream ois  = new ObjectInputStream(fis);
            Object instance2 = ois.readObject();
            System.out.println(instance2);
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
