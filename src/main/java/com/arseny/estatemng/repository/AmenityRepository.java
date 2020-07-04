package com.arseny.estatemng.repository;

import com.arseny.estatemng.entities.Amenity;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AmenityRepository extends JpaRepository<Amenity, String> {

}
