package com.tomorrow.tomorrow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomorrow.tomorrow.entities.Teacher;
import com.tomorrow.tomorrow.repositories.TeacherRepository;

public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

	public Teacher findById(Long id){
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.get();
    }

	public Teacher save(Teacher teacher){
        return teacherRepository.save(teacher);
    }


    public Teacher updateStudent(Teacher teacher, Long id){
        teacher.setTeacher_id(id);
        return teacherRepository.save(teacher);
    }

	public void  deleteStudent(long id){
        teacherRepository.deleteById(id);
    }
}
