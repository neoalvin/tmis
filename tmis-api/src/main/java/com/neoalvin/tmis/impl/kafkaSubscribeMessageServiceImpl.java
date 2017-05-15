package com.neoalvin.tmis.impl;

import com.neoalvin.tmis.api.IkafkaSubscribeMessageService;
import com.neoalvin.tmis.model.kafka.KafkaMessageRecord;
import com.neoalvin.tmis.model.kafka.SubscribeKafkaMessageInput;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * 订阅kafka消息接口实现类
 * Created by alvin on 2017/4/25.
 */
public class kafkaSubscribeMessageServiceImpl implements IkafkaSubscribeMessageService {

  /**
   * 定义消费者对象
   */
  private Consumer<String,String> consumer ;

  /**
   * 初始化kafka配置
   * @param topicName
   * @param group
   */
  private void initKafkaProperties(String topicName, String group)
  {
    Properties properties = new Properties();
    properties.put("bootstrap.servers", "172.29.152.185:9092,172.29.152.186:9092,172.29.152.190:9092");
    properties.put("group.id", group);
    properties.put("enable.auto.commit", "true");
    properties.put("auto.commit.interval.ms", "1000");
    properties.put("session.timeout.ms", "30000");
    properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    consumer = new KafkaConsumer<String, String>(properties);
    consumer.subscribe(Arrays.asList(topicName));

  }

  public void close(){
    consumer.close();
  }

  /**
   * 订阅消息
   * @param input
   * @return
   */
  public List<KafkaMessageRecord> subscribeKafkaMessage(SubscribeKafkaMessageInput input) {
    //初始化kafka配置
    initKafkaProperties(input.getTopicName(),input.getGroup());

    //定义返回对象
    KafkaMessageRecord kafkaMessageRecord = new KafkaMessageRecord();
    List<KafkaMessageRecord> kafkaMessageRecordList = new ArrayList<KafkaMessageRecord>();

    //从kafka中读取消息
    ConsumerRecords<String, String> records = consumer.poll(100);
    for (ConsumerRecord<String, String> record:records){
      kafkaMessageRecord.setOffset(record.offset());
      kafkaMessageRecord.setKey(record.key());
      kafkaMessageRecord.setValue(record.value());
      kafkaMessageRecordList.add(kafkaMessageRecord);
      System.out.printf("subscribe kafka message, kafkaMessageRecord = " + kafkaMessageRecord);
    }
    return kafkaMessageRecordList;
  }
}
