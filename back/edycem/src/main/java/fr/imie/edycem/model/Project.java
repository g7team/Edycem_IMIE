package fr.imie.edycem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Project {



    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;


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
