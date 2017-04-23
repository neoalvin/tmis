package com.neoalvin.tmis.validator;

import com.neoalvin.tmis.dao.impl.UserInfoDaoImpl;
import com.neoalvin.tmis.model.RetCode;
import com.neoalvin.tmis.model.UserInfo;

/**
 * 用户信息校验类
 * Created by alvin on 2017/4/23.
 */
public abstract class UserInfoValidator {

  /**
   * 校验用户信息参数格式
   * @param userInfo
   * @return
   */
  public static RetCode checkUserInfo(UserInfo userInfo){
    RetCode retCode = new RetCode();
    return retCode;
  }

  /**
   * 校验用户信息
   * @param userInfo
   * @return
   */
  public static RetCode validateUserByIdAndPwd(UserInfo userInfo){
    //定义返回信息对象
    RetCode retCode = new RetCode();

    //查询用户信息
    UserInfoDaoImpl userInfoDaoImpl = new UserInfoDaoImpl();
    UserInfo userInfoDb = userInfoDaoImpl.selectUserInfoById(userInfo.getUserId());

    //数据库中不存在用户信息
    if(null == userInfoDb){
      retCode.setCode("1");
      retCode.setMessage("[UserInfoValidator]: User information dose not exist.");
    }
    //密码不一致
    else if(!(userInfoDb.getPwdCode().equals(userInfo.getPwdCode()))){
      retCode.setCode("1");
      retCode.setMessage("[UserInfoValidator]: User password is wrong.");
    }

    return retCode;
  }
}
