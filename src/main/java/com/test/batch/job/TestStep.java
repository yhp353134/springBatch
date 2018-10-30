package com.test.batch.job;

import com.test.batch.entry.RequestModel;
import com.test.batch.entry.ReturnModel;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestStep {

	@Autowired
	@Qualifier("testReader")
	ItemReader<RequestModel> testReader;

	@Autowired
	@Qualifier("testProcessor")
	ItemProcessor<RequestModel, ReturnModel> testProcessor;

	@Autowired
	@Qualifier("testWriter")
	ItemWriter<ReturnModel> testWriter;

	@Bean
	public Step testStepRun(StepBuilderFactory step) {
		return step.get("testStepRun")
				.<RequestModel, ReturnModel>chunk(1000)
				.reader(testReader)
				.processor(testProcessor)
				.writer(testWriter)
				.build();
	}

}
