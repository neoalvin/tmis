package com.neoalvin.tmis.common;

import com.neoalvin.tmis.dao.InterfaceWatchInfoDao;
import com.neoalvin.tmis.dao.impl.InterfaceWatchInfoDaoImpl;

/**
 * Created by alvin on 2017/4/26.
 */
public abstract class InterfaceWatchCommonUtil {

  public static void addInterfaceCallCount(){
    InterfaceWatchInfoDao interfaceWatchInfoDao = new InterfaceWatchInfoDaoImpl();
    interfaceWatchInfoDao.addInterfaceCallCount();
  }
}
