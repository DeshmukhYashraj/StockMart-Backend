package com.smartmart.app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataBaseConfig {
	@Bean(name="con")
	public JdbcTemplate getConn(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
