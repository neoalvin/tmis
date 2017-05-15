package com.neoalvin.tmis.api.llt;

import com.neoalvin.tmis.api.IkafkaSubscribeMessageService;
import com.neoalvin.tmis.impl.kafkaSubscribeMessageServiceImpl;
import com.neoalvin.tmis.model.kafka.KafkaMessageRecord;
import com.neoalvin.tmis.model.kafka.SubscribeKafkaMessageInput;
import org.junit.Test;

import java.util.List;

/**
 * kafka消息订阅服务测试类
 * Created by alvin on 2017/4/25.
 */
public class kafkaSubscribeMessageServiceTest {

  //@Test
  public void subscribekafkaMessageTest(){
    IkafkaSubscribeMessageService kafkaSubscribeMessageService = new kafkaSubscribeMessageServiceImpl();

    SubscribeKafkaMessageInput input = new SubscribeKafkaMessageInput();
    input.setTopicName("alvin_tmis_submit_topic");
    input.setGroup("alvin_group");
    while(true) {
      List<KafkaMessageRecord> recordList = kafkaSubscribeMessageService.subscribeKafkaMessage(input);
      System.out.println("Subcribe kafka message: " + recordList);
    }
  }
}
