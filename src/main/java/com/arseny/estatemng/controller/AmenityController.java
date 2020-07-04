package com.arseny.estatemng.controller;

import com.arseny.estatemng.dto.AmenityDTO;
import com.arseny.estatemng.entities.Amenity;
import com.arseny.estatemng.service.AmenityService;
import com.arseny.estatemng.service.Mapper;
import com.arseny.estatemng.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AmenityController {

    @Autowired
    private AmenityService service;

    @Autowired
    private Mapper mapper;

    @PostMapping(value = "/am", produces = Constants.APP_JSON)
    public ResponseEntity<String> post(@RequestBody AmenityDTO amenity) throws Exception {
        Amenity dto = service.save(mapper.dtoToEntity(amenity));
        return ResponseEntity.ok(mapper.entityToJson(dto));
    }

    @PostMapping(value = "/am/list", produces = Constants.APP_JSON)
    public ResponseEntity<String> post(@RequestBody List<AmenityDTO> dtoList) throws Exception {
        List<Amenity> list = new ArrayList<>();
        dtoList.stream().forEach(o -> list.add(mapper.dtoToEntity(o)));
        return ResponseEntity.ok(mapper.entityToJson(list));
    }

    @GetMapping(value = "/am", produces = Constants.APP_JSON)
    public ResponseEntity<String> findAll() throws Exception{
        List<Amenity> listVo = service.findAll();
        return ResponseEntity.ok(mapper.entityToJson(listVo));
    }

    @DeleteMapping(value = "/am", produces = Constants.APP_JSON)
    public ResponseEntity<String> delete(@RequestBody List<Amenity> list) throws Exception {
        service.delete(list);
        return ResponseEntity.noContent().build();
    }
}
