package com.raghu.dashboard.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raghu.dashboard.dao.ITaskDAO;
import com.raghu.dashboard.vo.Task;


@Controller
@RequestMapping( value = "/dboard" )
public class TaskController {
	
	@Autowired
	ITaskDAO taskDao;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Task> findAll() {
		List<Task> list= taskDao.findAll();
		System.out.println(list);
		return list;
	}

}
