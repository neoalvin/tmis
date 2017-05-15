package com.neoalvin.tmis.api;

import com.neoalvin.tmis.model.task.SubmitTaskInput;
import com.neoalvin.tmis.model.task.TaskResultInfo;

/**
 * Created by alvin on 2017/4/26.
 */
public interface ITaskManageRestService {
  TaskResultInfo submitTask(SubmitTaskInput input);
  TaskResultInfo queryTaskStatus(String taskId);
}
