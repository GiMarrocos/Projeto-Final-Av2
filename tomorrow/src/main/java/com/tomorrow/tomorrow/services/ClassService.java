package com.tomorrow.tomorrow.services;


import com.tomorrow.tomorrow.entities.Class;
import com.tomorrow.tomorrow.entities.Student;
import com.tomorrow.tomorrow.entities.exceptions.EntityObjectNotFoundException;
import com.tomorrow.tomorrow.entities.exceptions.TeamNotFoundException;
import com.tomorrow.tomorrow.entities.util.FormatDataInput;
import com.tomorrow.tomorrow.repositories.ClassRepository;
import com.tomorrow.tomorrow.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassService extends FormatDataInput {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Class save(Class class_data){
        return classRepository.save(class_data);
    }

    public Class findById(Long id){
        Optional<Class> team =  classRepository.findById(id);
        return team.orElseThrow(() -> new TeamNotFoundException("Class not found! Id: " + id +
                "Cause type: " + Class.class.getName()));
    }

    public List<Class> findAll(){
        return classRepository.findAll();
    }

    public Class update(Class team){
        Class new_team_data = classRepository.getReferenceById(team.getId());
        if(team.getCourse_id() != null && team.getId() != null){
            new_team_data.setCourse_id(team.getCourse_id());
            new_team_data.setId(team.getId());
        }else if(team.getCourse_id() != null && team.getId() == null){
            new_team_data.setCourse_id(team.getCourse_id());
        }else if(team.getCourse_id() == null && team.getId() != null){
            new_team_data.setId(team.getId());
        }
        return classRepository.save(new_team_data);
    }


    public void delete(Long id){
        try{
            classRepository.deleteById(id);
        } catch (EmptyResultDataAccessException dataAccessException){
            throw new EntityObjectNotFoundException("Class not found! Id: " + id + "Cause type: "
                    + Class.class.getName());
        } catch (DataIntegrityViolationException dataIntegrityViolationException){
            dataIntegrityViolationException.getMessage();
        }
    }


}
