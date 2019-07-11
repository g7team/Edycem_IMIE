package com.imie.g7.edycem_android.database.entity;

public class Project {

    private int id;
    private String society;
    private String name;
    private int userId;

    public Project() {
    }

    public Project(int id, String society, String name, int userId) {
        this.id = id;
        this.society = society;
        this.name = name;
        this.userId = userId;
    }

    public Project(String society, String name, int userId) {
        this.society = society;
        this.name = name;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
