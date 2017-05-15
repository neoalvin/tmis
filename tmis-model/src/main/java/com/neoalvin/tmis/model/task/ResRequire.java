package com.neoalvin.tmis.model.task;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 作业资源需求
 * Created by alvin on 2017/4/23.
 */
public class ResRequire {

  /**
   * 地域需求
   */
  @JsonProperty("region")
  private int region;

  /**
   * 网络运营商需求
   */
  @JsonProperty("isp")
  private int isp;

  public int getRegion() {
    return region;
  }

  public void setRegion(int region) {
    this.region = region;
  }

  public int getIsp() {
    return isp;
  }

  public void setIsp(int isp) {
    this.isp = isp;
  }

  @Override
  public String toString() {
    return "ResRequire{" +
        "region=" + region +
        ", isp=" + isp +
        '}';
  }
}
