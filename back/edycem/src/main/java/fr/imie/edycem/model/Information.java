package fr.imie.edycem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Information {

    @Id
    @GeneratedValue
    private int id;


}
