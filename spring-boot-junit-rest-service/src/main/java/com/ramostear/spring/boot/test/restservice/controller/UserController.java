package com.ramostear.spring.boot.test.restservice.controller;

import com.ramostear.spring.boot.test.restservice.model.Role;
import com.ramostear.spring.boot.test.restservice.model.User;
import com.ramostear.spring.boot.test.restservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private  final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<User> findAllStudents(){
        return userService.findAllUsers();
    }

    @GetMapping(value = "/users/{id}/roles")
    public List<Role> findUserRoles(@PathVariable(value = "id")String id){
        return userService.findUserAllRoles(id);
    }

    @PostMapping(value = "/users/{id}")
    public ResponseEntity<Object> setUserRole(@PathVariable(value = "id")String id, @RequestBody Role role){
        userService.addUserRole(id,role);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }

}
