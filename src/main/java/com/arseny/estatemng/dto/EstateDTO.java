package com.arseny.estatemng.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstateDTO {
    private String ref;
    private String name;
    private Double originalPrice;
    private Double price;
    private TypeDTO type;
    private Boolean lowered;
    private String percentage;
    private String description;
    private Short bathrooms;
    private Short bedrooms;
    private List<AmenityDTO> amenities;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
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

    public List<AmenityDTO> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<AmenityDTO> amenities) {
        this.amenities = amenities;
    }
}
