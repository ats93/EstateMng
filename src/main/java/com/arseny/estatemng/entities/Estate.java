package com.arseny.estatemng.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;


@Entity
public class Estate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estate_seq")
    @GenericGenerator(
            name = "estate_seq",
            strategy = "com.arseny.estatemng.entities.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ES"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    private String cod;
    private String name;
    private Double originalPrice;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "cod")
    private TypeEstate type;
    private Boolean lowered;
    private String percentage;
    private String description;
    private Short bedrooms;
    private Short bathrooms;
    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "cod")
    private City city;
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "area", referencedColumnName = "cod", insertable = false, updatable = false),
            @JoinColumn(name = "city", referencedColumnName = "city", insertable = false, updatable = false)})
    private Area area;
    @ManyToMany
    private List<Amenity> amenities;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TypeEstate getType() {
        return type;
    }

    public void setType(TypeEstate type) {
        this.type = type;
    }

    public Boolean getLowered() {
        return lowered;
    }

    public void setLowered(Boolean lowered) {
        this.lowered = lowered;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
