package com.neoalvin.tmis.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.neoalvin.tmis.api.IUserAuthRestService;
import com.neoalvin.tmis.api.IUserAuthService;
import com.neoalvin.tmis.model.RetCode;
import com.neoalvin.tmis.model.UserInfo;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 用户认证相关操作REST实现类
 * Created by alvin on 2017/4/24.
 */
@Path("user")
public class UserAuthRestServiceImpl implements IUserAuthRestService{
  /**
   * 定义用户认证操作服务类对象
   */
  private IUserAuthService userAuthService;

  /**
   * 设置IUserAuthService对象
   * @param userAuthService
   */
  public void setUserAuthService(IUserAuthService userAuthService){
    this.userAuthService = userAuthService;
  }

  /**
   * 注册用户
   * @param userInfo
   * @return
   */
  @POST
  @Path("registryUser")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
  public RetCode registryUser(UserInfo userInfo) {
    return userAuthService.registryUser(userInfo);
  }

  /**
   * 验证用户
   * @param userInfo
   * @return
   */
  @POST
  @Path("validateUser")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
  public RetCode validateUser(UserInfo userInfo) {
    return userAuthService.validateUser(userInfo);
  }
}
