package com.neoalvin.tmis.model.task;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 任务信息
 * Created by alvin on 2017/4/23.
 */
public class TaskInfo {
  /**
   * 任务ID
   */
  @JsonProperty("taskid")
  private String taskId;

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  @Override
  public String toString() {
    return "TaskInfo{" +
        "taskId='" + taskId + '\'' +
        '}';
  }
}
