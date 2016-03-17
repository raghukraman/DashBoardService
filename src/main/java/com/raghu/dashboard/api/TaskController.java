package com.raghu.dashboard.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.dashboard.service.IDashBoardService;
import com.raghu.dashboard.vo.Page;
import com.raghu.dashboard.vo.TaskInfo;

@RestController
@RequestMapping(value = "/dboard")
public class TaskController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	IDashBoardService dashboardService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TaskInfo> findAll() {
		logger.info("Calling the findAll1()");
		TaskInfo taskInfo = dashboardService.getAllTask();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		ResponseEntity<TaskInfo> entity = new ResponseEntity<TaskInfo>(taskInfo,
				headers, HttpStatus.OK);
		logger.info("entity is := " + entity);
		return entity;
	}
	
	
	@RequestMapping(value = "/tlist", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<TaskInfo> find(@RequestBody Page page) {
		logger.info("Calling the findAll1()");
		TaskInfo taskInfo = dashboardService.getTask(page);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<TaskInfo> entity = new ResponseEntity<TaskInfo>(taskInfo,
				headers, HttpStatus.OK);
		logger.info("entity is := " + entity);
		return entity;
	}

}
