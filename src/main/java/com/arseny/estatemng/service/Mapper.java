package com.arseny.estatemng.service;

import com.arseny.estatemng.dto.EstateDTO;
import com.arseny.estatemng.entities.Estate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Mapper {

    private ModelMapper eMapper;


    @Autowired
    private ObjectMapper jMapper;

    public Mapper(){
        eMapper = new ModelMapper();
        eMapper.createTypeMap(Estate.class, EstateDTO.class)
                .addMappings(mapper ->{
                    mapper.map(Estate::getCod, EstateDTO::setRef);
                });
        eMapper.createTypeMap(EstateDTO.class, Estate.class)
                .addMappings(mapper ->{
                    mapper.map(src -> src.getRef(), Estate::setCod);
                });
    }

    public EstateDTO entityToDto(Estate estate){
        return eMapper.map(estate, EstateDTO.class);
    }

    public Estate dtoToEntity(EstateDTO dto){
        return eMapper.map(dto, Estate.class);
    }

    public String entityToJson(Object entity) throws JsonProcessingException {
        return jMapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity);
    }

    public String entityToJson(List<?> entity) throws JsonProcessingException {
        return jMapper.writerWithDefaultPrettyPrinter().writeValueAsString(entity);
    }

    public Estate jsonToEstate(String json) throws JsonProcessingException {
        return jMapper.readValue(json, Estate.class);
    }


}
