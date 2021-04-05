package com.arseny.estatemng.repository;

import com.arseny.estatemng.models.area.Area;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, String> {

}
