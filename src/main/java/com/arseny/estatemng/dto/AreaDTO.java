package com.arseny.estatemng.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AreaDTO {
    private String name;
//    private String city;

    public String getName() {
        return name;
    }

//    public String getCity() {
//        return city;
//    }
}
