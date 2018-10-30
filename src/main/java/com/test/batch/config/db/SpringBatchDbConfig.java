package com.test.batch.config.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class SpringBatchDbConfig {

	@Primary
    @Bean(name = "springBatchDataSource")
    @Qualifier("springBatchDataSource")
    public DataSource springBatchDataSource(@Qualifier("springBatchDataSourceProperties") SpringBatchDataSourceProperties springBatchDataSourceProperties) {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(springBatchDataSourceProperties.getDriverClassName());
		dataSource.setUrl(springBatchDataSourceProperties.getUrl());
//		dataSource.setUsername("root");
		dataSource.setUsername(springBatchDataSourceProperties.getUsername());
		dataSource.setPassword(springBatchDataSourceProperties.getPassword());
		dataSource.setMaxActive(springBatchDataSourceProperties.getMaxActive());
		dataSource.setInitialSize(springBatchDataSourceProperties.getInitialSize());
		dataSource.setMinIdle(springBatchDataSourceProperties.getMinIdle());
		dataSource.setRemoveAbandoned(springBatchDataSourceProperties.getRemoveAbandoned());
		dataSource.setRemoveAbandonedTimeout(springBatchDataSourceProperties.getRemoveAbandonedTimeout());
		dataSource.setLogAbandoned(springBatchDataSourceProperties.getLogAbandoned());
		return dataSource;
    }


    @Bean(name = "springBatchDataSourceJdbcTemplate")
    public JdbcTemplate springBatchDataSourceJdbcTemplate(
            @Qualifier("springBatchDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "springBatchDataSourceNamedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate springBatchDataSourceNamedParameterJdbcTemplate(
            @Qualifier("springBatchDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
    

}
