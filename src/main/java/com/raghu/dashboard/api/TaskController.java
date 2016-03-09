package com.raghu.dashboard.api;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.dashboard.dao.ITaskDAO;
import com.raghu.dashboard.vo.Task;

@RestController
@RequestMapping(value = "/dboard")
public class TaskController {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	ITaskDAO taskDao;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Task>> findAll() {
		logger.info("Calling the findAll1()");
		List<Task> list = taskDao.findAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		ResponseEntity<List<Task>> entity = new ResponseEntity<List<Task>>(list,
				headers, HttpStatus.OK);
		logger.info("entity is := " + entity);
		return entity;
	}

}
