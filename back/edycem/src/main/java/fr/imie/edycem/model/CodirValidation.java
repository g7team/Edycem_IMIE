package fr.imie.edycem.model;

import javax.persistence.*;

@Entity
public class CodirValidation {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "favorable")
    private Boolean favorable;

    @Column(name = "description")
    private String description;

    @Column(name = "holdingDescription")
    private String holdingDescription;

    @ManyToOne
    @Column(name = "project_id")
    private Project project;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFavorable() {
        return favorable;
    }

    public void setFavorable(Boolean favorable) {
        this.favorable = favorable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHoldingDescription() {
        return holdingDescription;
    }

    public void setHoldingDescription(String holdingDescription) {
        this.holdingDescription = holdingDescription;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
