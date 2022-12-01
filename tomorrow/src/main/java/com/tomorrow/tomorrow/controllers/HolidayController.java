package com.tomorrow.tomorrow.controllers;

import com.tomorrow.tomorrow.entities.Holiday;
import com.tomorrow.tomorrow.services.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.zip.DataFormatException;

@RestController
@RequestMapping(path = "/holidays")
public class HolidayController {

	@Autowired
    private HolidayService service;

	@GetMapping(path = {"/list"})
    public ResponseEntity<List<Holiday>> findAll(){

        return ResponseEntity.ok().body(service.findAll());

    }

    @GetMapping(path = {"/find/id/{id}"})
    public ResponseEntity<Holiday> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(service.findById(id));
    }

	@PostMapping(path = "/create")
    public ResponseEntity<Holiday> createNewTeacher(@RequestBody Holiday holiday){

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(holiday.getHoliday_id()).toUri();

        return ResponseEntity.created(uri).body(service.save(holiday));

    }

    @PutMapping(path = "/update/id/{id}")
    public ResponseEntity<Holiday> updateHoliday(@RequestBody Holiday holiday,@PathVariable Long id) throws DataFormatException {

        holiday.setHoliday_id(id);

        service.updateHoliday(holiday);

        return ResponseEntity.noContent().build();

    }

	@DeleteMapping(path = {"/delete/id/{id}"})
    public ResponseEntity<?> deleteHoliday(@PathVariable long id){

        service.deleteHoliday(id);
        return ResponseEntity.noContent().build();
    }
}
