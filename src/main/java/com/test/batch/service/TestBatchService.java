package com.test.batch.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TestBatchService {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier("testJob")
	private Job testJob;

	public void testJob() {
		try {
			JobParameters parameters = new JobParametersBuilder()
					.addString("reconciliationDate", "2018-10-30")
					.addString("batchNumber", "13233")
					.addString("single", "false")
					.addDate("date", new Date())
					.toJobParameters();
			jobLauncher.run(testJob, parameters);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
