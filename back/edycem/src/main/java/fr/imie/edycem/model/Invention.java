package fr.imie.edycem.model;

import javax.persistence.*;

@Entity
public class Invention {

    @Id
    @GeneratedValue
    private Integer id;


    private String brevet_name;

    private String inventor_name;

    private String inpi;

    private String rights_brevet;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrevet_name() {
        return brevet_name;
    }

    public void setBrevet_name(String brevet_name) {
        this.brevet_name = brevet_name;
    }

    public String getInventor_name() {
        return inventor_name;
    }

    public void setInventor_name(String inventor_name) {
        this.inventor_name = inventor_name;
    }

    public String getInpi() {
        return inpi;
    }

    public void setInpi(String inpi) {
        this.inpi = inpi;
    }

    public String getRights_brevet() {
        return rights_brevet;
    }

    public void setRights_brevet(String rights_brevet) {
        this.rights_brevet = rights_brevet;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
