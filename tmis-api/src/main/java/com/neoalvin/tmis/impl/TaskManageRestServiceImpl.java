package com.neoalvin.tmis.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.neoalvin.tmis.api.ITaskManageRestService;
import com.neoalvin.tmis.api.ITaskManageService;
import com.neoalvin.tmis.model.task.SubmitTaskInput;
import com.neoalvin.tmis.model.task.TaskResultInfo;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by alvin on 2017/4/26.
 */
@Path("task")
public class TaskManageRestServiceImpl implements ITaskManageRestService{

  private ITaskManageService taskManageService;

  public void setTaskManageService(ITaskManageService taskManageService){
    this.taskManageService = taskManageService;
  }
  /**
   * 提交作业
   * @param input
   * @return
   */
  @POST
  @Path("submitTask")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
  public TaskResultInfo submitTask(SubmitTaskInput input) {
    return taskManageService.submitTask(input);
  }

  /**
   * 查询任务状态信息
   * @param taskId
   * @return
   */
  @GET
  @Path("taskstatus")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
  public TaskResultInfo queryTaskStatus(@RequestParam("taskId") String taskId){
    return taskManageService.queryTaskStatus(taskId);
  }
}
