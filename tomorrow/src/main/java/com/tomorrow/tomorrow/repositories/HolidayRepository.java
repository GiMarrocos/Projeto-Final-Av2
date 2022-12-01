package com.tomorrow.tomorrow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomorrow.tomorrow.entities.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday,Long> {
	
}
