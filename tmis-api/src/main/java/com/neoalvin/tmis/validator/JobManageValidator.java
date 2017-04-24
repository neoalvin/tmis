package com.neoalvin.tmis.validator;

import com.neoalvin.tmis.model.RetCode;
import com.neoalvin.tmis.model.job.CommitJobInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 作业管理操作校验类
 * Created by alvin on 2017/4/23.
 */
public abstract class JobManageValidator {
  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(JobManageValidator.class);

  /**
   * 校验提交任务入参
   * @param input
   * @return
   */
  public static RetCode validateCommitJobInput(CommitJobInput input)
  {
    //定义返回信息对象
    RetCode retCode = new RetCode();

    LOGGER.info("[JobManageValidator]: start to check comit job input.");

    return retCode;
  }
}
