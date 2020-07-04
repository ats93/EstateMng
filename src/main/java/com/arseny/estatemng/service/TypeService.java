package com.arseny.estatemng.service;

import com.arseny.estatemng.entities.Amenity;
import com.arseny.estatemng.entities.TypeEstate;
import com.arseny.estatemng.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository repo;

    public TypeEstate save(TypeEstate type){
        return repo.saveAndFlush(type);
    }

    public List<TypeEstate> save(List<TypeEstate> list){
        return repo.saveAll(list);
    }

    public List<TypeEstate> findAll(){
        return repo.findAll();
    }

    public void delete(List<TypeEstate> list){
        repo.deleteInBatch(list);
    }
}
