package fr.imie.edycem.model;

import javax.persistence.*;
import java.time.Year;
import java.util.Date;

@Entity
@Table(name = "information_section")
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

    @Column(name = "deadline" , length = 10)
    private String deadline;

    @Column(name = "objectives" , length = 500)
    private String objectives;

    @Column(name = "confidentiality_contract")
    private boolean isConfidentialityContract;

    @Column(name = "license")
    private boolean isLicence;

    @Column(name = "patent")
    private boolean isPatent;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
