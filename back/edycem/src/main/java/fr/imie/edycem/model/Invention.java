package fr.imie.edycem.model;

import javax.persistence.*;

@Entity
@Table(name = "invention_section")
public class Invention {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "patent_name")
    private String patentName;

    @Column(name = "inventor_name")
    private String inventorName;

    @Column(name = "inpi")
    private String inpi;

    @Column(name = "patent_right")
    private String patentRight;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getInventorName() {
        return inventorName;
    }

    public void setInventorName(String inventorName) {
        this.inventorName = inventorName;
    }

    public String getInpi() {
        return inpi;
    }

    public void setInpi(String inpi) {
        this.inpi = inpi;
    }

    public String getPatentRight() {
        return patentRight;
    }

    public void setPatentRight(String patentRight) {
        this.patentRight = patentRight;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
