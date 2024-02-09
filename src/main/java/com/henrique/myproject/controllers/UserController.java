package com.henrique.myproject.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.henrique.myproject.entities.User;
import com.henrique.myproject.services.UserService;

@RestController
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> allTasks() {
        List<User> tasks = userService.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createTask(@RequestBody User user) {
        User userCreated = userService.create(user);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable(value = "id") Integer id) {
        userService.delete(id);
    }
    
}
