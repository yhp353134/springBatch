package com.test.batch.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class TestDao {

	@Autowired
	@Qualifier("mainJdbcTemplate")
	protected JdbcTemplate jdbcTemplate1;

	
	public void test(){
		Integer jdbc1 = jdbcTemplate1.queryForObject("select count(1) from user", Integer.class);
	}
}
