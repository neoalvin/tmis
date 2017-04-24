package com.neoalvin.tmis.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 数据安全公共类
 * Created by alvin on 2017/4/23.
 */
public abstract class DataSecurityCommonUtil {

  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(DataSecurityCommonUtil.class);
  /**
   * MD5加密
   * @param str 明文字符串
   * @return
   * @throws NoSuchAlgorithmException
   * @throws UnsupportedEncodingException
   */
  public static String EncoderByMd5(String str) {
    //入口日志
    LOGGER.info("[DataSecurityCommonUtil]: Encode the password start.");

    //定义加密后的密文字符串
    String pwdCode = null;

    try {

      //确定计算方法
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      BASE64Encoder base64en = new BASE64Encoder();

      //加密后的字符串
      pwdCode = base64en.encode(md5.digest(str.getBytes("utf-8")));
    }
    catch(Exception e){
      LOGGER.error("[DataSecurityCommonUtil]: Encode the password failed. " + e.toString());
    }
    return pwdCode;
  }
}
