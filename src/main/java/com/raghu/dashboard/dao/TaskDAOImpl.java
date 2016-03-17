package com.raghu.dashboard.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.raghu.dashboard.vo.Page;
import com.raghu.dashboard.vo.Task;

@Repository
public class TaskDAOImpl implements ITaskDAO {

	@Autowired
	MongoTemplate mongoTemplate;

	private Logger logger = Logger.getLogger(this.getClass());

	public List<Task> findAll() {
		logger.info("Calling the findAll()");
		Query searchUserQuery = new Query();
		return mongoTemplate.find(searchUserQuery, Task.class);
	}

	public List<Task> find(Page page) {
		logger.info("Calling the find() by page " + page);
		Query query = new Query();
		if (page.getPageNumber() != 1) {
			query.skip((page.getPageNumber()-1) * page.getRowsPerPage());
		}
		query.limit(page.getRowsPerPage());
		return mongoTemplate.find(query, Task.class);
	}
	
	public Long findTotalCount() {
		logger.info("Calling the findAll()");
		Query searchUserQuery = new Query();
		return mongoTemplate.count(searchUserQuery, Task.class);
	}

}
