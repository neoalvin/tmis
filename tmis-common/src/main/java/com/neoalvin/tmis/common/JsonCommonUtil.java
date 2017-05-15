package com.neoalvin.tmis.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json转化
 * Created by alvin on 2017/4/25.
 */
public abstract class JsonCommonUtil {

  public static String convertObjectToJson(Object object) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(object);
  }
}
