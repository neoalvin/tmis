package com.neoalvin.tmis.api;

import com.neoalvin.tmis.model.zk.GetZkNodeInfoInput;

import java.util.List;

/**
 * zk相关操作服务接口
 * Created by alvin on 2017/4/25.
 */
public interface IZookeeperRestService {
  List<String> getDubboServices();
  List<String> getNodesInfo(GetZkNodeInfoInput input);
}
