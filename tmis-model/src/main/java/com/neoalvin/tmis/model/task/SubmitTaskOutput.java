package com.neoalvin.tmis.model.task;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * 提交任务返回数据类
 * Created by alvin on 2017/4/23.
 */
public class SubmitTaskOutput {
  /**
   * 返回码
   */
  @JsonProperty("resultcode")
  private int resultCode = 0;

  /**
   * 描述
   */
  @JsonProperty("desc")
  private String decription = "success";

  /**
   * 用户作业ID
   */
  @JsonProperty("userjobid")
  private String userJobId;

  /**
   * 任务列表
   */
  @JsonProperty("tasklist")
  private List<TaskInfo> taskInfoList;

  public int getResultCode() {
    return resultCode;
  }

  public void setResultCode(int resultCode) {
    this.resultCode = resultCode;
  }

  public String getDecription() {
    return decription;
  }

  public void setDecription(String decription) {
    this.decription = decription;
  }

  public String getUserJobId() {
    return userJobId;
  }

  public void setUserJobId(String userJobId) {
    this.userJobId = userJobId;
  }

  public List<TaskInfo> getTaskInfoList() {
    return taskInfoList;
  }

  public void setTaskInfoList(List<TaskInfo> taskInfoList) {
    this.taskInfoList = taskInfoList;
  }

  @Override
  public String toString() {
    return "CommitJobOutput{" +
        "resultCode=" + resultCode +
        ", decription='" + decription + '\'' +
        ", userJobId='" + userJobId + '\'' +
        ", taskInfoList=" + taskInfoList +
        '}';
  }
}
