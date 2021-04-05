package com.arseny.estatemng.controller;

import com.arseny.estatemng.models.amenity.AmenityVO;
import com.arseny.estatemng.models.amenity.Amenity;
import com.arseny.estatemng.mapper.MapperWrapper;
import com.arseny.estatemng.service.AmenityService;
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
    private MapperWrapper mapper;

    @PostMapping(value = "/am", produces = Constants.APP_JSON)
    public ResponseEntity<Amenity> post(@RequestBody AmenityVO amenity) throws Exception {
        Amenity dto = service.save(mapper.convert(amenity));
        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/am/list", produces = Constants.APP_JSON)
    public ResponseEntity<List<Amenity>> post(@RequestBody List<AmenityVO> dtoList) throws Exception {
        List<Amenity> list = new ArrayList<>();
        dtoList.stream().forEach(o -> list.add(mapper.convert(o)));
        List<Amenity> vo = service.save(list);
        return ResponseEntity.ok(vo);
    }

    @GetMapping(value = "/am", produces = Constants.APP_JSON)
    public ResponseEntity<List<Amenity>> findAll() throws Exception{
        List<Amenity> listVo = service.findAll();
        return ResponseEntity.ok(listVo);
    }

    @DeleteMapping(value = "/am", produces = Constants.APP_JSON)
    public ResponseEntity<String> delete(@RequestBody List<Amenity> list) throws Exception {
        service.delete(list);
        return ResponseEntity.noContent().build();
    }
}
