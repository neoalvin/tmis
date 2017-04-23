package com.neoalvin.tmis.api;

import com.neoalvin.tmis.model.User;

import javax.validation.constraints.Min;

/**
 * Created by alvin on 2017/4/17.
 */
public interface IUserRestService {
  User getUser(@Min(value = 1L, message = "User ID must be greater than 1") Long id);
}
