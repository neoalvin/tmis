package com.neoalvin.tmis.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Kafka消费者基本操作类
 * Created by alvin on 2017/4/24.
 */
public class BasicKafkaConsumer {
  /**
   * 定义topic名称
   */
  private String topicName;

  /**
   * 定义消费者对象
   */
  protected Consumer<String,String> consumer ;

  /**
   * 构造函数，初始化相关配置
   * @param topicName
   * @param group
   */
  public BasicKafkaConsumer(String topicName, String group) {
    this.topicName = topicName;


    Properties properties = new Properties();
    properties.put("bootstrap.servers", "172.29.152.185:9092,172.29.152.186:9092,172.29.152.190:9092");
    properties.put("group.id", group);
    properties.put("enable.auto.commit", "true");
    properties.put("auto.commit.interval.ms", "1000");
    properties.put("session.timeout.ms", "30000");
    properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

    consumer = new KafkaConsumer<String, String>(properties);
    consumer.subscribe(Arrays.asList(this.topicName));
  }


  public void conume(){
    while (true){
      ConsumerRecords<String, String> records = consumer.poll(100);
      for (ConsumerRecord<String, String> record:records){
        System.out.printf("offset = %d, key = %s, value = %s\n", record.offset(), record.key(), record.value());
      }
    }
  }

  public static void main(String[] args) {
    BasicKafkaConsumer consumer = new BasicKafkaConsumer("alvin_tmis_submit_topic", "alvin_group");
    consumer.conume();
  }
}
