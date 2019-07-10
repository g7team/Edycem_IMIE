package fr.imie.edycem.model.Response;

import fr.imie.edycem.model.Project;

public class ProjectResponse extends Project {

    private Integer id;

    private String name;

    private String society;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSociety() {
        return society;
    }

    public void setSociety(String society) {
        this.society = society;
    }
}
