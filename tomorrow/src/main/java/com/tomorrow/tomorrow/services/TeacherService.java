package com.tomorrow.tomorrow.services;

import com.tomorrow.tomorrow.entities.exceptions.EntityObjectNotFoundException;
import com.tomorrow.tomorrow.entities.exceptions.TeacherCreateFailureException;
import com.tomorrow.tomorrow.entities.util.FormatDataInput;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tomorrow.tomorrow.entities.Teacher;
import com.tomorrow.tomorrow.repositories.TeacherRepository;

@Service
public class TeacherService extends FormatDataInput {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher save(Teacher teacher) {
        try {
            teacher.setName(NAME_FORMAT(teacher.getName()));
            teacher.setPhone(NUMBER_FORMAT(teacher.getPhone()));
            teacher.setHourlyRate(teacher.getHourlyRate());
        } catch (RuntimeException violationException) {
            throw new TeacherCreateFailureException("Teacher registration failure");
        }
        return teacherRepository.save(teacher);
    }

    public Teacher findById(long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElseThrow(() -> new EntityObjectNotFoundException("Teacher not found Id" + id +
                "Cause type: " + Teacher.class.getName()));
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public void updateTeacher(Teacher teacher) throws DataFormatException {
        Teacher new_teacher_data = teacherRepository.getReferenceById(teacher.getTeacher_id());
        new_teacher_data = update_DATA(new_teacher_data, teacher);
        if (teacher.getPhone() == null && teacher.getHourlyRate() == null) {
            throw new DataFormatException("No change data has been entered");
        } else {
            teacherRepository.save(new_teacher_data);
        }
    }

    public void deleteTeacher(Long id){
        try {
            teacherRepository.deleteById(id);
        } catch (EmptyResultDataAccessException dataAccessException) {
            throw new EntityObjectNotFoundException("Teacher not found Id" + id +
            "Cause type: " + Teacher.class.getName());
        } catch (DataIntegrityViolationException dataIntegrityViolationException){
            dataIntegrityViolationException.getMessage();
        }
    }

    protected Teacher update_DATA(Teacher teacher, Teacher new_data) {
        if (new_data.getPhone() != null && new_data.getHourlyRate() != null) {
            teacher.setPhone(new_data.getPhone());
            teacher.setHourlyRate(new_data.getHourlyRate());
        } else if (new_data.getPhone() != null && new_data.getHourlyRate() == null) {
            teacher.setPhone(new_data.getPhone());
        } else if (new_data.getHourlyRate() != null && new_data.getPhone() == null) {
            teacher.setHourlyRate(new_data.getHourlyRate());
        }
        return teacher;
    }

}
