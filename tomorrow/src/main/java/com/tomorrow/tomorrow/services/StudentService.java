package com.tomorrow.tomorrow.services;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

import com.tomorrow.tomorrow.entities.exceptions.EntityObjectNotFoundException;
import com.tomorrow.tomorrow.entities.exceptions.StudentCreateFailureException;
import com.tomorrow.tomorrow.entities.util.FormatDataInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tomorrow.tomorrow.entities.Student;
import com.tomorrow.tomorrow.repositories.StudentRepository;

@Service
public class StudentService extends FormatDataInput {
    
    @Autowired
    private StudentRepository studentRepository;

    //create
    public Student save(Student student){
        try{
            student.setName(NAME_FORMAT(student.getName()));
            student.setAddress(NAME_FORMAT(student.getAddress()));
            student.setPhone(NUMBER_FORMAT(student.getPhone()));
            student.setCpf(NAME_FORMAT(student.getCpf()));
        } catch (RuntimeException violationException){
            throw new StudentCreateFailureException("Student registration failure");
        }
        return studentRepository.save(student);
    }

    //read (by id)
    public Student findById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        return student.orElseThrow(() -> new EntityObjectNotFoundException("Student not found! Id:" + id +
                "Cause type: " + Student.class.getName()));
    }

    //red (student list)
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    //update
    public void updateStudent(Student student) throws DataFormatException {
        Student new_student_data = studentRepository.getReferenceById(student.getId_student());
        new_student_data = update_DATA(new_student_data, student);
        if(student.getAddress() == null && student.getPhone() == null){
            throw new DataFormatException("No change data has been entered");
        }else{
            studentRepository.save(new_student_data);
        }
    }

    //delete
    public void  deleteStudent(Long id){
        try {
            studentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException dataAccessException){
            throw new EntityObjectNotFoundException("Student not found! Id: " + id + "Cause type: "
                    + Student.class.getName());
        } catch (DataIntegrityViolationException dataIntegrityViolationException){
            dataIntegrityViolationException.getMessage();
        }
    }

    //data change method
    protected Student update_DATA(Student student, Student new_data){
        //permission to change phone and address only
        if(new_data.getAddress() != null && new_data.getPhone() != null) {
            student.setAddress(new_data.getAddress());
            student.setPhone(new_data.getPhone());
        }else if (new_data.getAddress() != null && new_data.getPhone() == null){
            student.setAddress(new_data.getAddress());
        }else if (new_data.getPhone() != null && new_data.getAddress() ==null){
            student.setPhone(new_data.getPhone());
        }
        return student;
    }
}
