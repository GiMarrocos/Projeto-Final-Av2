package com.tomorrow.tomorrow.controllers;

import com.tomorrow.tomorrow.entities.User;
import com.tomorrow.tomorrow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping(path = "/users")
public class UserController {


    @Autowired
    private UserService service;

    @PostMapping(value = "/create")
    public ResponseEntity<User> create(@RequestBody User user){
        user = service.create(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();
        return created(uri).body(user);
    }

    @PutMapping(value = "/update/id/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        service.update(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/delete/id/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/find/id/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping(value = "/login/{login}-{password}")
    public ResponseEntity<User> validateUser(@PathVariable String login,@PathVariable String password){
        return ResponseEntity.ok().body(service.loginAuthentication(login, password));
    }
}
