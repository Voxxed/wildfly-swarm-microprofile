package com.example.JECdemo.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import java.time.LocalDateTime;

/**
 * Created by katharinevoxxed on 25/01/2017.
 */
@ApplicationScoped
public class DateProducer {
    @Produces
    LocalDateTime getDateTimeNow() {
        return LocalDateTime.now();
    }
}