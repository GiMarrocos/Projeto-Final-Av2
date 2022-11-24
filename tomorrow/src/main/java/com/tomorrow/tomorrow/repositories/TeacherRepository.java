package com.tomorrow.tomorrow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomorrow.tomorrow.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long>{
    
}
