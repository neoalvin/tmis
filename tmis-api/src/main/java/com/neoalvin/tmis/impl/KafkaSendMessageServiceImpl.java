package com.neoalvin.tmis.impl;

import com.neoalvin.tmis.api.IKafkaSendMessageService;
import com.neoalvin.tmis.model.kafka.KafkaMessageRecord;
import com.neoalvin.tmis.model.kafka.SendKafkaMessageInput;
import com.neoalvin.tmis.model.kafka.SubscribeKafkaMessageInput;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * Kafka相关服务接口实现类
 * Created by alvin on 2017/4/24.
 */
public class KafkaSendMessageServiceImpl implements IKafkaSendMessageService {
  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSendMessageServiceImpl.class);

  /**
   * 定义生产者对象
   */
  private Producer<String,String> producer;

  /**
   * 初始化kafka配置
   */
  private void initKafkaProperties(){
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
   * 发布消息
   * @param input
   */
  public void sendKafkaMessage(SendKafkaMessageInput input) {
    initKafkaProperties();
    List<String> topicNames = input.getTopicNameList();
    String message = input.getMessage();
    for (String topicName: topicNames){
      producer.send(new ProducerRecord<String, String>(topicName, message));
    }
    producer.flush();
    LOGGER.info("[IKafkaService]: Send message to kafka topic successfully.");
  }

  /**
   * 关闭生产者
   */
  public void close(){
    producer.close();
  }

  public static void main(String[] args) {
    KafkaSendMessageServiceImpl kafkaSendMessageService = new KafkaSendMessageServiceImpl();
    //构造入参
    SendKafkaMessageInput input = new SendKafkaMessageInput();
    input.setTopicNameList(Arrays.asList("alvin_tmis_submit_topic"));
    //发布多条消息
    for (int i = 0; i < 10; i++) {
      input.setMessage("send from alvin: " + i);
      System.out.println("===== send from alvin ===== " + i);
      kafkaSendMessageService.sendKafkaMessage(input);
    }
    kafkaSendMessageService.close();
  }
}
