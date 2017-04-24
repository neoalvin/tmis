package com.neoalvin.tmis.producer;

import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Kafka生产者
 * Created by alvin on 2017/4/24.
 */
public class BasicKafkaProducer {
  /**
   * 定义topic列表
   */
  private List<String> topicNames;

  /**
   * 定义生产者对象
   */
  private Producer<String,String> producer;

  /**
   * 构造函数，初始化相关配置
   * @param topicNames
   */
  public BasicKafkaProducer(List<String> topicNames) {
    this.topicNames = topicNames;

    Properties properties = new Properties();

    properties.put("bootstrap.servers", "172.29.152.185:9092,172.29.152.186:9092,172.29.152.190:9092");
    properties.put("acks", "all");
    properties.put("retries", 0);
    properties.put("batch.size", 16384);
    properties.put("linger.ms", 1);
    properties.put("buffer.memory", 33554432);
    properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    producer = new KafkaProducer<String,String>(properties);

  }

  /**
   * 发送消息
   * @param message
   */
  public void send(String message){
    for (String topicName:topicNames){
      producer.send(new ProducerRecord<String, String>(topicName, message));
    }
    producer.flush();
  }

  /**
   * 关闭生产者
   */
  public void close(){
    producer.close();
  }

}
