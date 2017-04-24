package com.neoalvin.tmis.api;


import com.neoalvin.tmis.model.job.CommitJobInput;
import com.neoalvin.tmis.model.job.CommitJobOutput;

/**
 * 作业管理服务接口
 * Created by alvin on 2017/4/23.
 */
public interface IJobManageService {
  /**
   * 提交作业
   * @param input
   * @return
   */
  CommitJobOutput commitJob(CommitJobInput input);
}
