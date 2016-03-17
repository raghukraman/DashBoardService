package com.raghu.dashboard.dao;

import java.util.List;

import com.raghu.dashboard.vo.Page;
import com.raghu.dashboard.vo.Task;

public interface ITaskDAO {
	
	public List<Task> findAll();
	
	abstract public List<Task> find(Page page);
	
	abstract public Long findTotalCount();

}
