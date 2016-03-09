package com.raghu.dashboard.vo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task")
public class Task {
	
    @Id
    private String id;
	
	private String name;
	
	private String createDate;
	
	private String user;
	
	private String status;
	
	
	public Task(String name, String createDate, String user, String status) {
		super();
		this.name = name;
		this.createDate = createDate;
		this.user = user;
		this.status = status;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getUser() {
		if (user==null) {
			user = "";
		}
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", createDate="
				+ createDate + ", user=" + getUser() + ", status=" + status + "]";
	}

	

}
