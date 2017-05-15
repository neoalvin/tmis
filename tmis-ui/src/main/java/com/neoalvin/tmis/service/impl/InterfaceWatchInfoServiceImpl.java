package com.neoalvin.tmis.service.impl;

import com.neoalvin.tmis.dao.InterfaceWatchInfoDao;
import com.neoalvin.tmis.model.InterfaceWatchInfo;
import com.neoalvin.tmis.service.InterfaceWatchInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by alvin on 2017/4/26.
 */
@Service
public class InterfaceWatchInfoServiceImpl implements InterfaceWatchInfoService{

  @Resource
  InterfaceWatchInfoDao interfaceWatchInfoDao;

  public InterfaceWatchInfo selectInterfaceWatchInfo() {
    return interfaceWatchInfoDao.selectInterfaceWatchInfo();
  }

  public void addInterfaceCallCount() {
    interfaceWatchInfoDao.addInterfaceCallCount();
  }

  public void addInterfaceCount() {
    interfaceWatchInfoDao.addInterfaceCount();
  }
}
