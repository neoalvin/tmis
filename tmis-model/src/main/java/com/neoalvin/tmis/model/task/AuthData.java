package com.neoalvin.tmis.model.task;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 用户身份认证信息
 * Created by alvin on 2017/4/23.
 */
public class AuthData {

  /**
   * 用户ID
   */
  @JsonProperty("busi_id")
  private String businessId;

  /**
   * 用户密码
   */
  @JsonProperty("busi_passwd")
  private String businessPwd;

  public String getBusinessId() {
    return businessId;
  }

  public void setBusinessId(String businessId) {
    this.businessId = businessId;
  }

  public String getBusinessPwd() {
    return businessPwd;
  }

  public void setBusinessPwd(String businessPwd) {
    this.businessPwd = businessPwd;
  }

  @Override
  public String toString() {
    return "AuthData{" +
        "businessId='" + businessId + '\'' +
        ", businessPwd='" + businessPwd + '\'' +
        '}';
  }
}
