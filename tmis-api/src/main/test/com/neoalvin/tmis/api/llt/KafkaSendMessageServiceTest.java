package com.neoalvin.tmis.api.llt;

import com.neoalvin.tmis.api.IKafkaSendMessageService;
import com.neoalvin.tmis.impl.KafkaSendMessageServiceImpl;
import com.neoalvin.tmis.model.kafka.SendKafkaMessageInput;
import org.junit.Test;

import java.util.Arrays;

/**
 * kafka发布消息测试类
 * Created by alvin on 2017/4/25.
 */
public class KafkaSendMessageServiceTest {

  //@Test
  public void testSendKafkaMessage(){
    IKafkaSendMessageService kafkaSendMessageService = new KafkaSendMessageServiceImpl();
    SendKafkaMessageInput input = new SendKafkaMessageInput();
    input.setTopicNameList(Arrays.asList("alvin_tmis_submit_topic"));
    for(int i = 0;i < 10;i++){
      input.setMessage("send from alvin: " + i);
      System.out.println("send from alvin: " + i);
      kafkaSendMessageService.sendKafkaMessage(input);
    }
    kafkaSendMessageService.close();
  }
}
