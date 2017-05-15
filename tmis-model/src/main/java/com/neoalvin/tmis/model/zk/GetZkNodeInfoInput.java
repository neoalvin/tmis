package com.neoalvin.tmis.model.zk;

/**
 * Created by alvin on 2017/4/26.
 */
public class GetZkNodeInfoInput {
  private String serverList;
  private String nodePath;

  public String getServerList() {
    return serverList;
  }

  public void setServerList(String serverList) {
    this.serverList = serverList;
  }

  public String getNodePath() {
    return nodePath;
  }

  public void setNodePath(String nodePath) {
    this.nodePath = nodePath;
  }

  @Override
  public String toString() {
    return "GetZkNodeInfoInput{" +
        "serverList='" + serverList + '\'' +
        ", nodePath='" + nodePath + '\'' +
        '}';
  }
}
