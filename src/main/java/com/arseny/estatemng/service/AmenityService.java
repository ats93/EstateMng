package com.arseny.estatemng.service;

import com.arseny.estatemng.models.amenity.Amenity;
import com.arseny.estatemng.repository.AmenityRepository;
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
        List<Amenity> vo = repo.saveAll(list);
        repo.flush();
        return vo;
    }

    public List<Amenity> findAll(){
        return repo.findAll();
    }

    public void delete(List<Amenity> list){
        repo.deleteInBatch(list);
    }
}
