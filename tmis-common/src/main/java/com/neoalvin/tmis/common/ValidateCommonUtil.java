package com.neoalvin.tmis.common;

/**
 * 校验公共类
 * Created by alvin on 2017/4/23.
 */
public abstract class ValidateCommonUtil {
  /**
   * 判断字符串是否为空
   * @param str
   * @return
   */
  public static boolean isStringEmpty(String str){
    return (null == str) || ("".equals(str));
  }
}
