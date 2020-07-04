package com.arseny.estatemng.controller;

import com.arseny.estatemng.dto.AmenityDTO;
import com.arseny.estatemng.dto.TypeDTO;
import com.arseny.estatemng.entities.Amenity;
import com.arseny.estatemng.entities.TypeEstate;
import com.arseny.estatemng.service.Mapper;
import com.arseny.estatemng.service.TypeService;
import com.arseny.estatemng.utils.Constants;
import net.bytebuddy.description.type.TypeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TypeController {

    @Autowired
    private TypeService service;

    @Autowired
    private Mapper mapper;

    @PostMapping(value = "/type", produces = Constants.APP_JSON)
    public ResponseEntity<String> post(@RequestBody TypeDTO type) throws Exception {
        TypeEstate typeDTO = service.save(mapper.dtoToEntity(type));
        return ResponseEntity.ok(mapper.entityToJson(typeDTO));
    }
    @PostMapping(value = "/type/list", produces = Constants.APP_JSON)
    public ResponseEntity<String> post(@RequestBody List<TypeDTO> dtoList) throws Exception {
        List<TypeEstate> list = new ArrayList<>();
        dtoList.stream().forEach(o -> list.add(mapper.dtoToEntity(o)));
        return ResponseEntity.ok(mapper.entityToJson(list));
    }

    @GetMapping(value = "/type", produces = Constants.APP_JSON)
    public ResponseEntity<String> findAll() throws Exception{
        List<TypeEstate> listVo = service.findAll();
        return ResponseEntity.ok(mapper.entityToJson(listVo));
    }

    @DeleteMapping(value = "/type", produces = Constants.APP_JSON)
    public ResponseEntity<String> delete(@RequestBody List<TypeEstate> listType) throws Exception {
        service.delete(listType);
        return ResponseEntity.noContent().build();
    }
}
