package com.arseny.estatemng.repository;

import com.arseny.estatemng.entities.Estate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstateRepository extends JpaRepository<Estate, String> {
}
