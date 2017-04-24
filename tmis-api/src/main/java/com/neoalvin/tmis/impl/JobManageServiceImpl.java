package com.neoalvin.tmis.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.neoalvin.tmis.api.IJobManageService;
import com.neoalvin.tmis.common.CommonConstants;
import com.neoalvin.tmis.model.RetCode;
import com.neoalvin.tmis.model.UserInfo;
import com.neoalvin.tmis.model.job.AuthData;
import com.neoalvin.tmis.model.job.CommitJobInput;
import com.neoalvin.tmis.model.job.CommitJobOutput;
import com.neoalvin.tmis.validator.JobManageValidator;
import com.neoalvin.tmis.validator.UserAuthValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 作业操作实现类
 * Created by alvin on 2017/4/23.
 */
@Path("job")
public class JobManageServiceImpl implements IJobManageService{
  /**
   * 定义日志对象
   */
  private static final Logger LOGGER = LoggerFactory.getLogger(JobManageServiceImpl.class);

  /**
   * 提交作业
   * @param input
   * @return
   */
  @POST
  @Path("commitJob")
  @Consumes({MediaType.APPLICATION_JSON})
  @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
  public CommitJobOutput commitJob(CommitJobInput input) {
    //定义返回对象
    CommitJobOutput output = new CommitJobOutput();

    //判断入参是否为null
    if(null == input){
      output.setResultCode(1);
      output.setDecription("input is null.");
      LOGGER.error("[IJobManageService]: Commit job failed, input is null.");
    }

    //入口日志，打印入参
    LOGGER.info("[IJobManageService]: Start to commit job. input = " + input.toString());

    //入参校验, 认证失败则直接返回
    RetCode retCode = JobManageValidator.validateCommitJobInput(input);
    if(CommonConstants.RETCODE_ERROR.equals(retCode.getCode()))
    {
      LOGGER.error("[IJobManageService]: Check commit job input failed, " + retCode.getMessage());
      output.setResultCode(1);
      output.setDecription(retCode.getMessage());
      return output;
    }

    //用户验证
    UserInfo userInfo = convertAuthDataToUserInfo(input.getAuthData());
    retCode = UserAuthValidator.validateUserByIdAndPwd(userInfo);
    if(CommonConstants.RETCODE_ERROR.equals(retCode.getCode()))
    {
      LOGGER.error("[IJobManageService]: Validate user failed, " + retCode.getMessage());
      output.setResultCode(1);
      output.setDecription(retCode.getMessage());
      return output;
    }

    //TODO 作业提交过程

    return output;
  }


  /**
   * 将AuthData转换为UserInfo
   * @param authData
   * @return
   */
  private UserInfo convertAuthDataToUserInfo(AuthData authData){
    return new UserInfo(authData.getBusinessId(), authData.getBusinessPwd());
  }
}
