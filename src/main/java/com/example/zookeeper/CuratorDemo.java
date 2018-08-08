package com.example.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * Created by James on 2018/8/7.
 */
public class CuratorDemo {
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework =CuratorFrameworkFactory
                .builder()
                .connectString("18.212.54.249:2181,18.207.187.148:2181,54.197.198.14:2181")
                .sessionTimeoutMs(4000)
                .retryPolicy(new ExponentialBackoffRetry(1000,3))
                .namespace("curator").build();

        curatorFramework.start();
        curatorFramework.create().creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath("/arlen/node","1".getBytes());

        curatorFramework.delete().deletingChildrenIfNeeded().forPath("/arlen/node");

        Stat stat = new Stat();
        curatorFramework.getData().storingStatIn(stat).forPath("/arlen/nodel");
        curatorFramework.setData()
                .withVersion(stat.getVersion()).forPath("/arlen/nodel","yy".getBytes());
curatorFramework.close();
    }
}
