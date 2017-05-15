package com.neoalvin.tmis.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * dubbo提供方
 *
 */
public class DubboProvider
{
  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(DubboProvider.class);

  /**
   * 定义context
   */
  private ClassPathXmlApplicationContext context = null;

  /**
   * 构造函数，初始化Context
   * @return
   */
  public DubboProvider(){
    if(null == context){
      LOGGER.warn("[DubboProducer]: Get context is null.");
      context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/*.xml");
    }
  }

  /**
   * 带参构造函数，初始化Context
   * @return
   */
  public DubboProvider(String configLocation){
    if(null == context){
      LOGGER.warn("[DubboProducer]: Get context is null.");
      context = new ClassPathXmlApplicationContext(configLocation);
    }
  }

  /**
   * 启动服务
   */
  public void start(){
    System.out.println("[DubboProducer]: Dubbo service is started.");
    LOGGER.info("[DubboProducer]: Dubbo service is started.");
    context.start();
  }

  public void close(){
    System.out.println("[DubboProducer]: Dubbo service is closed.");
    LOGGER.info("[DubboProducer]: Dubbo service is closed.");
    context.start();
  }

  /**
   * 测试
   * @param args
   * @throws IOException
   * @throws InterruptedException
   */
  public static void main(String[] args) throws IOException, InterruptedException{
    DubboProvider dubboProvider = new DubboProvider();
    dubboProvider.start();
    //Thread.sleep(600000);
    //dubboProvider.close();
  }
}
