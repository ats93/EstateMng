package com.arseny.estatemng.controller;

import com.arseny.estatemng.models.area.AreaVO;
import com.arseny.estatemng.models.area.Area;
import com.arseny.estatemng.service.AreaService;
import com.arseny.estatemng.mapper.MapperWrapper;
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
    private MapperWrapper mapper;

    @PostMapping(value = "/area", produces = Constants.APP_JSON)
    public ResponseEntity<Area> post(@RequestBody AreaVO area) throws Exception {
        Area vo = service.save(mapper.convert(area));
        return ResponseEntity.ok(vo);
    }

    @PostMapping(value = "/area/list", produces = Constants.APP_JSON)
    public ResponseEntity<List<Area>> post(@RequestBody List<AreaVO> dtoList) throws Exception {
        List<Area> list = new ArrayList<>();
        dtoList.stream().forEach(o -> list.add(mapper.convert(o)));
        List<Area> vo = service.save(list);
        return ResponseEntity.ok(vo);
    }

    @GetMapping(value = "/area", produces = Constants.APP_JSON)
    public ResponseEntity<List<Area>> findAll() throws Exception{
        List<Area> listVo = service.findAll();
        return ResponseEntity.ok(listVo);
    }

    @DeleteMapping(value = "/area", produces = Constants.APP_JSON)
    public ResponseEntity<String> delete(@RequestBody List<Area> list) throws Exception {
        service.delete(list);
        return ResponseEntity.noContent().build();
    }
}
