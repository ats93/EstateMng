package com.arseny.estatemng.controller;

import com.arseny.estatemng.dto.EstateDTO;
import com.arseny.estatemng.service.EstateService;
import com.arseny.estatemng.service.Mapper;
import com.arseny.estatemng.entities.Estate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EstateController {

    @Autowired
    private EstateService service;

    @Autowired
    private Mapper mapper;

    @PostMapping(value = "/estate", produces = "applications/json")
    public ResponseEntity<String> postEstate(@RequestBody EstateDTO estate) throws Exception {
        Estate estateVo = service.save(mapper.dtoToEntity(estate));
        EstateDTO dto = mapper.entityToDto(estateVo);
        return ResponseEntity.ok(mapper.entityToJson(dto));
    }

    @GetMapping(value = "/estate/{id}", produces = "application/json")
    public ResponseEntity<String> getEstate(@PathVariable String id) throws Exception{
        Estate estateVo = service.findOne(id);
        return ResponseEntity.ok(mapper.entityToJson(estateVo));
    }

    @GetMapping(value = "/estate", produces = "application/json")
    public ResponseEntity<String> findAll() throws Exception{
        List<Estate> listVo = service.findAll();
        return ResponseEntity.ok(mapper.entityToJson(listVo));
    }

    @PatchMapping(value = "/estate", produces = "application/json")
    public ResponseEntity<String> updateEstate(@RequestBody Estate estate) throws Exception {
        Estate estateVo = service.update(estate);
        if(estateVo.getCod()==null)
            throw new NoSuchElementException("Estate not found");
        EstateDTO dto = mapper.entityToDto(estateVo);
        return ResponseEntity.ok(mapper.entityToJson(dto));
    }
}
