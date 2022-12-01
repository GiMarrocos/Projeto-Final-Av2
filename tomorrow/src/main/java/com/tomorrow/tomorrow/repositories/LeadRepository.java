package com.tomorrow.tomorrow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomorrow.tomorrow.entities.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead,Long>{
    
}
