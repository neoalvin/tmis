package com.neoalvin.tmis.model;

/**
 * 用户身份信息数据类
 * Created by alvin on 2017/4/23.
 */
public class UserInfo {
  /**
   * 用户名
   */
  private String username;

  /**
   * 密码摘要
   */
  private String pwdCode;

  /**
   * 无参构造函数
   */
  public UserInfo() {
  }

  /**
   * 带参构造函数
   * @param username
   * @param pwdCode
   */
  public UserInfo(String username, String pwdCode) {
    this.username = username;
    this.pwdCode = pwdCode;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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
        "username='" + username + '\'' +
        ", pwdCode='" + pwdCode + '\'' +
        '}';
  }
}
