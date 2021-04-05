package com.arseny.estatemng.service;

import com.arseny.estatemng.models.area.Area;
import com.arseny.estatemng.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    private AreaRepository repo;

    public Area save(Area type){
        return repo.saveAndFlush(type);
    }

    public List<Area> save(List<Area> list){
        return repo.saveAll(list);
    }

    public List<Area> findAll(){
        return repo.findAll();
    }

    public void delete(List<Area> list){
        repo.deleteInBatch(list);
    }
}
