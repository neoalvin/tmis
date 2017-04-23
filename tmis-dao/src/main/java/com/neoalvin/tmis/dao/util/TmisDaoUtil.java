package com.neoalvin.tmis.dao.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * 数据库相关操作
 * Created by alvin on 2017/4/23.
 */
public abstract class TmisDaoUtil {

  /**
   * 定义会话工厂对象，初始化为null
   */
  private static SqlSessionFactory factory = null;

  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(TmisDaoUtil.class);

  /**
   * 获取会话工厂
   * @return
   */
  public static SqlSessionFactory getSqlSessionFactory(){
    LOGGER.info("[TmisDaoUtil]: Start to get SqlSessionFactory.");
    if(null == factory){
      LOGGER.warn("[TmisDaoUtil]: Get SqlSessionFactory is null.");
      // 获得环境配置文件流
      InputStream config = TmisDaoUtil.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
      // 创建sql会话工厂
      factory = new SqlSessionFactoryBuilder().build(config);
    }
    LOGGER.info("[TmisDaoUtil]: Get SqlSessionFactory successfully.");
    return factory;
  }

  /**
   * 获取会话
   * @return
   */
  public static SqlSession getSession(){
    return getSqlSessionFactory().openSession(true);
  }

  /**
   * 获得sql会话
   * @param isAutoCommit 是否自动提交，如果为false则需要sqlSession.commit();rollback();
   * @return sql会话
   */
  public static SqlSession getSession(boolean isAutoCommit){
    return getSqlSessionFactory().openSession(isAutoCommit);
  }
}
