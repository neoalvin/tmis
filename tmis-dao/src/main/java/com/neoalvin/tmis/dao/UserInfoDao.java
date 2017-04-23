package com.neoalvin.tmis.dao;

import com.neoalvin.tmis.model.RetCode;
import com.neoalvin.tmis.model.UserInfo;

/**
 * 用户信息Dao接口
 * Created by alvin on 2017/4/23.
 */
public interface UserInfoDao {
  UserInfo selectUserInfoById(String userId);
  void addUserInfo(UserInfo userInfo);
}
