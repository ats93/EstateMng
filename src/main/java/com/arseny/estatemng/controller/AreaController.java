package com.arseny.estatemng.controller;

import com.arseny.estatemng.dto.AreaDTO;
import com.arseny.estatemng.entities.Area;
import com.arseny.estatemng.service.AreaService;
import com.arseny.estatemng.service.Mapper;
import com.arseny.estatemng.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AreaController {

    @Autowired
    private AreaService service;

    @Autowired
    private Mapper mapper;

    @PostMapping(value = "/area", produces = Constants.APP_JSON)
    public ResponseEntity<String> post(@RequestBody AreaDTO area) throws Exception {
        Area dto = service.save(mapper.dtoToEntity(area));
        return ResponseEntity.ok(mapper.entityToJson(dto));
    }

    @PostMapping(value = "/area/list", produces = Constants.APP_JSON)
    public ResponseEntity<String> post(@RequestBody List<AreaDTO> dtoList) throws Exception {
        List<Area> list = new ArrayList<>();
        dtoList.stream().forEach(o -> list.add(mapper.dtoToEntity(o)));

        return ResponseEntity.ok(mapper.entityToJson(list));
    }

    @GetMapping(value = "/area", produces = Constants.APP_JSON)
    public ResponseEntity<String> findAll() throws Exception{
        List<Area> listVo = service.findAll();
        return ResponseEntity.ok(mapper.entityToJson(listVo));
    }

    @DeleteMapping(value = "/area", produces = Constants.APP_JSON)
    public ResponseEntity<String> delete(@RequestBody List<Area> list) throws Exception {
        service.delete(list);
        return ResponseEntity.noContent().build();
    }
}
