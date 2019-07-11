package fr.imie.edycem.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TimeSpent {

    @Id
    private int id;

    @Column(name = "project_id")
    private int project_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

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
