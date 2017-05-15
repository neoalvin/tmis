package com.neoalvin.tmis.model.kafka;

/**
 * kafka消息记录
 * Created by alvin on 2017/4/25.
 */
public class KafkaMessageRecord {
  private Long offset;
  private String key;
  private String value;

  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "KafkaMessageRecord{" +
        "offset=" + offset +
        ", key='" + key + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
