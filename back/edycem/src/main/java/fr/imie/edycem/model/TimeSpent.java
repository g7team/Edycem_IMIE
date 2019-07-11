package fr.imie.edycem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "time_spent")
public class TimeSpent {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "project_id" ,  insertable =false , updatable = false)
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "hours")
    private double hours;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "description")
    private String description;

}
