package com.arseny.estatemng.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
//@IdClass(AreaId.class)
public class Area {

    @Id
    @Column(unique = true)
    private String cod;

//    @Id
//    @ManyToOne
//    @JoinColumn(name = "city", referencedColumnName = "cod")
//    private City city;

    private String name;

    public void setCod(String cod) {
        this.cod = cod.toUpperCase();
    }

//    public void setCity(City city) {
//        this.city = city;
//    }
}
