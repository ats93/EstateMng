package com.arseny.estatemng.controller;

import com.arseny.estatemng.dto.CityDTO;
import com.arseny.estatemng.entities.City;
import com.arseny.estatemng.service.CityService;
import com.arseny.estatemng.mapper.MapperWrapper;
import com.arseny.estatemng.service.Mapper;
import com.arseny.estatemng.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService service;

    @Autowired
    private MapperWrapper mapper;

    private Mapper jsonMapper;

    @PostMapping(value = "/city", produces = Constants.APP_JSON)
    public ResponseEntity<String> post(@RequestBody CityDTO city) throws Exception {
        City cityDTO = service.save(mapper.convert(city));
        return ResponseEntity.ok(jsonMapper.entityToJson(cityDTO));
    }
    @PostMapping(value = "/city/list", produces = Constants.APP_JSON)
    public ResponseEntity<String> post(@RequestBody List<CityDTO> dtoList) throws Exception {
        List<City> list = new ArrayList<>();
        dtoList.stream().forEach(o -> list.add(mapper.convert(o)));
        List<City> vo = service.save(list);
        return ResponseEntity.ok(jsonMapper.entityToJson(vo));
    }

    @GetMapping(value = "/city", produces = Constants.APP_JSON)
    public ResponseEntity<String> findAll() throws Exception{
        List<City> listVo = service.findAll();
        return ResponseEntity.ok(jsonMapper.entityToJson(listVo));
    }

    @DeleteMapping(value = "/city", produces = Constants.APP_JSON)
    public ResponseEntity<String> delete(@RequestBody List<City> listType) throws Exception {
        service.delete(listType);
        return ResponseEntity.noContent().build();
    }
}
