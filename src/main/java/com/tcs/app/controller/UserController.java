package com.tcs.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.tcs.app.model.Persons;
import com.tcs.app.service.UserService;


@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userappStatus")
    public ResponseEntity<String> userAppStatus() {
        return ResponseEntity.ok("User controller...........");
    }

    @GetMapping("/getperson")
    public ResponseEntity<Persons> getPersonDetails(@RequestParam String lastName) {
        Persons person = userService.getPersonByLastName(lastName);
        if (person != null) {
            return ResponseEntity.ok(person);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUserDetails(@RequestBody Persons persons) {
        String result = userService.addUser(persons);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/updateUserById")
    public ResponseEntity<String> updateUserDetails( @RequestBody Persons persons) {
        String result = userService.updatePersonById(persons);
        return ResponseEntity.ok(result);
    }
}