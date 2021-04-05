package com.arseny.estatemng.repository;

import com.arseny.estatemng.models.estate.Estate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstateRepository extends JpaRepository<Estate, String> {
}
