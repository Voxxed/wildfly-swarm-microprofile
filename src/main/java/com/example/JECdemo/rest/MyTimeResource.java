package com.example.JECdemo.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.time.LocalDateTime;

/**
 * Created by katharinevoxxed on 25/01/2017.
 */
@Path("/")
@RequestScoped
public class MyTimeResource {
    @Inject
    DateProducer dateProducer;

    @GET
    @Path("/datetime")
    @Produces("text/plain")
    public String getTime() {
        LocalDateTime timeNow = dateProducer.getDateTimeNow();
        return timeNow.toString();
    }
}