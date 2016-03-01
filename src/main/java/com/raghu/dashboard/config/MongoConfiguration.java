package com.raghu.dashboard.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		System.out.println("here2");
		return "dashboard";
	}

	@Override
	public Mongo mongo() throws Exception {
		System.out.println("here1");
		return new MongoClient("127.0.0.1", 27017);
	}
	

}
