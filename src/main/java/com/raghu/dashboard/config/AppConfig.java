package com.raghu.dashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.raghu.dashboard.dao.ITaskDAO;
import com.raghu.dashboard.dao.TaskDAOImpl;


//@Import(value = { MongoConfiguration.class })
@Configuration
public class AppConfig {

	@Bean(name = "taskDao")
	public ITaskDAO taskDao() {
		return new TaskDAOImpl();
	}
	
	
}
