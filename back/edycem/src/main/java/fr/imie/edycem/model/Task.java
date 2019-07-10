package fr.imie.edycem.model;

<<<<<<< HEAD
import fr.imie.edycem.model.Enum.Progress;

import javax.persistence.*;
import java.util.Date;
=======
import fr.imie.edycem.util.Progress;

import javax.persistence.*;
import java.sql.Date;
>>>>>>> create tasks

@Entity
public class Task {

    @Id
    @GeneratedValue
<<<<<<< HEAD
    private int id;
=======
    private Integer id;
>>>>>>> create tasks

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
<<<<<<< HEAD
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "progress")
    private Progress progress;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id")
    private Activity activity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
=======
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "progress")
    private String progress;

    /*@ManyToOne
    @Column(name = "activity_id")
    private Activity activity;*/
>>>>>>> create tasks
}
