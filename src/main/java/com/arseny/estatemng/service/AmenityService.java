package com.arseny.estatemng.service;

import com.arseny.estatemng.entities.Amenity;
import com.arseny.estatemng.entities.TypeEstate;
import com.arseny.estatemng.repository.AmenityRepository;
import com.arseny.estatemng.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityService {

    @Autowired
    private AmenityRepository repo;

    public Amenity save(Amenity amenity){
        return repo.saveAndFlush(amenity);
    }

    public List<Amenity> save(List<Amenity> list){
        return repo.saveAll(list);
    }

    public List<Amenity> findAll(){
        return repo.findAll();
    }

    public void delete(List<Amenity> list){
        repo.deleteInBatch(list);
    }
}
