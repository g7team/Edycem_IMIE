package fr.imie.edycem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< HEAD
import java.util.Date;
import fr.imie.edycem.model.Enum.*;

=======
import java.sql.Date;
>>>>>>> create activity

@Entity
public class Activity {

    @Id
    @GeneratedValue
<<<<<<< HEAD
    private int id;
=======
    private Integer id;
>>>>>>> create activity

    @Column(name = "name")
    private String name;

<<<<<<< HEAD
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "priority")
    private Priority priority;

    @Column(name = "progress")
    private Progress progress;

    @Column(name = "project_id")
    private int projectId;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
=======
>>>>>>> create activity
}
