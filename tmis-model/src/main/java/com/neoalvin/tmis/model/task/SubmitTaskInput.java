package com.neoalvin.tmis.model.task;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * 提交作业入参数据类
 * Created by alvin on 2017/4/23.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitTaskInput implements Serializable {
  /**
   * 用户身份认证信息
   */
  @JsonProperty("authdata")
  private AuthData authData;

  /**
   * 作业提交请求数据
   */
  @JsonProperty("requestdata")
  private RequestData requestData;

  public AuthData getAuthData() {
    return authData;
  }

  public void setAuthData(AuthData authData) {
    this.authData = authData;
  }

  public RequestData getRequestData() {
    return requestData;
  }

  public void setRequestData(RequestData requestData) {
    this.requestData = requestData;
  }

  @Override
  public String toString() {
    return "CommitJobInput{" +
        "authData=" + authData +
        ", requestData=" + requestData +
        '}';
  }
}
