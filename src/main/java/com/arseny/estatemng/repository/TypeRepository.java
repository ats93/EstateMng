package com.arseny.estatemng.repository;

import com.arseny.estatemng.entities.TypeEstate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<TypeEstate, String> {

}
