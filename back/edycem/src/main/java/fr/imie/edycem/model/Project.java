package fr.imie.edycem.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Project {

    private String name;
    private Integer id;

    public Project(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Project() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
