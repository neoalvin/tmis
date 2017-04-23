package com.neoalvin.tmis.api;

import com.neoalvin.tmis.model.RetCode;
import com.neoalvin.tmis.model.UserInfo;

import javax.ws.rs.Path;

/**
 * 用户认证接口
 * Created by alvin on 2017/4/23.
 */
public interface IUserAuthService {
  /**
   * 注册用户
   * @param userInfo
   * @return
   */
  RetCode registryUser(UserInfo userInfo);

  /**
   * 验证用户
   * @param userInfo
   * @return
   */
  RetCode validateUser(UserInfo userInfo);

}
