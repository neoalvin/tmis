package com.neoalvin.tmis.model.task;

/**
 * 任务状态信息
 * Created by alvin on 2017/4/25.
 */
public class TaskResultInfo {

  public int resultCode;

  public String taskId;

  public String imageName;

  public String taskStatus;

  public int getResultCode() {
    return resultCode;
  }

  public void setResultCode(int resultCode) {
    this.resultCode = resultCode;
  }

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public String getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(String taskStatus) {
    this.taskStatus = taskStatus;
  }


  @Override
  public String toString() {
    return "TaskStatusInfo{" +
        "resultCode='" + resultCode + '\'' +
        ", taskId='" + taskId + '\'' +
        ", imageName='" + imageName + '\'' +
        ", taskStatus='" + taskStatus + '\'' +
        '}';
  }
}
