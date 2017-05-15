package com.neoalvin.tmis.dao;

import com.neoalvin.tmis.model.InterfaceWatchInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by alvin on 2017/4/26.
 */
@Repository
public interface InterfaceWatchInfoDao {
  public InterfaceWatchInfo selectInterfaceWatchInfo();
  public void addInterfaceCallCount();
  public void addInterfaceCount();
}
