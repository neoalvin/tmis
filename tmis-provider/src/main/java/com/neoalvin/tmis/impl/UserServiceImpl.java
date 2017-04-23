package com.neoalvin.tmis.impl;

import com.neoalvin.tmis.api.IUserService;
import com.neoalvin.tmis.model.User;

/**
 * Created by alvin on 2017/4/17.
 */
public class UserServiceImpl implements IUserService{
  public User getUser(Long id) {
    return new User(id, "username" + id);
  }
}
