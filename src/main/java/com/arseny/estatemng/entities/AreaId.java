package com.arseny.estatemng.entities;

import java.io.Serializable;

public class AreaId implements Serializable {
    private static final long serialVersionUID = -1838164000751093186L;
    private String cod;
    private City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
