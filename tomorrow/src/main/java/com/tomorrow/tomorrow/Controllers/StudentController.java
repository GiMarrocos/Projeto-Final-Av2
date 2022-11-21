package com.tomorrow.tomorrow.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomorrow.tomorrow.entities.Student;
import com.tomorrow.tomorrow.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        List<Student> students = studentService.findAll();
        return ResponseEntity.ok().body(students);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id){
        Student student = studentService.findById(id);
        return ResponseEntity.ok().body(student);

    }

    @PostMapping
    public ResponseEntity<Student> createNewStudent(@RequestBody Student student){
        student = studentService.save(student);
        return ResponseEntity.ok().body(student);
    }

}
