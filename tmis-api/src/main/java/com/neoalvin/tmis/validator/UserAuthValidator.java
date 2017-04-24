package com.neoalvin.tmis.validator;

import com.neoalvin.tmis.common.DataSecurityCommonUtil;
import com.neoalvin.tmis.dao.impl.UserInfoDaoImpl;
import com.neoalvin.tmis.model.RetCode;
import com.neoalvin.tmis.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * 用户信息校验类
 * Created by alvin on 2017/4/23.
 */
public abstract class UserAuthValidator {

  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthValidator.class);

  /**
   * 校验用户信息参数格式
   * @param userInfo
   * @return
   */
  public static RetCode checkUserInfo(UserInfo userInfo){
    //入口日志
    LOGGER.info("[UserInfoValidator]: start to check user information. userId = " + userInfo.getUserId());

    //定义返回信息对象
    RetCode retCode = new RetCode();

    //查询用户信息
    UserInfoDaoImpl userInfoDaoImpl = new UserInfoDaoImpl();

    //用户信息已存在
    if(null != userInfoDaoImpl.selectUserInfoById(userInfo.getUserId())){
      retCode.setCode("1");
      retCode.setMessage("user information does exists.");
      LOGGER.error("[UserInfoValidator]: User information does exists.");
    }
    return retCode;
  }

  /**
   * 校验用户信息
   * @param userInfo
   * @return
   */
  public static RetCode validateUserByIdAndPwd(UserInfo userInfo){
    //入口日志
    LOGGER.info("[UserInfoValidator]: Start to validate user information. userId = " + userInfo.getUserId());

    //定义返回信息对象
    RetCode retCode = new RetCode();

    //加密明文密码
    userInfo.setPwdCode(DataSecurityCommonUtil.EncoderByMd5(userInfo.getPwdCode()));

    //查询用户信息
    UserInfoDaoImpl userInfoDaoImpl = new UserInfoDaoImpl();
    UserInfo userInfoDb = userInfoDaoImpl.selectUserInfoById(userInfo.getUserId());

    //数据库中不存在用户信息
    if(null == userInfoDb){
      retCode.setCode("1");
      retCode.setMessage("user information does not exists.");
      LOGGER.error("[UserInfoValidator]: User information does not exist.");
    }
    //密码不一致
    else if(!(userInfoDb.getPwdCode().equals(userInfo.getPwdCode()))){
      retCode.setCode("1");
      retCode.setMessage("the password is wrong.");
      LOGGER.error("[UserInfoValidator]: User password is wrong.");
    }

    return retCode;
  }
}
