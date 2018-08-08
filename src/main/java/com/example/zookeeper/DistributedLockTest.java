package com.example.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by James on 2018/8/8.
 */
public class DistributedLockTest {
    public static void main(String[] args)  {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DistributedLock distributedLock = new DistributedLock();
                distributedLock.lock();
            },"Thread-"+i).start();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
