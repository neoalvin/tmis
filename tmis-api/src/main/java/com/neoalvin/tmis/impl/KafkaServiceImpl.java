package com.neoalvin.tmis.impl;

import com.neoalvin.tmis.api.IKafkaService;
import com.neoalvin.tmis.model.kafka.CreateKafkaTopicInput;
import com.neoalvin.tmis.model.kafka.CreateKafkaTopicOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Kafka相关服务接口实现类
 * Created by alvin on 2017/4/24.
 */
public class KafkaServiceImpl implements IKafkaService{
  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaServiceImpl.class);

  /**
   * 创建topic
   * @param input
   * @return
   */
  public CreateKafkaTopicOutput createKafkaTopic(CreateKafkaTopicInput input) {
    LOGGER.info("[IKafkaService]: Start to create kafka topic.");
    LOGGER.info("[IKafkaService]: create kafka topic successfully.");
    return null;
  }
}
