package com.tomorrow.tomorrow.controllers;

import com.tomorrow.tomorrow.entities.Class;
import com.tomorrow.tomorrow.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/teams")
public class ClassController {

    @Autowired
    private ClassService service;


    @GetMapping(path = "/list")
    public ResponseEntity<List<Class>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(path = "/find/id/{id}")
    public ResponseEntity<Class> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Class> createNewTeam(@RequestBody Class team){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(team.getTeam_id()).toUri();
        return ResponseEntity.created(uri).body(service.save(team));
    }

    @PutMapping(path = "/update/id/{id}")
    public ResponseEntity<Class> updateTeam(@RequestBody Class team, @PathVariable Long id){
        team.setTeam_id(id);
        service.update(team);
        return ResponseEntity.noContent().build();
    }


}
