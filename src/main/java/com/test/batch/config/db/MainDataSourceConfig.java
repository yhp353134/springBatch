package com.test.batch.config.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class MainDataSourceConfig {

    @Bean(name = "mainDataSource")
    @Qualifier("mainDataSource")
    public DataSource mainDataSource(@Qualifier("mainDataSourceProperties") MainDataSourceProperties mainDataSourceProperties) {
    	DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(mainDataSourceProperties.getDriverClassName());
		dataSource.setUrl(mainDataSourceProperties.getUrl());
//		dataSource.setUsername("root");
		dataSource.setUsername(mainDataSourceProperties.getUsername());
		dataSource.setPassword(mainDataSourceProperties.getPassword());
		dataSource.setMaxActive(mainDataSourceProperties.getMaxActive());
		dataSource.setInitialSize(mainDataSourceProperties.getInitialSize());
		dataSource.setMinIdle(mainDataSourceProperties.getMinIdle());
		dataSource.setRemoveAbandoned(mainDataSourceProperties.getRemoveAbandoned());
		dataSource.setRemoveAbandonedTimeout(mainDataSourceProperties.getRemoveAbandonedTimeout());
		dataSource.setLogAbandoned(mainDataSourceProperties.getLogAbandoned());
		return dataSource;
    }

    @Bean(name = "mainJdbcTemplate")
    public JdbcTemplate mainJdbcTemplate(
            @Qualifier("mainDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate(
            @Qualifier("mainDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "namedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(
            @Qualifier("jdbcTemplate") JdbcTemplate jdbcTemplate) {
        return new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    // 其中 dataSource 框架会自动为我们注入
    @Bean
    public PlatformTransactionManager txManager(@Qualifier("mainDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}