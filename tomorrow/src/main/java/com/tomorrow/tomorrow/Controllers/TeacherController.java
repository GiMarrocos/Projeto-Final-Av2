package com.tomorrow.tomorrow.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tomorrow.tomorrow.entities.Teacher;
import com.tomorrow.tomorrow.services.TeacherService;

@RestController
@RequestMapping(path = "/teacher")
public class TeacherController {
	
	@Autowired
    private TeacherService teacherService;

	@GetMapping
    public ResponseEntity<List<Teacher>> findAll(){

        List<Teacher> teachers = teacherService.findAll();
        return ResponseEntity.ok().body(teachers);
    }

	@GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id){

        Teacher teacher = teacherService.findById(id);
        return ResponseEntity.ok().body(teacher);
    }

}
