package com.neoalvin.tmis.model.kafka;

import java.util.List;

/**
 * 发布Kafka消息入参
 * Created by alvin on 2017/4/25.
 */
public class SendKafkaMessageInput {

  List<String> topicNameList;

  String message;

  public List<String> getTopicNameList() {
    return topicNameList;
  }

  public void setTopicNameList(List<String> topicNameList) {
    this.topicNameList = topicNameList;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "SendKafkaMessageInput{" +
        "topicNameList=" + topicNameList +
        ", message='" + message + '\'' +
        '}';
  }
}
