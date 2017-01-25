package com.example.JECdemo.rest;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/my-routine/{weekday}")
public class MyRoutineEndpoint {

    private static final JsonBuilderFactory jsonFactory = Json.createBuilderFactory(null);

    @Inject
    Task task;

    @GET
    @Produces("text/plain")
    public Response doGet(@PathParam("weekday") String weekday) {
        return Response.ok("Tasks for " + weekday).build();
    }

    //POST with basic response
    /*@POST
    @Consumes("text/plain")
    public Response doPost(String task) {
        //Save to task database
        return Response.ok("Todo :" + task).build();
    }*/

    //POST with injected task
    /*@POST
    @Consumes("text/plain")
    public Response doPost(String taskTitle) {
        task.setTaskTitle(taskTitle);
        //Save to task database
        return Response.ok("Todo: " + task.toString()).build();
    }*/

    //POST with JSON response
    @POST
    @Consumes("text/plain")
    public Response doPost(String taskTitle) {
        task.setTaskTitle(taskTitle);

        JsonObject json = jsonFactory.createObjectBuilder()
                .add("task", jsonFactory.createObjectBuilder()
                        .add("title", task.getTaskTitle())
                )
                .add("deadline", jsonFactory.createObjectBuilder()
                        .add("hour", task.getDeadline().getHour())
                        .add("minutes", task.getDeadline().getMinute())
                        .add("seconds", task.getDeadline().getSecond())
                )
                .build();
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

}