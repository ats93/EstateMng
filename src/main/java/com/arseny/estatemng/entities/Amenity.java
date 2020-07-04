package com.arseny.estatemng.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Amenity {
    @Id
    @Column(unique = true)
    private String cod;

    private String name;

    public String getName() {
        return name;
    }

    public String getCod() {
        return cod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCod(String cod) {
        this.cod = cod.toUpperCase();
    }
}
