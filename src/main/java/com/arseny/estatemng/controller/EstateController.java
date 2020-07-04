package com.arseny.estatemng.controller;

import com.arseny.estatemng.dto.EstateDTO;
import com.arseny.estatemng.service.EstateService;
import com.arseny.estatemng.mapper.MapperWrapper;
import com.arseny.estatemng.entities.Estate;
import com.arseny.estatemng.service.Mapper;
import com.arseny.estatemng.utils.Constants;
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
    private MapperWrapper mapper;

    private Mapper jsonMapper;

    @PostMapping(value = "/estate", produces = "applications/json")
    public ResponseEntity<String> postEstate(@RequestBody EstateDTO estate) throws Exception {
        Estate estateVo = service.save(mapper.convert(estate));
        EstateDTO dto = mapper.convert(estateVo);
        return ResponseEntity.ok(jsonMapper.entityToJson(dto));
    }

    @GetMapping(value = "/estate/{id}", produces = Constants.APP_JSON)
    public ResponseEntity<String> getEstate(@PathVariable String id) throws Exception{
        Estate estateVo = service.findOne(id);
        return ResponseEntity.ok(jsonMapper.entityToJson(estateVo));
    }

    @GetMapping(value = "/estate", produces = Constants.APP_JSON)
    public ResponseEntity<String> findAll() throws Exception{
        List<Estate> listVo = service.findAll();
        return ResponseEntity.ok(jsonMapper.entityToJson(listVo));
    }

    @PatchMapping(value = "/estate", produces = Constants.APP_JSON)
    public ResponseEntity<String> updateEstate(@RequestBody Estate estate) throws Exception {
        Estate estateVo = service.update(estate);
        if(estateVo.getCod()==null)
            throw new NoSuchElementException("Estate not found");
        EstateDTO dto = mapper.convert(estateVo);
        return ResponseEntity.ok(jsonMapper.entityToJson(dto));
    }

    @DeleteMapping(value = "/estate", produces = Constants.APP_JSON)
    public ResponseEntity<String> delete(@RequestBody List<Estate> listEstate) throws Exception {
        service.delete(listEstate);
        return ResponseEntity.noContent().build();
    }
}
