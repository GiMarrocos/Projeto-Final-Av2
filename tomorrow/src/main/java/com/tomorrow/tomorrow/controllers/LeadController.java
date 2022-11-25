package com.tomorrow.tomorrow.controllers;

import java.net.URI;
import java.util.List;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tomorrow.tomorrow.entities.Lead;
import com.tomorrow.tomorrow.services.LeadService;

@RestController
@RequestMapping(path = "/lead")
public class LeadController {
    
    @Autowired
    private LeadService service;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Lead>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(path = {"/find/id/{id}"})
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Lead> createNewLead(@RequestBody Lead lead){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(lead.getId_lead()).toUri();
        return ResponseEntity.created(uri).body(service.create(lead));
    }

    @PutMapping(path = "update/id/{id}")
    public ResponseEntity<Lead> updateLead(@RequestBody Lead lead,@PathVariable Long id) throws DataFormatException{
        lead.setId_lead(id);
        service.updateLead(lead);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> deleteStudent(@PathVariable long id){
        service.deleteLead(id);
        return ResponseEntity.noContent().build();
    }
}
