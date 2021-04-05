package com.arseny.estatemng.controller;

import com.arseny.estatemng.models.city.City;
import com.arseny.estatemng.mapper.MapperWrapper;
import com.arseny.estatemng.service.CityService;
import com.arseny.estatemng.utils.Constants;
import com.arseny.estatemng.models.city.CityVO;
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

    @PostMapping(value = "/city", produces = Constants.APP_JSON)
    public ResponseEntity<City> post(@RequestBody CityVO city) throws Exception {
        City vo = service.save(mapper.convert(city));
        return ResponseEntity.ok(vo);
    }
    @PostMapping(value = "/city/list", produces = Constants.APP_JSON)
    public ResponseEntity<List<City>> post(@RequestBody List<CityVO> dtoList) throws Exception {
        List<City> list = new ArrayList<>();
        dtoList.stream().forEach(o -> list.add(mapper.convert(o)));
        List<City> vo = service.save(list);
        return ResponseEntity.ok(vo);
    }

    @GetMapping(value = "/city", produces = Constants.APP_JSON)
    public ResponseEntity<List<City>> findAll() throws Exception{
        List<City> listVo = service.findAll();
        return ResponseEntity.ok(listVo);
    }

    @DeleteMapping(value = "/city", produces = Constants.APP_JSON)
    public ResponseEntity<String> delete(@RequestBody List<City> listType) throws Exception {
        service.delete(listType);
        return ResponseEntity.noContent().build();
    }
}
