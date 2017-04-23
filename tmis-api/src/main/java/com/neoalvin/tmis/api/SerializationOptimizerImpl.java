package com.neoalvin.tmis.api;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.neoalvin.tmis.model.UserInfo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alvin on 2017/4/17.
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

  public Collection<Class> getSerializableClasses() {
    List<Class> classes = new LinkedList<Class>();
    classes.add(UserInfo.class);
    return classes;
  }
}
