package com.tomorrow.tomorrow.controllers;

import com.tomorrow.tomorrow.entities.Course;
import com.tomorrow.tomorrow.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping(path = "/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping(path = {"/list"})
    public ResponseEntity<List<Course>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(path = {"/find/id/{id}"})
    public ResponseEntity<Course> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Course> createNewTeacher(@RequestBody Course course){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(course.getCourseId()).toUri();
        return ResponseEntity.created(uri).body(service.save(course));
    }

    @PutMapping(path = "/update/id/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course,@PathVariable Long id) throws DataFormatException {
        course.setCourseId(id);
        service.updateCourse(course);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = {"/delete/id/{id}"})
    public ResponseEntity<?> deleteCourse(@PathVariable long id){
        service.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

}
