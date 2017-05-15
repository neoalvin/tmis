package com.neoalvin.tmis.impl;

import com.neoalvin.tmis.api.IUserAuthService;
import com.neoalvin.tmis.common.CommonConstants;
import com.neoalvin.tmis.common.DataSecurityCommonUtil;
import com.neoalvin.tmis.common.InterfaceWatchCommonUtil;
import com.neoalvin.tmis.common.ValidateCommonUtil;
import com.neoalvin.tmis.dao.impl.UserInfoDaoImpl;
import com.neoalvin.tmis.model.RetCode;
import com.neoalvin.tmis.model.UserInfo;
import com.neoalvin.tmis.validator.UserAuthValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户认证相关操作实现类
 * Created by alvin on 2017/4/23.
 */
public class UserAuthServiceImpl implements IUserAuthService {
  /**
   * 定义对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthServiceImpl.class);


  /**
   * 注册用户
   * @param userInfo
   * @return
   */
  public RetCode registryUser(UserInfo userInfo) {
    InterfaceWatchCommonUtil.addInterfaceCallCount();
    //定义返回对象
    RetCode retCode = new RetCode();

    try {
      //入参判空
      if ((null == userInfo) || ValidateCommonUtil.isStringEmpty(userInfo.getUserId())) {
        retCode.setCode("1");
        retCode.setMessage("user information is null.");
        LOGGER.error("[IUserAuthService]: Registry user failed, user information is null.");
      }

      //入口日志，打印用户ID
      LOGGER.info("[IUserAuthService]: Start to add user information. userId = " + userInfo.getUserId());

      //校验用户信息是否已存在，存在则直接返回错误码
      retCode = UserAuthValidator.checkUserInfo(userInfo);
      if (CommonConstants.RETCODE_ERROR.equals(retCode.getCode())) {
        return retCode;
      }

      //加密明文密码
      userInfo.setPwdCode(DataSecurityCommonUtil.EncoderByMd5(userInfo.getPwdCode()));

      //添加用户信息
      UserInfoDaoImpl userInfoDaoImpl = new UserInfoDaoImpl();
      userInfoDaoImpl.addUserInfo(userInfo);

      LOGGER.info("[IUserAuthService]: Add user information successfully!");
    }
    catch(Exception e){
      retCode.setCode("1");
      retCode.setMessage(e.toString());
      LOGGER.info("[IUserAuthService]: Add user information error. " + e.toString());
    }
    return retCode;
  }

  /**
   * 验证用户
   * @param userInfo
   * @return
   */
  public RetCode validateUser(UserInfo userInfo) {
    InterfaceWatchCommonUtil.addInterfaceCallCount();
    //定义返回信息对象
    RetCode retCode = new RetCode();

    try {
      //入参判空
      if ((null == userInfo) || ValidateCommonUtil.isStringEmpty(userInfo.getUserId())) {
        retCode.setCode("1");
        retCode.setMessage("user information is null.");
        LOGGER.error("[IUserAuthService]: Validate user failed, user information is null.");
      }

      //入口日志，打印用户ID
      LOGGER.info("[IUserAuthService]: Start to validate user information. userId = " + userInfo.getUserId());

      //验证用户信息
      retCode = UserAuthValidator.validateUserByIdAndPwd(userInfo);
    }
    catch(Exception e){
      retCode.setCode("1");
      retCode.setMessage(e.toString());
      LOGGER.info("[IUserAuthService]: Validate user information error. " + e.toString());

    }
    return retCode;
  }
}
