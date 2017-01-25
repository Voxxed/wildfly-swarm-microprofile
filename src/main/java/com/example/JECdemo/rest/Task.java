package com.example.JECdemo.rest;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;

@RequestScoped
public class Task {

    @Inject
    TaskDeadline taskDeadline;

    private String taskTitle;
    private LocalDateTime deadline;

    @PostConstruct
    public void setTaskDeadline() {
        this.deadline = taskDeadline.twoHoursFromNow();
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    @Override
    public String toString() {
        String deadlineStr = deadline.toString();
        return taskTitle + ", deadline: " + deadlineStr;
    }

    public String getTaskTitle() {
        return taskTitle;
    }
    public LocalDateTime getDeadline() {
        return deadline;
    }
}
