package fr.imie.edycem.model;

import javax.persistence.*;

@Entity
public class Information {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "year")
    private int year;

    @Column(name = "priority" , length = 50)
    private String priority;

    @Column(name = "chaire")
    private boolean chaire;

    @Column(name = "echeance" , length = 10)
    private String echeance;

    @Column(name = "objective" , length = 500)
    private String objective;

    @Column(name = "isConfidentialityContract")
    private boolean isConfidentialityContract;

    @Column(name = "isLicence")
    private boolean isLicence;

    @Column(name = "isBrevet")
    private boolean isBrevet;

    @Column(name = "project_id")
    private int project_id;

}
