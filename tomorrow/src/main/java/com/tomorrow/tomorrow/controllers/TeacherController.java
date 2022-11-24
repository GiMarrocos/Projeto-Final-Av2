package com.tomorrow.tomorrow.controllers;


import java.net.URI;
import java.util.List;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tomorrow.tomorrow.entities.Teacher;
import com.tomorrow.tomorrow.services.TeacherService;

@RestController
@RequestMapping(path = "/teacher")
public class TeacherController {
    
    @Autowired
    TeacherService service;

    @GetMapping(path = {"/list"})
    public ResponseEntity<List<Teacher>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(path = {"/find/id/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Teacher> createNewTeacher(@RequestBody Teacher teacher){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(teacher.getTeacher_id()).toUri();
        return ResponseEntity.created(uri).body(service.save(teacher));
    }

    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher,@PathVariable Long id) throws DataFormatException{
        teacher.setTeacher_id(id);
        service.updateTeacher(teacher);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> deleteStudent(@PathVariable long id){
        service.deleteTeacher(id);;
        return ResponseEntity.noContent().build();
    }


}
