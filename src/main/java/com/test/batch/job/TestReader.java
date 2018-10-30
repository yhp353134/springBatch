package com.test.batch.job;

import com.test.batch.base.reader.BaseReader;
import com.test.batch.entry.RequestModel;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class TestReader extends BaseReader<RequestModel> {

	@Override
	public RequestModel read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		JobParameters jobParameters = this.stepExecution.getJobExecution().getJobParameters();
		System.out.println("reader请求JOB参数为="+jobParameters);
		RequestModel rm = new RequestModel();
		rm.setRequestId("123");
		System.out.println("reader返回的数据="+rm);
		return rm;
	}
}
