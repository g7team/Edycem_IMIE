package com.imie.g7.edycem_android.database.entity;

import java.time.LocalDateTime;

public class TimeSpent {

    private int id;
    private int projectId;
    private int taskId;
    private int userId;
    private double hours;
    private LocalDateTime entryDate;
    private String description;

    public TimeSpent() {
    }

    public TimeSpent(int id, int projectId, int taskId, int userId, double hours,
                        LocalDateTime entryDate, String description) {
        this.id = id;
        this.projectId = projectId;
        this.taskId = taskId;
        this.userId = userId;
        this.hours = hours;
        this.entryDate = entryDate;
        this.description = description;
    }

    public TimeSpent(int projectId, int taskId, int userId, double hours,
                        LocalDateTime entryDate, String description) {
        this.projectId = projectId;
        this.taskId = taskId;
        this.userId = userId;
        this.hours = hours;
        this.entryDate = entryDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
