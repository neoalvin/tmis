package com.neoalvin.tmis.provider;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

/**
 * zk操作demo
 * Created by alvin on 2017/4/25.
 */
public class ZkClient {

  public static void main(String[] args){
    try{
    ZooKeeper zk = new ZooKeeper("localhost:2181", 5000, new Watcher() {
      // 监控所有被触发的事件
      public void process(WatchedEvent event) {
        System.out.println("已经触发了" + event.getType() + "事件！");
      }
    });
      System.out.println(zk.getChildren("/dubbo",true));
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}
