package com.example.zookeeper;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by James on 2018/8/4.
 */
public class ConnectionDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("18.212.54.249:2181,18.207.187.148:2181,54.197.198.14:2181",4000,null);
        System.out.println(zooKeeper.getState());
        Thread.sleep(1000);
        System.out.println(zooKeeper.getState());
        zooKeeper.close();
    }

}
