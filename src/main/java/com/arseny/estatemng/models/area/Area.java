package com.arseny.estatemng.models.area;



import com.arseny.estatemng.models.city.City;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@IdClass(AreaId.class)
public class Area implements Serializable {

    private static final long serialVersionUID = -1739120049212032252L;

    @Id
    @Column(unique = true)
    private String cod;

    @Id
    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "cod")
    private City city;

    private String name;

    public void setCod(String cod) {
        this.cod = cod.toUpperCase();
    }

    public String getCod() {
        return cod;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
