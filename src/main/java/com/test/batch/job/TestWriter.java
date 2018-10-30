package com.test.batch.job;


import com.fbank.batch.base.writer.BaseWriter;
import com.test.batch.entry.ReturnModel;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.stereotype.Component;

@Component
public class TestWriter extends BaseWriter<ReturnModel> {

	@Override
	public void doWrite(ReturnModel item, JobParameters params, ExecutionContext stepContext) throws Exception {
		System.out.println("writer请求参数=" + item);
		System.out.println("writer请求的JOB参数" + stepContext);
	}

}
