package com.arseny.estatemng.models.estate;

import com.arseny.estatemng.models.BasicVO;
import com.arseny.estatemng.models.amenity.AmenityVO;
import com.arseny.estatemng.models.type.TypeVO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstateVO extends BasicVO {
    private String name;
    private Double originalPrice;
    private Double price;
    private TypeVO type;
    private Boolean lowered;
    private String percentage;
    private String description;
    private Short bathrooms;
    private Short bedrooms;
    private List<AmenityVO> amenities;
}
