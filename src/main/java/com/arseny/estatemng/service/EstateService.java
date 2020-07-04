package com.arseny.estatemng.service;

import com.arseny.estatemng.entities.Estate;
import com.arseny.estatemng.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstateService {

    @Autowired
    private EstateRepository repo;

    public Estate findOne(String id){
        return repo.findById(id).get();
    }

    public Estate save(Estate estate){
        estate.setOriginalPrice(estate.getPrice());
        return repo.saveAndFlush(estate);
    }

    public List<Estate> findAll(){
        return repo.findAll();
    }

    public Estate update(Estate newEstate){
        Estate oldEstate = findOne(newEstate.getCod());

        if(newEstate.getOriginalPrice() != null && newEstate.getOriginalPrice() == 0)
            newEstate.setOriginalPrice(null);

        if(newEstate.getOriginalPrice() != null && newEstate.getOriginalPrice().compareTo(newEstate.getPrice()) > 0){
            newEstate.setLowered(true);
            Long perc = Math.round( ( (newEstate.getOriginalPrice() - newEstate.getPrice()) / newEstate.getOriginalPrice()) * 100 );
            newEstate.setPercentage("-" + perc + "%");
        } else{
            newEstate.setLowered(false);
            newEstate.setPercentage(null);
        }

        return repo.saveAndFlush(newEstate);
    }

    public void delete(List<Estate> list){
        repo.deleteInBatch(list);
    }
}
