package com.arseny.estatemng.controller;

import com.arseny.estatemng.models.type.TypeVO;
import com.arseny.estatemng.models.type.TypeEstate;
import com.arseny.estatemng.mapper.MapperWrapper;
import com.arseny.estatemng.service.TypeService;
import com.arseny.estatemng.utils.Constants;
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
    private MapperWrapper mapper;

    @PostMapping(value = "/type", produces = Constants.APP_JSON)
    public ResponseEntity<TypeEstate> post(@RequestBody TypeVO type) throws Exception {
        TypeEstate vo = service.save(mapper.convert(type));
        return ResponseEntity.ok(vo);
    }
    @PostMapping(value = "/type/list", produces = Constants.APP_JSON)
    public ResponseEntity<List<TypeEstate>> post(@RequestBody List<TypeVO> dtoList) throws Exception {
        List<TypeEstate> list = new ArrayList<>();
        dtoList.stream().forEach(o -> list.add(mapper.convert(o)));
        List<TypeEstate> vo = service.save(list);
        return ResponseEntity.ok(vo);
    }

    @GetMapping(value = "/type", produces = Constants.APP_JSON)
    public ResponseEntity<List<TypeEstate>> findAll() throws Exception{
        List<TypeEstate> listVo = service.findAll();
        return ResponseEntity.ok(listVo);
    }

    @DeleteMapping(value = "/type", produces = Constants.APP_JSON)
    public ResponseEntity<String> delete(@RequestBody List<TypeEstate> listType) throws Exception {
        service.delete(listType);
        return ResponseEntity.noContent().build();
    }
}
