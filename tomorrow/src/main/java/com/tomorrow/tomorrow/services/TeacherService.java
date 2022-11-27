package com.tomorrow.tomorrow.services;

import com.tomorrow.tomorrow.entities.Teacher;
import com.tomorrow.tomorrow.entities.exceptions.EntityObjectNotFoundException;
import com.tomorrow.tomorrow.entities.exceptions.TeacherNotFoundException;
import com.tomorrow.tomorrow.entities.util.FormatDataInput;
import com.tomorrow.tomorrow.repositories.TeacherRepository;
import com.tomorrow.tomorrow.services.exceptions.TeacherCreateFailureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
public class TeacherService extends FormatDataInput {

    @Autowired
    private TeacherRepository teacherRepository;

    //create
    public Teacher save(Teacher teacher){
        try{
            teacher.setName(NAME_FORMAT(teacher.getName()));
            teacher.setPhone(NUMBER_FORMAT(teacher.getPhone()));
        }catch (RuntimeException violationException){
            throw new TeacherCreateFailureException("Teacher registration failure");
        }
        return teacherRepository.save(teacher);
    }

    //read (by id)
    public Teacher findById(Long id){
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElseThrow(() -> new TeacherNotFoundException("Teacher not found" + id + "Cause type: "
        + Teacher.class.getName()));
    }

    //read (teacher list)
    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    //update
    public void updateTeacher(Teacher teacher) throws DataFormatException{
        Teacher new_teacher_data = teacherRepository.getReferenceById(teacher.getTeacher_id());
        if(!teacher.getHourlyRate().equals(null)) {
            throw new DataFormatException("No change data has been entered");
        }else{
            new_teacher_data = update_DATA(new_teacher_data, teacher);
        }
        teacherRepository.save(new_teacher_data);
    }

    public void deleteTeacher(Long id){
        try{
            teacherRepository.deleteById(id);
        }catch (EmptyResultDataAccessException dataAccessException){
            throw new EntityObjectNotFoundException("Teacher with id: " + id + " not found. "
            + "Unable to delete");
        }
    }

    //data change method
    private Teacher update_DATA(Teacher new_teacher_data, Teacher teacher) {
        teacher.setHourlyRate(new_teacher_data.getHourlyRate());
        return teacher;
    }
}
