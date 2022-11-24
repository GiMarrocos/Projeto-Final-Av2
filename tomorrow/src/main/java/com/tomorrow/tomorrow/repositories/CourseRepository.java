package com.tomorrow.tomorrow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomorrow.tomorrow.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{
	
}
