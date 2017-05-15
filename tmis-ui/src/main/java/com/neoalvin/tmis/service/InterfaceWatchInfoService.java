package com.neoalvin.tmis.service;

import com.neoalvin.tmis.model.InterfaceWatchInfo;

/**
 * Created by alvin on 2017/4/26.
 */
public interface InterfaceWatchInfoService {
  InterfaceWatchInfo selectInterfaceWatchInfo();
  void addInterfaceCallCount();
  void addInterfaceCount();
}
