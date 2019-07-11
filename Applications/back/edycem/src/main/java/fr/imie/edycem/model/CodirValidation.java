package fr.imie.edycem.model;

import javax.persistence.*;

@Entity
@Table(name = "codir_validation")
public class CodirValidation {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "favorable")
    private Boolean favorable;

    @Column(name = "holding_description")
    private String holdingDescription;

    @OneToOne
    @JoinColumn(name = "project_id")
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

    public String getHoldingDescription() {
        return holdingDescription;
    }

    public void setHoldingDescription(String holdingDescription) {
        this.holdingDescription = holdingDescription;
    }

}
