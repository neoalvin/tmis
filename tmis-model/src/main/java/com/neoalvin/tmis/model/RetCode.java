package com.neoalvin.tmis.model;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 返回信息数据类
 * Created by alvin on 2017/4/23.
 */
public class RetCode {

  /**
   * 返回码
   */
  @JsonProperty("code")
  private String code = "0";

  /**
   * 返回信息
   */
  @JsonProperty("message")
  private String message = "success";

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "RetCode{" +
        "code='" + code + '\'' +
        ", message='" + message + '\'' +
        '}';
  }
}
