package com.neoalvin.tmis.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.neoalvin.tmis.api.IUserAuthService;
import com.neoalvin.tmis.common.CommonConstants;
import com.neoalvin.tmis.common.DataSecurityCommonUtil;
import com.neoalvin.tmis.common.ValidateCommonUtil;
import com.neoalvin.tmis.dao.impl.UserInfoDaoImpl;
import com.neoalvin.tmis.model.RetCode;
import com.neoalvin.tmis.model.UserInfo;
import com.neoalvin.tmis.validator.UserInfoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 用户认证相关操作实现类
 * Created by alvin on 2017/4/23.
 */
@Path("user")
public class UserAuthServiceImpl implements IUserAuthService{
  /**
   * 定义对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthServiceImpl.class);


  /**
   * 注册用户
   * @param userInfo
   * @return
   */
  @POST
  @Path("registryUser")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
  public RetCode registryUser(UserInfo userInfo) {
    //定义返回对象
    RetCode retCode = new RetCode();

    try {
      //入参判空
      if ((null == userInfo) || ValidateCommonUtil.isStringEmpty(userInfo.getUserId())) {
        retCode.setCode("1");
        retCode.setMessage("User information is null.");
        LOGGER.error("[UserAuthServiceImpl]: Registry user failed, user information is null.");
      }

      //入口日志，打印用户ID
      LOGGER.info("[UserAuthServiceImpl]: Start to add user information. userId = " + userInfo.getUserId());

      //校验用户信息格式，校验失败则直接返回错误码
      retCode = UserInfoValidator.checkUserInfo(userInfo);
      if (CommonConstants.RETCODE_ERROR.equals(retCode.getCode())) {
        return retCode;
      }

      //加密明文密码
      userInfo.setPwdCode(DataSecurityCommonUtil.EncoderByMd5(userInfo.getPwdCode()));

      //添加用户信息
      UserInfoDaoImpl userInfoDaoImpl = new UserInfoDaoImpl();
      userInfoDaoImpl.addUserInfo(userInfo);

      LOGGER.info("[UserAuthServiceImpl]: Add user information successfully!");
    }
    catch(Exception e){
      retCode.setCode("1");
      retCode.setMessage(e.toString());
      LOGGER.info("[UserAuthServiceImpl]: Add user information error. " + e.toString());
    }
    return retCode;
  }

  /**
   * 验证用户
   * @param userInfo
   * @return
   */
  @POST
  @Path("validateUser")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
  public RetCode validateUser(UserInfo userInfo) {
    //定义返回信息对象
    RetCode retCode = new RetCode();

    try {
      //入参判空
      if ((null == userInfo) || ValidateCommonUtil.isStringEmpty(userInfo.getUserId())) {
        retCode.setCode("1");
        retCode.setMessage("User information is null.");
        LOGGER.error("[UserAuthServiceImpl]: Validate user failed, user information is null.");
      }

      //入口日志，打印用户ID
      LOGGER.info("[UserAuthServiceImpl]: Start to validate user information. userId = " + userInfo.getUserId());

      //校验用户信息格式，校验失败则直接返回错误码
      retCode = UserInfoValidator.checkUserInfo(userInfo);
      if (CommonConstants.RETCODE_ERROR.equals(retCode.getCode())) {
        return retCode;
      }

      //加密明文密码
      userInfo.setPwdCode(DataSecurityCommonUtil.EncoderByMd5(userInfo.getPwdCode()));

      //验证用户信息
      retCode = UserInfoValidator.validateUserByIdAndPwd(userInfo);
    }
    catch(Exception e){
      retCode.setCode("1");
      retCode.setMessage(e.toString());
      LOGGER.info("[UserAuthServiceImpl]: Validate user information error. " + e.toString());

    }
    return retCode;
  }
}
