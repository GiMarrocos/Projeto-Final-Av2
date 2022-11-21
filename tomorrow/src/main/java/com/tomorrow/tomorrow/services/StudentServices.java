package com.tomorrow.tomorrow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomorrow.tomorrow.entities.Student;
import com.tomorrow.tomorrow.repositories.StudentRepository;


@Service
public class StudentServices {
    
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public Student createNewStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student, Long id){
        student.setStudent_id(id);
        return studentRepository.save(student);
    }

    public void  deleteStudent(long id){
        studentRepository.deleteById(id);
    }
}
