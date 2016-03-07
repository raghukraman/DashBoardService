package com.raghu.dashboard.api;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.dashboard.dao.ITaskDAO;
import com.raghu.dashboard.vo.Task;


@RestController
@RequestMapping( value = "/dboard" )
public class TaskController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	ITaskDAO taskDao;

	 @RequestMapping("/list")
	 @ResponseBody
	public List<Task> findAll() {
		logger.info("Calling the findAll()");
		List<Task> list= taskDao.findAll();
		logger.info("the list is :=" + list);
 		return list;
	}

}
