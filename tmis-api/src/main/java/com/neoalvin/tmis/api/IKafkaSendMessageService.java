package com.neoalvin.tmis.api;

import com.neoalvin.tmis.model.kafka.SendKafkaMessageInput;

/**
 * kafka相关服务操作接口
 * Created by alvin on 2017/4/24.
 */
public interface IKafkaSendMessageService {
  void sendKafkaMessage(SendKafkaMessageInput input);
  void close();
}
