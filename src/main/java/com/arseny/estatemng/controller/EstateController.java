package com.arseny.estatemng.controller;

import com.arseny.estatemng.models.estate.EstatePost;
import com.arseny.estatemng.models.estate.EstateVO;
import com.arseny.estatemng.service.EstateService;
import com.arseny.estatemng.mapper.MapperWrapper;
import com.arseny.estatemng.models.estate.Estate;
import com.arseny.estatemng.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
public class EstateController {

    @Autowired
    private EstateService service;

    @Autowired
    private MapperWrapper mapper;

    @PostMapping(value = "/estate", produces = Constants.APP_JSON)
    public ResponseEntity<EstateVO> postEstate(@RequestBody EstatePost estate) throws Exception {
        Estate newEstate = service.save(mapper.convert(estate));
        EstateVO vo = mapper.convert(newEstate);
        return ResponseEntity.ok(vo);
    }

    @GetMapping(value = "/estate/{id}", produces = Constants.APP_JSON)
    public ResponseEntity<Estate> getEstate(@PathVariable String id) throws Exception{
        Estate estateVo = service.findOne(id);
        return ResponseEntity.ok(estateVo);
    }

    @GetMapping(value = "/estate", produces = Constants.APP_JSON)
    public ResponseEntity<List<EstateVO>> findAll() throws Exception{
        List<EstateVO> listVo = service.findAll().stream()
                .map(o -> mapper.convert(o)).collect(Collectors.toList());
        return ResponseEntity.ok(listVo);
    }

    @PatchMapping(value = "/estate", produces = Constants.APP_JSON)
    public ResponseEntity<EstateVO> updateEstate(@RequestBody Estate estate) throws Exception {
        Estate estateVo = service.update(estate);
        if(estateVo.getCod()==null)
            throw new NoSuchElementException("Estate not found");
        EstateVO vo = mapper.convert(estateVo);
        return ResponseEntity.ok(vo);
    }

    @DeleteMapping(value = "/estate", produces = Constants.APP_JSON)
    public ResponseEntity<String> delete(@RequestBody List<Estate> listEstate) throws Exception {
        service.delete(listEstate);
        return ResponseEntity.noContent().build();
    }
}
