package com.neoalvin.tmis.api;

import com.neoalvin.tmis.model.kafka.CreateKafkaTopicInput;
import com.neoalvin.tmis.model.kafka.CreateKafkaTopicOutput;

/**
 * kafka相关服务操作接口
 * Created by alvin on 2017/4/24.
 */
public interface IKafkaService {
  /**
   * 创建topic
   * @param input
   * @return
   */
  CreateKafkaTopicOutput createKafkaTopic(CreateKafkaTopicInput input);
}
