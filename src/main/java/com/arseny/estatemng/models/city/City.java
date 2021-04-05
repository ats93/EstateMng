package com.arseny.estatemng.models.city;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
    @Id
    @Column(unique = true)
    private String cod;

    private String name;

    public void setCod(String cod) {
        this.cod = cod.toUpperCase();
    }

    public String getCod() {
        return cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
