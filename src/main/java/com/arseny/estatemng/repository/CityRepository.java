package com.arseny.estatemng.repository;

import com.arseny.estatemng.entities.City;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, String> {

}