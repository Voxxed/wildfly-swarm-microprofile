package com.example.JECdemo.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Produces;
import java.time.LocalDateTime;

/**
 * Created by katharinevoxxed on 24/01/2017.
 */
@RequestScoped
public class TaskDeadline {

    @Produces
    public LocalDateTime twoHoursFromNow() {
        return LocalDateTime.now().plusHours(2);
    }
}
