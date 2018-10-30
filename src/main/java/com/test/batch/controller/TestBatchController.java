package com.test.batch.controller;

import com.test.batch.service.TestBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/batch/")
public class TestBatchController {

	@Autowired
	private TestBatchService testBatchService;

	@RequestMapping("testJob")
	public void testJob() {
		testBatchService.testJob();
	}

}
