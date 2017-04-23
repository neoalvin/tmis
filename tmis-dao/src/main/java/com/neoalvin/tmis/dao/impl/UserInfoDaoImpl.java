package com.neoalvin.tmis.dao.impl;

import com.neoalvin.tmis.dao.UserInfoDao;
import com.neoalvin.tmis.dao.util.TmisDaoUtil;
import com.neoalvin.tmis.model.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户信息操作实现类
 * Created by alvin on 2017/4/23.
 */
public class UserInfoDaoImpl implements UserInfoDao {
  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoDaoImpl.class);

  /**
   * 获得会话对象
   */
  private SqlSession session = TmisDaoUtil.getSession();

  /**
   * 获取用户信息
   * @param userId
   * @return
   */
  public UserInfo selectUserInfoById(String userId) {
    //入口日志
    LOGGER.info("[UserInfoDaoImpl]: Start to select user information. userId = " + userId);

    try {
      //通过MyBatis实现接口UserInfoDAO的查询用户方法
      UserInfoDao userInfoDao=session.getMapper(UserInfoDao.class);
      return userInfoDao.selectUserInfoById(userId);
    }
    finally{
      session.close();
    }
  }

  /**
   * 添加用户信息
   * @param userInfo
   * @return
   */
  public void addUserInfo(UserInfo userInfo) {
    //入口日志
    LOGGER.info("[UserInfoDaoImpl]: Start to add user information. userId = " + userInfo.getUserId());

    try {
      //通过MyBatis实现接口UserInfoDAO的添加用户方法
      UserInfoDao userInfoDao=session.getMapper(UserInfoDao.class);
      userInfoDao.addUserInfo(userInfo);
      LOGGER.info("[UserInfoDaoImpl]: Add user information successfully!");
    }
    catch(Exception e){
      LOGGER.error("[UserInfoDaoImpl]: Add user information failed. " + e.getMessage());
    }
    finally{
      session.close();
    }
  }
}
