package com.neoalvin.tmis.api;

import com.neoalvin.tmis.model.task.SubscribeTaskStatusInput;
import com.neoalvin.tmis.model.task.SubscribeTaskStatusOutput;

/**
 * 任务消息订阅服务接口
 * Created by alvin on 2017/4/24.
 */
public interface ITaskStatusSubscribeService {
  /**
   * 订阅任务状态
   * @param input
   * @return
   */
  SubscribeTaskStatusOutput subscribeTaskStatus(SubscribeTaskStatusInput input);
}
