package com.example.JECdemo.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorldEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("Hello from WildFly Swarm!").build();
	}
}

