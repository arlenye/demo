package com.example.zookeeper;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * Created by James on 2018/8/7.
 */
public class CuratorWatcherDemo {
    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework =CuratorFrameworkFactory
                .builder()
                .connectString("18.212.54.249:2181,18.207.187.148:2181,54.197.198.14:2181")
                .sessionTimeoutMs(4000)
                .retryPolicy(new ExponentialBackoffRetry(1000,3))
                .namespace("curator").build();

        curatorFramework.start();
        addListenerwithNodeCache(curatorFramework,"arlen");

        addListenerwithPathChildCache(curatorFramework,"arlen");

        addListenerWithTreeCache(curatorFramework,"arlen");
        System.in.read();

    }
    /**
     * PathChildCache 监听一个节点下子节点的创建、删除、更新
     * NodeCache  监听一个节点的更新和创建事件
     * TreeCache  综合
     */
    public static void addListenerwithNodeCache(CuratorFramework curatorFramework,String path) throws Exception {
        final NodeCache nodeCache = new NodeCache(curatorFramework,"/arlen",false);
        NodeCacheListener nodeCacheListener =new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("Receive Event:"+nodeCache.getCurrentData().getPath());
            }
        };
        nodeCache.getListenable().addListener(nodeCacheListener);


        nodeCache.start();

    }

    public static void addListenerwithPathChildCache(CuratorFramework curatorFramework,String path) throws Exception {
        final PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework,"/arlen",false);
        PathChildrenCacheListener pathChildrenCacheListener =new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                System.out.println("Receive Event:"+ pathChildrenCacheEvent.getType());
            }
        };
        pathChildrenCache.getListenable().addListener(pathChildrenCacheListener);
        pathChildrenCache.start(PathChildrenCache.StartMode.NORMAL);

    }

    public static void addListenerWithTreeCache(CuratorFramework curatorFramework,String path) throws Exception {
        TreeCache treeCache = new TreeCache(curatorFramework,path);
        TreeCacheListener treeCacheListener = new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                System.out.println(treeCacheEvent.getType()+"->"+treeCacheEvent.getData().getPath());

            }
        };
        treeCache.getListenable().addListener(treeCacheListener);
        treeCache.start();
    }
}
