package com.raghu.dashboard.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/dboard")
public class TaskService {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<p> Java WebService4</p>";
	}
	

}
