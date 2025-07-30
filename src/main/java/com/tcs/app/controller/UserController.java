package com.tcs.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.app.model.Persons;
import com.tcs.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/userappStatus")
	public String userAppStatus() {
		
		return "User controller...........";
	}
			
	
	@GetMapping("/getperson")
	public  Persons getPersonDetails(@RequestParam String lastName) {
		
		return userService.getPersonByLastName(lastName);
		
	}
	
	@PostMapping("/addUser")
	public String addUserDetails(@RequestBody Persons persons) {
		
		return userService.addUser(persons);
	}
	
	@PostMapping("/updateUserById")
	public String updateUserDetails(@RequestBody Persons persons ) {
		
		return userService.updatePersonById(persons);
	}

}
