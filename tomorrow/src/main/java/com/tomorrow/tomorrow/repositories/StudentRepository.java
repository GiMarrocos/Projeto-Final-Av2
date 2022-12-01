package com.tomorrow.tomorrow.repositories;

import com.tomorrow.tomorrow.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
