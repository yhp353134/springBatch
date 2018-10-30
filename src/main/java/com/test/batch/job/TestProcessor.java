package com.test.batch.job;

import com.test.batch.base.processor.BaseProcessor;
import com.test.batch.entry.RequestModel;
import com.test.batch.entry.ReturnModel;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

@Component
public class TestProcessor extends BaseProcessor<RequestModel, ReturnModel>{

	@Override
	public ReturnModel doProcess(RequestModel input, JobParameters params, ExecutionContext stepContext) throws Exception {
		System.out.println("processor进来的参数="+input);
		System.out.println("processor请求的JOB参数="+params);
		ReturnModel rm = new ReturnModel();
		rm.setMessage("信息");
		rm.setCode("456");
		System.out.println("processor返回的数据="+rm);
		return rm;
	}

}
