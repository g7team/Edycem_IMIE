package fr.imie.edycem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TimeSpent {

    @Id
    private int id;

    @Column(name = "project_id")
    private int project_id;

    @Column(name = "task_id")
    private int task_id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "hours")
    private Date hours;

    @Column(name = "entry_date")
    private Date entryDate;

    @Column(name = "description")
    private String description;

    @Column(name = "project_id")
    private Integer projectId;

}
