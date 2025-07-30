package com.tcs.app.dao;

import com.tcs.app.model.Persons;

public interface UserDao {
	
	public Persons getPersonsByLastName(String lastName);

	public String addUser(Persons persons);

	public Integer getPersonById(Integer personId);

	public String updatePersonById(Persons persons);
	
	

}
