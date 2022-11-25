package com.tomorrow.tomorrow.services;


import com.tomorrow.tomorrow.entities.Class;
import com.tomorrow.tomorrow.entities.exceptions.TeamNotFoundException;
import com.tomorrow.tomorrow.entities.util.FormatDataInput;
import com.tomorrow.tomorrow.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService extends FormatDataInput {

    @Autowired
    private ClassRepository classRepository;

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

    public void update(Class team){
        Class new_team_data = classRepository.getReferenceById(team.getTeam_id());
        if(team.getCourse_id() != null && team.getTeacher_id() != null){
            new_team_data.setCourse_id(team.getCourse_id());
            new_team_data.setTeacher_id(team.getTeacher_id());
        }else if(team.getCourse_id() != null && team.getTeacher_id() == null){
            new_team_data.setCourse_id(team.getCourse_id());
        }else if(team.getCourse_id() == null && team.getTeacher_id() != null){
            new_team_data.setTeacher_id(team.getTeacher_id());
        }
        classRepository.save(new_team_data);
    }





}
