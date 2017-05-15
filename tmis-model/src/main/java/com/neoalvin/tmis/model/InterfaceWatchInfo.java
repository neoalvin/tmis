package com.neoalvin.tmis.model;

/**
 * 接口监控信息
 * Created by alvin on 2017/4/26.
 */
public class InterfaceWatchInfo {
  private int id;
  private int interfaceCount;
  private int interfaceCallSum;
  private int serverCount;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getInterfaceCount() {
    return interfaceCount;
  }

  public void setInterfaceCount(int interfaceCount) {
    this.interfaceCount = interfaceCount;
  }

  public int getInterfaceCallSum() {
    return interfaceCallSum;
  }

  public void setInterfaceCallSum(int interfaceCallSum) {
    this.interfaceCallSum = interfaceCallSum;
  }

  public int getServerCount() {
    return serverCount;
  }

  public void setServerCount(int serverCount) {
    this.serverCount = serverCount;
  }

  @Override
  public String toString() {
    return "InterfaceWatchInfo{" +
        "id=" + id +
        ", interfaceCount=" + interfaceCount +
        ", interfaceCallSum=" + interfaceCallSum +
        ", serverCount=" + serverCount +
        '}';
  }
}
