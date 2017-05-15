package com.neoalvin.tmis.model.task;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * 作业提交请求数据
 * Created by alvin on 2017/4/23.
 */
public class RequestData {

  /**
   * 业务系统名称，必须为英文
   */
  @JsonProperty("busi_name_en")
  private String businessName;

  /**
   * 镜像名
   */
  @JsonProperty("image_name")
  private String imageName;

  /**
   * 作业资源需求
   */
  @JsonProperty("resrequire")
  private ResRequire resRequire;

  /**
   * 作业参数列表
   */
  @JsonProperty("parameter_list")
  private List<TaskParams> paramterList;

  public String getBusinessName() {
    return businessName;
  }

  public void setBusinessName(String businessName) {
    this.businessName = businessName;
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public ResRequire getResRequire() {
    return resRequire;
  }

  public void setResRequire(ResRequire resRequire) {
    this.resRequire = resRequire;
  }

  public List<TaskParams> getParamterList() {
    return paramterList;
  }

  public void setParamterList(List<TaskParams> paramterList) {
    this.paramterList = paramterList;
  }

  @Override
  public String toString() {
    return "RequestData{" +
        "businessName='" + businessName + '\'' +
        ", imageName='" + imageName + '\'' +
        ", resRequire=" + resRequire +
        ", paramterList=" + paramterList +
        '}';
  }
}
