package com.example.thread;

/**
 * Created by James on 2018/7/22.
 */
public class MultiThreadAccess {
    private static  int count=0;

    private static void add(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i <1000; i++) {
            new Thread(MultiThreadAccess::add).start();//静态引用
        }
        Thread.sleep(5000);
        System.out.println("result="+count);
    }
}
