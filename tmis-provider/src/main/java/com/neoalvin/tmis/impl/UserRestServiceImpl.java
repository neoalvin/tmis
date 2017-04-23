package com.neoalvin.tmis.impl;

import com.neoalvin.tmis.model.User;
import com.neoalvin.tmis.api.IUserRestService;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.neoalvin.tmis.api.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by alvin on 2017/4/17.
 */
@Path("users")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class UserRestServiceImpl implements IUserRestService{
  private IUserService userService;

  public void setUserService(IUserService userService) {
    this.userService = userService;
  }

  @GET
  @Path("{id : \\d+}")
  public User getUser(@PathParam("id") Long id) {
    if (RpcContext.getContext().getRequest(HttpServletRequest.class) != null) {
      System.out.println("Client IP address from RpcContext: " + RpcContext.getContext().getRequest(HttpServletRequest.class).getRemoteAddr());
    }
    if (RpcContext.getContext().getResponse(HttpServletResponse.class) != null) {
      System.out.println("Response object from RpcContext: " + RpcContext.getContext().getResponse(HttpServletResponse.class));
    }
    return userService.getUser(id);
  }

}
