package com.arseny.estatemng.mapper;

import com.arseny.estatemng.models.amenity.Amenity;
import com.arseny.estatemng.models.amenity.AmenityVO;
import com.arseny.estatemng.models.area.Area;
import com.arseny.estatemng.models.area.AreaVO;
import com.arseny.estatemng.models.city.City;
import com.arseny.estatemng.models.city.CityVO;
import com.arseny.estatemng.models.estate.Estate;
import com.arseny.estatemng.models.estate.EstateVO;
import com.arseny.estatemng.models.type.TypeEstate;
import com.arseny.estatemng.models.type.TypeVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MapperWrapper {

    EstateVO convert(Estate estate);

    Estate convert(EstateVO dto);

    @Mapping(source = "name", target = "cod")
    Amenity convert(AmenityVO dto);

    @Mapping(source = "name", target = "cod")
    @Mapping(source = "city", target = "city.cod")
    Area convert(AreaVO area);

    @Mapping(source = "name", target = "cod")
    TypeEstate convert(TypeVO dto);

    @Mapping(source = "name", target = "cod")
    City convert(CityVO dto);
}
