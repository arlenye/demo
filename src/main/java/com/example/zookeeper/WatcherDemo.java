package com.example.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by James on 2018/8/4.
 */
public class WatcherDemo {

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper("18.212.54.249:2181,18.207.187.148:2181,54.197.198.14:2181", 4000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
               // countDownLatch.countDown();
                System.out.println("全局默认事件："+watchedEvent.getType()+"-->"+watchedEvent.getPath());
                if (Event.KeeperState.SyncConnected==watchedEvent.getState()){
                    countDownLatch.countDown();
                }
            }
        });
        countDownLatch.await();
        System.out.println(zooKeeper.getState());
        //添加节点
        zooKeeper.create("/zk-per-arlen", "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        Thread.sleep(1000);
        Stat stat = zooKeeper.exists("/zk-per-arlen", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println(watchedEvent.getType()+"-->"+watchedEvent.getPath());
                try {
                    zooKeeper.exists(watchedEvent.getPath(),true);
                } catch (KeeperException e) {
                    e.printStackTrace();e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        stat = zooKeeper.setData("/zk-per-arlen","2".getBytes(),stat.getVersion());
    Thread.sleep(1000);
        zooKeeper.delete("/zk-per-arlen",stat.getVersion());
    }
}
