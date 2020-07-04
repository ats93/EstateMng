package com.arseny.estatemng.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class City {
    @Id
    @Column(unique = true)
    private String cod;

    private String name;

    public void setCod(String cod) {
        this.cod = cod.toUpperCase();
    }
}
