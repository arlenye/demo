package com.example.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by James on 2018/8/4.
 */
public class ConnectionWatcherDemo {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        final CountDownLatch countDownLatch =  new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper("18.212.54.249:2181,18.207.187.148:2181,54.197.198.14:2181", 4000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        System.out.println(zooKeeper.getState());
        //添加节点
        zooKeeper.create("/zk-persistance-arlen","0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        Thread.sleep(1000);
        Stat stat = new Stat();
        byte[] bytes = zooKeeper.getData("/zk-persistance-arlen",null,stat);
        System.out.println(new String(bytes));
        zooKeeper.setData("/zk-persistance-arlen","1".getBytes(),stat.getVersion());
        byte[] bytes1 = zooKeeper.getData("/zk-persistance-arlen",null,stat);
        System.out.println(new String(bytes1));

        zooKeeper.delete("/zk-persistance-arlen",stat.getVersion());
        zooKeeper.close();
    }

}
