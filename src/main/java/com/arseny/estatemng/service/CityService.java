package com.arseny.estatemng.service;

import com.arseny.estatemng.models.city.City;
import com.arseny.estatemng.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repo;

    public City save(City type){
        return repo.saveAndFlush(type);
    }

    public List<City> save(List<City> list){
        return repo.saveAll(list);
    }

    public List<City> findAll(){
        return repo.findAll();
    }

    public void delete(List<City> list){
        repo.deleteInBatch(list);
    }
}
