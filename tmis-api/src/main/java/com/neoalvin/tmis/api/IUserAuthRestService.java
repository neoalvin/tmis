package com.neoalvin.tmis.api;

import com.neoalvin.tmis.model.RetCode;
import com.neoalvin.tmis.model.UserInfo;

/**
 * 用户认证REST接口
 * Created by alvin on 2017/4/24.
 */
public interface IUserAuthRestService {
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
