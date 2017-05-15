package com.neoalvin.tmis.impl;

import com.neoalvin.tmis.api.IZookeeperService;
import com.neoalvin.tmis.model.zk.GetZkNodeInfoInput;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 *
 * Created by alvin on 2017/4/25.
 */
public class ZookeeperServiceImpl implements IZookeeperService {
  /**
   * 获取子节点列表
   * @return
   */
  public List<String> getDubboServices(){
    try {
      ZooKeeper zk = new ZooKeeper("localhost:2181", 5000, new Watcher() {
        // 监控所有被触发的事件
        public void process(WatchedEvent event) {
          System.out.println("已经触发了" + event.getType() + "事件！");
        }
      });

      return zk.getChildren("/dubbo",true);
    }catch(Exception e){
      e.printStackTrace();
    }
    return null;
  }

  /**
   *获取zk节点信息
   * @return
   */
  public List<String> getNodesInfo(GetZkNodeInfoInput input) {
    try {
      ZooKeeper zk = new ZooKeeper(input.getServerList(), 5000, new Watcher() {
        // 监控所有被触发的事件
        public void process(WatchedEvent event) {
          System.out.println("已经触发了" + event.getType() + "事件！");
        }
      });

      return zk.getChildren(input.getNodePath(),true);
    }catch(Exception e){
      e.printStackTrace();
    }
    return null;
  }
}
