package com.test.batch.job;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestBatchJob {

	@Bean
	public Job testJob(JobBuilderFactory job,
					@Qualifier("testStepRun") Step testStepRun) {
		return job.get("testJob").incrementer(new RunIdIncrementer())
				.flow(testStepRun)
				.end()
				.build();
	}

}
