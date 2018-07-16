package com.example.thread;

/**
 * Created by wb-yejian on 2018/7/9.
 */
public class MultiThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Thread1());
        thread1.start();
        thread1.join();
        Thread thread2 = new Thread(new Thread2());
        thread2.start();
        thread2.join();
        Thread thread3 = new Thread(new Thread3());
        thread3.start();

    }

    public static class Thread1 implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread1");
        }
    }

    public static class Thread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread2");
        }
    }

    public static class Thread3 implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread3");
        }
    }

}
