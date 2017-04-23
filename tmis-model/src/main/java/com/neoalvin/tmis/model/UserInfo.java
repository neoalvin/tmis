package com.neoalvin.tmis.model;

import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户身份信息数据类
 * Created by alvin on 2017/4/23.
 */
public class UserInfo implements Serializable {
  /**
   * 用户名
   */
  @NotNull
  @JsonProperty("userId")
  private String userId;

  /**
   * 密码摘要
   */
  @NotNull
  @JsonProperty("pwdCode")
  private String pwdCode;

  /**
   * 无参构造函数
   */
  public UserInfo() {
  }

  /**
   * 带参构造函数
   * @param userId
   * @param pwdCode
   */
  public UserInfo(String userId, String pwdCode) {
    this.userId = userId;
    this.pwdCode = pwdCode;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPwdCode() {
    return pwdCode;
  }

  public void setPwdCode(String pwdCode) {
    this.pwdCode = pwdCode;
  }

  @Override
  public String toString() {
    return "UserInfo{" +
        "userId='" + userId + '\'' +
        ", pwdCode='" + pwdCode + '\'' +
        '}';
  }
}
