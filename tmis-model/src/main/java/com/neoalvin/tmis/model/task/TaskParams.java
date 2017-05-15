package com.neoalvin.tmis.model.task;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 作业参数
 * Created by alvin on 2017/4/23.
 */
public class TaskParams {

  /**
   * 作业参数
   */
  @JsonProperty("parameter")
  private String jobParam;

  public String getJobParam() {
    return jobParam;
  }

  public void setJobParam(String jobParam) {
    this.jobParam = jobParam;
  }

  @Override
  public String toString() {
    return "JobParams{" +
        "jobParam='" + jobParam + '\'' +
        '}';
  }
}
