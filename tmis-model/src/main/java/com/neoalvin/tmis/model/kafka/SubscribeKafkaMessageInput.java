package com.neoalvin.tmis.model.kafka;

/**
 * 订阅kafka消息入参
 * Created by alvin on 2017/4/25.
 */
public class SubscribeKafkaMessageInput {
  private String topicName;
  private String group;

  public String getTopicName() {
    return topicName;
  }

  public void setTopicName(String topicName) {
    this.topicName = topicName;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  @Override
  public String toString() {
    return "SubscribeKafkaMessageInput{" +
        "topicName='" + topicName + '\'' +
        ", group='" + group + '\'' +
        '}';
  }
}
