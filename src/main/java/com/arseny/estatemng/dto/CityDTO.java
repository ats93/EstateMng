package com.arseny.estatemng.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityDTO {
    private String name;

    public String getName() {
        return name;
    }
}
