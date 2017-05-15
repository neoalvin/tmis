package com.neoalvin.tmis.api;

import com.neoalvin.tmis.model.kafka.KafkaMessageRecord;
import com.neoalvin.tmis.model.kafka.SubscribeKafkaMessageInput;

import java.util.List;

/**
 * Kafka订阅消息服务
 * Created by alvin on 2017/4/25.
 */
public interface IkafkaSubscribeMessageService {
   List<KafkaMessageRecord> subscribeKafkaMessage(SubscribeKafkaMessageInput input);
   void close();
}
