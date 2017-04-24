package com.neoalvin.tmis.impl;

import com.neoalvin.tmis.api.ITaskStatusSubscribeService;
import com.neoalvin.tmis.model.task.SubscribeTaskStatusInput;
import com.neoalvin.tmis.model.task.SubscribeTaskStatusOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 任务状态订阅接口实现类
 * Created by alvin on 2017/4/24.
 */
public class TaskStatusSubscribeServiceImpl implements ITaskStatusSubscribeService{
  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(TaskStatusSubscribeServiceImpl.class);

  /**
   * 订阅任务状态
   * @param input
   * @return
   */
  public SubscribeTaskStatusOutput subscribeTaskStatus(SubscribeTaskStatusInput input) {
    LOGGER.info("[TaskStatusSubscribeService]: Start to subscribe task status.");
    LOGGER.info("[TaskStatusSubscribeService]: Subscribe task status successfully.");
    return null;
  }
}
