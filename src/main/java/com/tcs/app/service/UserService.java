package com.tcs.app.service;

import com.tcs.app.model.Persons;

public interface UserService {
	
	public Persons getPersonByLastName(String lastName);

	public String addUser(Persons persons);

	public String updatePersonById(Persons persons);

}
