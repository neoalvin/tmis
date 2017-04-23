package com.neoalvin.tmis.api;

import com.neoalvin.tmis.model.User;
/**
 * Created by alvin on 2017/4/17.
 */
public interface IUserService {
  User getUser(Long id);
}
