package com.example.JECdemo.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Produces;
import java.time.LocalDateTime;

@RequestScoped
public class TaskDeadline {

    @Produces
    public LocalDateTime twoHoursFromNow() {
        return LocalDateTime.now().plusHours(2);
    }
}
