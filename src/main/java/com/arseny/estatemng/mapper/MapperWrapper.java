package com.arseny.estatemng.mapper;

import com.arseny.estatemng.dto.*;
import com.arseny.estatemng.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper
public interface MapperWrapper {

    @Mapping(source = "cod", target = "ref")
    EstateDTO convert(Estate estate);

    @Mapping(source = "ref", target = "cod")
    Estate convert(EstateDTO dto);

    @Mapping(source = "name", target = "cod")
    Amenity convert(AmenityDTO dto);

    @Mapping(source = "name", target = "cod")
    @Mapping(source = "city", target = "city.cod")
    Area convert(AreaDTO area);

    @Mapping(source = "name", target = "cod")
    TypeEstate convert(TypeDTO dto);

    @Mapping(source = "name", target = "cod")
    City convert(CityDTO dto);
}
