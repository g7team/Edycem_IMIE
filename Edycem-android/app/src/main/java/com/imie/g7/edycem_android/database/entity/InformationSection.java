package com.imie.g7.edycem_android.database.entity;

public class InformationSection {

    private int id;
    private int annee;
    private String priorite;
    private String project;
    private String site;
    private String deadline;
    private String objectives;
    private boolean chaire;
    private boolean confidentialityContract;
    private boolean licence;
    private boolean brevet;
    private int projectId;

    public InformationSection() {
    }

    public InformationSection(int id, int annee, String priorite, String project, String site,
                                 String deadline, String objectives, boolean chaire,
                                 boolean confidentialityContract, boolean licence, boolean brevet,
                                 int projectId) {
        this.id = id;
        this.annee = annee;
        this.priorite = priorite;
        this.project = project;
        this.site = site;
        this.deadline = deadline;
        this.objectives = objectives;
        this.chaire = chaire;
        this.confidentialityContract = confidentialityContract;
        this.licence = licence;
        this.brevet = brevet;
        this.projectId = projectId;
    }

    public InformationSection(int annee, String priorite, String project, String site,
                                 String deadline, String objectives, boolean chaire,
                                 boolean confidentialityContract, boolean licence, boolean brevet,
                                 int projectId) {
        this.annee = annee;
        this.priorite = priorite;
        this.project = project;
        this.site = site;
        this.deadline = deadline;
        this.objectives = objectives;
        this.chaire = chaire;
        this.confidentialityContract = confidentialityContract;
        this.licence = licence;
        this.brevet = brevet;
        this.projectId = projectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public boolean isChaire() {
        return chaire;
    }

    public void setChaire(boolean chaire) {
        this.chaire = chaire;
    }

    public boolean isConfidentialityContract() {
        return confidentialityContract;
    }

    public void setConfidentialityContract(boolean confidentialityContract) {
        this.confidentialityContract = confidentialityContract;
    }

    public boolean isLicence() {
        return licence;
    }

    public void setLicence(boolean licence) {
        this.licence = licence;
    }

    public boolean isBrevet() {
        return brevet;
    }

    public void setBrevet(boolean brevet) {
        this.brevet = brevet;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

}
