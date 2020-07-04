package com.arseny.estatemng.service;

import com.arseny.estatemng.entities.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Mapper {

    @Autowired
    private ObjectMapper jMapper;


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
