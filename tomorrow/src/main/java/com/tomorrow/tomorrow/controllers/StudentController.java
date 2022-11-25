package com.tomorrow.tomorrow.controllers;

import java.net.URI;
import java.util.List;
import java.util.zip.DataFormatException;

import com.tomorrow.tomorrow.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.tomorrow.tomorrow.services.StudentService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(path = {"/find/id/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Student> createNewStudent(@RequestBody Student student){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(student.getId_student()).toUri();
        return ResponseEntity.created(uri).body(service.save(student));
    }
    
    @PutMapping(path = "update/id/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable long id) throws DataFormatException {
        student.setId_student(id);
        service.updateStudent(student);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> deleteStudent(@PathVariable long id){
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
